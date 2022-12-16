package com.example.shogiproject.model.mainparts

import com.example.shogiproject.model.piecetype.PieceType
import com.example.shogiproject.model.types.Color

class Piece(x : Int, y : Int, pieceType: PieceType, color: Color) {

    private var x: Int

    private var y: Int

    private val pieceType: PieceType

    private var color: Color

    init {
        this.x = x
        this.y = y
        this.pieceType = pieceType
        this.color = color
    }

    fun getX(): Int {
        return this.x
    }

    fun setX(x: Int) {
        this.x = x
    }

    fun getY(): Int {
        return this.y
    }

    fun setY(y: Int) {
        this.y = y
    }

    fun getPieceType(): PieceType {
        return this.pieceType
    }

    fun getColor(): Color {
        return this.color
    }

    fun setColor(color: Color) {
        this.color = color
    }

    fun setAbleToEvolve() {
        pieceType.setCanEvolve()
    }

    fun isAbleToEvolve(): Boolean {
        return pieceType.getCanEvolve()
    }

    fun evolvePiece() {
        pieceType.evolve()
    }
}