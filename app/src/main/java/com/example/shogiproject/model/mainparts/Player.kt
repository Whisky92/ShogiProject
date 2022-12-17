package com.example.shogiproject.model.mainparts

import com.example.shogiproject.model.piecetype.Gold
import com.example.shogiproject.model.piecetype.King
import com.example.shogiproject.model.piecetype.Pawn
import com.example.shogiproject.model.piecetype.PieceType
import com.example.shogiproject.model.types.CellType
import com.example.shogiproject.model.types.Color
import com.example.shogiproject.model.types.Direction

class Player(direction: Direction) {

    private lateinit var lastMovedPiece: Piece

    private lateinit var color: Color

    private val direction: Direction

    private val capturedPieces: ArrayList<Piece>

    private val ownedPositions: ArrayList<Position>

    private val board: Board = Board.getInstance()

    init {
        this.color = Color.BLACK
        this.direction = direction
        this.capturedPieces = ArrayList()
        this.ownedPositions = ArrayList()
    }

    fun getLastMovedPiece(): Piece {
        return lastMovedPiece
    }

    fun getColor(): Color {
        return this.color
    }

    fun setColor(color: Color) {
        this.color = color
    }

    fun getDirection(): Direction {
        return this.direction
    }

    fun getCapturedPieces(): ArrayList<Piece> {
        return this.capturedPieces
    }

    fun getOwnedPositions(): ArrayList<Position> {
        return this.ownedPositions
    }

    fun addToOwnedPositions(position: Position) {
        ownedPositions.add(position)
    }

    fun removeFromOwnedPositions(position: Position) {
        ownedPositions.remove(position)
    }

    fun capture(piece: Piece) {
        capturedPieces.add(piece)
    }

    fun release(piece: Piece) {
        capturedPieces.remove(piece)
    }

    fun getPossibleSteps(position: Position): ArrayList<Position> {
        return position.getPiece()!!.getPieceType().showSteps(position.getPiece()!!, direction.getValueOfDirection())
    }

    fun isCorrectStep(from: Position, to: Position): Boolean {
        return getPossibleSteps(from).contains(to)
    }

    fun getKingPosition(): Position {
        for(i in 0 until (ownedPositions.size)) {
            if (this.getOwnedPositions().get(i).getPiece()!!.getPieceType()::class == King::class) {
                return ownedPositions.get(i)
            }
        }
        return Position(0, 0, Piece(0, 0, Pawn(), Color.BLACK), CellType.BLACK)
    }

    fun isKingTargeted(otherPlayer: Player): Boolean {
        val position: Position = getKingPosition()
        return isCellTargeted(position, otherPlayer)
    }

    fun isKingCellsTargeted(otherPlayer: Player): Boolean {
        val position: Position = getKingPosition()
        for(i in 0 until getPossibleSteps(position).size) {
            if(!isCellTargeted(getPossibleSteps(position).get(i),otherPlayer)) {
                return false
            }
        }
        return (isKingTargeted(otherPlayer))
    }


    private fun isCellTargeted(position: Position, byThisPlayer: Player): Boolean {
        for(i in 0 until byThisPlayer.ownedPositions.size) {
            if(byThisPlayer.getPossibleSteps(byThisPlayer.getOwnedPositions().get(i)).contains(position)) {
                return true
            }
        }
        return false
    }

    fun movePiece(from: Position, to: Position, otherPlayer: Player) {
        val positions: ArrayList<Position> = from.getPiece()!!.getPieceType().showSteps(from.getPiece()!!, direction.getValueOfDirection())

        if (from.getPiece()!!.getPieceType()::class != Gold::class
            && from.getPiece()!!.getPieceType()::class != King::class) {
            if (this.direction == Direction.BOTTOM) {
                if (listOf<Int>(6,7,8).contains(to.getX()) || listOf<Int>(6,7,8).contains(from.getX())) {
                    from.getPiece()!!.setAbleToEvolve()
                }
            } else {
                if (listOf<Int>(0, 1, 2).contains(to.getX()) || listOf<Int>(0, 1, 2).contains(from.getX())) {
                    from.getPiece()!!.setAbleToEvolve()
                }
            }
        }
        if(positions.contains(to)) {
            if (to.isOccupied()) {
                to.getPiece()!!.getPieceType().devolve()
                capture(to.getPiece()!!)
                to.getPiece()!!.setX(-1)
                to.getPiece()!!.setY(-1)
                to.getPiece()!!.setColor(from.getPiece()!!.getColor())
                otherPlayer.getOwnedPositions().remove(to)
            }
            removeFromOwnedPositions(from)
            addToOwnedPositions(to)
            to.setPiece(from.getPiece()!!)
            to.setCellType(from.getCellType())
            from.setPiece(null)
            from.setCellType(CellType.NONE)
            to.getPiece()!!.setX(to.getX())
            to.getPiece()!!.setY(to.getY())
            lastMovedPiece = to.getPiece()!!
        }
    }

    fun isCorrectPlaceForCapturedPlace(piece: Piece, position: Position): Boolean {
        return getPossiblePlacesForCapturedPieces(piece).contains(position)
    }

    fun getPossiblePlacesForCapturedPieces(piece: Piece): ArrayList<Position> {
        val possibleCells: ArrayList<Position> = ArrayList()
        if (piece.getPieceType()::class != Pawn::class) {
            for(i in 0 until 9) {
                for(j in 0 until 9) {
                    if(!board.getTable()[i][j]!!.isOccupied()) {
                        possibleCells.add(board.getTable()[i][j]!!)
                    }
                }
            }
        } else {
            for(i in 0 until 9) {
                var current: ArrayList<Position> = ArrayList()
                for (j in 0 until 9) {
                    if(!board.getTable()[j][i]!!.isOccupied()) {
                        current.add(board.getTable()[j][i]!!)
                    } else if (board.getTable()[j][i]!!.getPiece()!!.getPieceType()::class == Pawn::class
                        && board.getTable()[j][i]!!.getPiece()!!.getColor() == piece.getColor()) {
                        current.clear()
                        break
                    }
                }
                possibleCells.addAll(current)
                current.clear()
            }
        }
        return possibleCells
    }

    fun placeCapturedPiece(piece: Piece, position: Position) {
        this.addToOwnedPositions(position)
        release(piece)
        piece.setX(position.getX())
        piece.setY(position.getY())
        val cellType: CellType = if (this.color == Color.BLACK) CellType.BLACK else CellType.WHITE
        position.setCellType(cellType)
        position.setPiece(piece)
    }
}