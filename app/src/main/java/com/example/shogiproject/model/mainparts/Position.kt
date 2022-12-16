package com.example.shogiproject.model.mainparts

import com.example.shogiproject.model.types.CellType

class Position(x: Int, y: Int, piece: Piece?, cellType: CellType) {

    private final val board : Board = Board.getInstance()

    private val x: Int

    private val y: Int

    private var piece: Piece?

    private var cellType: CellType

    init {
        this.x = x
        this.y = y
        this.piece = piece
        this.cellType = cellType
    }

    fun getX(): Int {
        return this.x
    }

    fun getY(): Int {
        return this.y
    }

    fun getPiece(): Piece? {
        return this.piece
    }

    fun setPiece(piece: Piece?) {
        this.piece = piece
    }

    fun getCellType(): CellType {
        return this.cellType
    }

    fun setCellType(cellType: CellType) {
        this.cellType = cellType
    }

    fun isOccupied(): Boolean {
        return cellType == CellType.BLACK || cellType == CellType.WHITE
    }

}