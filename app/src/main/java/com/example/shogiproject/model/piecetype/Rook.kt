package com.example.shogiproject.model.piecetype

import com.example.shogiproject.model.mainparts.Board
import com.example.shogiproject.model.mainparts.Piece
import com.example.shogiproject.model.mainparts.Position

class Rook : PieceType {

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
        possibleSteps.addAll(getTopSteps(piece))
        possibleSteps.addAll(getBottomSteps(piece))
        possibleSteps.addAll(getRightSteps(piece))
        possibleSteps.addAll(getLeftSteps(piece))
        if (isEvolved) {
            possibleSteps.addAll(goldSteps.checkCell(piece.getX() + 1, piece.getY() + 1, piece))
            possibleSteps.addAll(goldSteps.checkCell(piece.getX() + 1, piece.getY() - 1, piece))
            possibleSteps.addAll(goldSteps.checkCell(piece.getX() - 1, piece.getY() + 1, piece))
            possibleSteps.addAll(goldSteps.checkCell(piece.getX() - 1, piece.getY() - 1, piece))
        }
        return possibleSteps
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


    private fun getLeftSteps(piece: Piece): ArrayList<Position> {
        val possibleSteps: ArrayList<Position> = ArrayList()
        val pos: Position = board.getPositionByCoords(piece.getX(), piece.getY())
        for (i in (pos.getY() - 1)downTo 0) {
            val currentPos: Position = board.getTable()[pos.getX()][i]!!
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

    private fun getRightSteps(piece: Piece): ArrayList<Position> {
        val possibleSteps: ArrayList<Position> = ArrayList()
        val pos: Position = board.getPositionByCoords(piece.getX(), piece.getY())
        for (i in (pos.getY() + 1).. 8) {
            val currentPos: Position = board.getTable()[pos.getX()][i]!!
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