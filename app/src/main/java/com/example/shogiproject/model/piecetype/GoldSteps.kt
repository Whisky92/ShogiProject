package com.example.shogiproject.model.piecetype

import com.example.shogiproject.model.mainparts.Board
import com.example.shogiproject.model.mainparts.Piece
import com.example.shogiproject.model.mainparts.Position
import com.example.shogiproject.model.types.Direction

class GoldSteps {

    companion object {

        private var goldStepInstance: GoldSteps? = null

        fun getInstance(): GoldSteps {
            if (goldStepInstance == null) {
                goldStepInstance = GoldSteps()
            }
            return goldStepInstance!!
        }
    }

    private val board: Board = Board.getInstance()

    fun showSteps(piece: Piece, direction: Int): ArrayList<Position> {
        val possibleSteps: ArrayList<Position> = ArrayList()
        val pos: Position = board.getPositionByCoords(piece.getX(), piece.getY())
        val currentX: Int = pos.getX()
        val currentY: Int = pos.getY()
        possibleSteps.addAll(checkCell(currentX + 1 * direction, currentY, piece))
        possibleSteps.addAll(checkCell(currentX + 1 * direction, currentY + 1, piece))
        possibleSteps.addAll(checkCell(currentX + 1 * direction, currentY - 1, piece))
        possibleSteps.addAll(checkCell(currentX - 1 * direction, currentY, piece))
        possibleSteps.addAll(checkCell(currentX, currentY + 1, piece))
        possibleSteps.addAll(checkCell(currentX, currentY - 1, piece))
        return possibleSteps

    }

    fun checkCell(x: Int, y: Int, piece: Piece): ArrayList<Position> {
        val step: ArrayList<Position> = ArrayList()
        val pos: Position = board.getPositionByCoords(piece.getX(),piece.getY())
        if (x > -1 && x < 9 && y > -1 && y < 9) {
            val current: Position = board.getTable()[x][y]!!
            if (current.isOccupied()) {
                if (pos.getCellType() != current.getCellType()) {
                    step.add(current)
                    return step
                }
            } else {
                step.add(current)
                return step
            }
        }
        return step
    }
}