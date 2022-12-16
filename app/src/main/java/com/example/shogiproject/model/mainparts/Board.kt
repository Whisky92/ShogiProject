package com.example.shogiproject.model.mainparts

import com.example.shogiproject.model.types.CellType
import com.example.shogiproject.model.types.Color
import com.example.shogiproject.model.types.Direction
import java.util.Random

class Board {

    companion object {
        private var boardInstance: Board? = null

        public fun getInstance(): Board {
            if (boardInstance == null) {
                boardInstance = Board()
            }
            return boardInstance!!
        }
    }

    private lateinit var player1: Player

    private lateinit var player2: Player

    private lateinit var currentPlayer: Player

    private lateinit var table: Array<Array<Position?>>

    fun getPlayer1(): Player {
        return player1
    }

    fun getPlayer2(): Player {
        return player2
    }

    fun getCurrentPlayer(): Player {
        return currentPlayer
    }

    fun setCurrentPlayer(player: Player) {
        this.currentPlayer = player
    }

    fun getTable(): Array<Array<Position?>> {
        return table
    }

    init {
        table = Array(9) { arrayOfNulls(9) }
    }

    fun getPlayerByColor(color: Color): Player {
        return if (player1.getColor() == color) player1 else player2
    }

    fun getPositionByCoords(x: Int, y: Int): Position {
        return table[x][y]!!
    }

    fun initialize() {
        player1 = Player(color = Color.BLACK, direction = Direction.BOTTOM)
        player2 = Player(color = Color.WHITE, direction = Direction.TOP)
        currentPlayer = player1
    }

    private fun rollFirstPlayer() {
        val random: Random = Random()
        var oneCount: Int = 0
        var zeroCount: Int = 0
        for(i in 0..5) {
            val x: Int = random.nextInt(2)
            if(x == 1) {
                oneCount++
            } else {
                zeroCount++
            }
        }
    }

    fun placePieces() {
        val bottomColor: CellType = if (currentPlayer.getColor() == Color.BLACK) CellType.BLACK else CellType.WHITE
        val topColor: CellType = if (bottomColor == CellType.BLACK) CellType.WHITE else CellType.BLACK

        for (i in 0..8) {
            for (j in 0..8) {
                table[i][j] = Position(i, j, null, CellType.NONE)
            }
        }

        for (i in 2..2) {
            for (j in 0..9) {
                table[i][j]!!.setPiece(Piece(i, j))
            }
        }

    }

}