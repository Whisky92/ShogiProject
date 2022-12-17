package com.example.shogiproject.model.piecetype

import com.example.shogiproject.model.mainparts.Board
import com.example.shogiproject.model.mainparts.Piece
import com.example.shogiproject.model.mainparts.Position

class Bishop : PieceType {

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

    override fun showSteps(piece: Piece, direction: Int): ArrayList<Position> {
        val possibleSteps: ArrayList<Position> = ArrayList()
        possibleSteps.addAll(getTopRightSteps(piece))
        possibleSteps.addAll(getTopLeftSteps(piece))
        possibleSteps.addAll(getBottomRightSteps(piece))
        possibleSteps.addAll(getBottomLeftSteps(piece))
        if (isEvolved) {
            possibleSteps.addAll(goldSteps.checkCell(piece.getX() + 1, piece.getY(), piece))
            possibleSteps.addAll(goldSteps.checkCell(piece.getX() - 1, piece.getY(), piece))
            possibleSteps.addAll(goldSteps.checkCell(piece.getX(), piece.getY() + 1, piece))
            possibleSteps.addAll(goldSteps.checkCell(piece.getX(), piece.getY() - 1, piece))
        }
        return possibleSteps
    }

    private fun getTopRightSteps(piece: Piece): ArrayList<Position> {
        val possibleSteps: ArrayList<Position> = ArrayList()
        val pos: Position = board.getPositionByCoords(piece.getX(), piece.getY())
        var currentX: Int = pos.getX() + 1
        var currentY: Int = pos.getY() + 1
        lateinit var currentPos: Position
        while(currentX < 9 && currentY < 9) {
            currentPos = board.getTable()[currentX][currentY]!!
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
            currentX++
            currentY++
        }
        return possibleSteps
    }

    private fun getTopLeftSteps(piece: Piece): ArrayList<Position> {
        val possibleSteps: ArrayList<Position> = ArrayList()
        val pos: Position = board.getPositionByCoords(piece.getX(), piece.getY())
        var currentX: Int = pos.getX() - 1
        var currentY: Int = pos.getY() + 1
        lateinit var currentPos: Position
        while(currentX > -1 && currentY < 9) {
            currentPos = board.getTable()[currentX][currentY]!!
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
            currentX--
            currentY++
        }
        return possibleSteps
    }

    private fun getBottomRightSteps(piece: Piece): ArrayList<Position> {
        val possibleSteps: ArrayList<Position> = ArrayList()
        val pos: Position = board.getPositionByCoords(piece.getX(), piece.getY())
        var currentX: Int = pos.getX() + 1
        var currentY: Int = pos.getY() - 1
        lateinit var currentPos: Position
        while(currentX < 9 && currentY > -1) {
            currentPos = board.getTable()[currentX][currentY]!!
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
            currentX++
            currentY--
        }
        return possibleSteps
    }

    private fun getBottomLeftSteps(piece: Piece): ArrayList<Position> {
        val possibleSteps: ArrayList<Position> = ArrayList()
        val pos: Position = board.getPositionByCoords(piece.getX(), piece.getY())
        var currentX: Int = pos.getX() - 1
        var currentY: Int = pos.getY() - 1
        lateinit var currentPos: Position
        while(currentX > -1 && currentY > -1) {
            currentPos = board.getTable()[currentX][currentY]!!
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
            currentX--
            currentY--
        }
        return possibleSteps
    }
}