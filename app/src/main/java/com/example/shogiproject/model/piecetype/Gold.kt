package com.example.shogiproject.model.piecetype

import com.example.shogiproject.model.mainparts.Board
import com.example.shogiproject.model.mainparts.Piece
import com.example.shogiproject.model.mainparts.Position

class Gold : PieceType {

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
        return goldSteps.showSteps(piece, direction)
    }
}