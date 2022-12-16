package com.example.shogiproject.model.piecetype

import com.example.shogiproject.model.mainparts.Piece
import com.example.shogiproject.model.mainparts.Position

interface PieceType {

    fun setCanEvolve()

    fun setCannotEvolve()

    fun evolve()

    fun devolve()

    fun getCanEvolve(): Boolean

    fun getIsEvolved(): Boolean

    fun showSteps(piece: Piece) : ArrayList<Position>

}