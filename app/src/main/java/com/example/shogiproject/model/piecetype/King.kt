package com.example.shogiproject.model.piecetype

import com.example.shogiproject.model.mainparts.Board
import com.example.shogiproject.model.mainparts.Piece
import com.example.shogiproject.model.mainparts.Position

class King : PieceType {

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
        val possibleSteps: ArrayList<Position> = ArrayList()
        val pos: Position = board.getPositionByCoords(piece.getX(), piece.getY())
        val currentX: Int = pos.getX()
        val currentY: Int = pos.getY()
        possibleSteps.addAll(goldSteps.checkCell(currentX + 1, currentY, piece))
        possibleSteps.addAll(goldSteps.checkCell(currentX + 1, currentY + 1, piece))
        possibleSteps.addAll(goldSteps.checkCell(currentX, currentY + 1, piece))
        possibleSteps.addAll(goldSteps.checkCell(currentX - 1, currentY + 1, piece))
        possibleSteps.addAll(goldSteps.checkCell(currentX - 1, currentY, piece))
        possibleSteps.addAll(goldSteps.checkCell(currentX - 1, currentY - 1, piece))
        possibleSteps.addAll(goldSteps.checkCell(currentX, currentY - 1, piece))
        possibleSteps.addAll(goldSteps.checkCell(currentX + 1, currentY - 1, piece))
        return possibleSteps
    }
}