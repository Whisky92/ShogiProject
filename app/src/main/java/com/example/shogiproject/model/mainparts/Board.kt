package com.example.shogiproject.model.mainparts

import com.example.shogiproject.model.piecetype.*
import com.example.shogiproject.model.types.CellType
import com.example.shogiproject.model.types.Color
import com.example.shogiproject.model.types.Direction
import java.util.Random

class Board {

    companion object {
        private var boardInstance: Board? = null

        fun getInstance(): Board {
            if (boardInstance == null) {
                boardInstance = Board()
            }
            return boardInstance!!
        }
    }

    private var table: Array<Array<Position?>>

    init {
        table = Array(9) { arrayOfNulls(9) }
    }


    fun getTable(): Array<Array<Position?>> {
        return table
    }

    fun getPositionByCoords(x: Int, y: Int): Position {
        return table[x][y]!!
    }


    fun printTable() {
        for(i in 8 downTo 0) {
            for (j in 0 until 9) {
               // print(if(table[i][j]!!.getPiece() == null) "üres " else table[i][j]!!.getPiece()!!.getPieceType()!!)
                print(table[i][j]!!.getCellType())
            }
            println()
        }
    }

}