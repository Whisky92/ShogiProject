package com.example.shogiproject.model.mainparts

import com.example.shogiproject.model.types.Color
import com.example.shogiproject.model.types.Direction

class Player(color: Color, direction: Direction) {

    private lateinit var lastMovedPiece: Piece

    private var color: Color

    private val direction: Direction

    private val capturedPieces: ArrayList<Piece>

    private val ownedPositions: ArrayList<Position>

    private val board: Board = Board.getInstance()

    init {
        this.color = color
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

    fun capture(piece: Piece) {
        capturedPieces.add(piece)
    }

    fun release(piece: Piece) {
        capturedPieces.remove(piece)
    }

    fun getPossibleSteps(position: Position): ArrayList<Position> {
        return position.getPiece()!!.getPieceType().showSteps(position.getPiece()!!)
    }

    fun isCorrectStep(from: Position, to: Position): Boolean {
        return getPossibleSteps(from).contains(to)
    }

}