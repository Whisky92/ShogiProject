package com.example.shogiproject.model.piecetype

import com.example.shogiproject.model.mainparts.Board
import com.example.shogiproject.model.mainparts.Piece
import com.example.shogiproject.model.mainparts.Position
import com.example.shogiproject.model.types.Direction

class Lance : PieceType {

    private val board: Board = Board.getInstance()

    private val goldSteps: GoldSteps = GoldSteps.getInstance()

    private var canEvolve: Boolean = false

    private var isEvolved: Boolean = false

    override fun getIsEvolved(): Boolean {
        return isEvolved
    }

    override fun getCanEvolve(): Boolean {
        return canEvolve
    }

    override fun setCanEvolve() {
        canEvolve = true
    }

    override fun setCannotEvolve() {
        canEvolve = false
    }

    override fun evolve() {
        isEvolved = true
    }

    override fun devolve() {
        isEvolved = false
    }

    override fun showSteps(piece: Piece): ArrayList<Position> {
        if (!isEvolved) {
            val possibleSteps: ArrayList<Position> = ArrayList()
            val direction: Direction = if (board.getPlayer1().getColor() == piece.getColor())
                board.getPlayer1().getDirection() else board.getPlayer2().getDirection()
            if (direction == Direction.BOTTOM) {
                possibleSteps.addAll(getTopSteps(piece))
            } else {
                possibleSteps.addAll(getBottomSteps(piece))
            }
            return possibleSteps
        } else {
            return goldSteps.showSteps(piece)
        }
    }

    private fun getTopSteps(piece: Piece): ArrayList<Position> {
        val possibleSteps: ArrayList<Position> = ArrayList()
        val pos: Position = board.getPositionByCoords(piece.getX(), piece.getY())
        for (i in (pos.getX() + 1)..8) {
            val currentPos: Position = board.getTable()[i][pos.getY()]!!
            if (currentPos.isOccupied()) {
                if (pos.getCellType() == currentPos.getCellType()) {
                    break
                } else {
                    possibleSteps.add(currentPos)
                    break
                }
            } else {
                possibleSteps.add(currentPos)
            }
        }
        return possibleSteps
    }

    private fun getBottomSteps(piece: Piece): ArrayList<Position> {
        val possibleSteps: ArrayList<Position> = ArrayList()
        val pos: Position = board.getPositionByCoords(piece.getX(), piece.getY())
        for (i in (pos.getX() - 1)downTo 0) {
            val currentPos: Position = board.getTable()[i][pos.getY()]!!
            if (currentPos.isOccupied()) {
                if (pos.getCellType() == currentPos.getCellType()) {
                    break
                } else {
                    possibleSteps.add(currentPos)
                    break
                }
            } else {
                possibleSteps.add(currentPos)
            }
        }
        return possibleSteps
    }
}