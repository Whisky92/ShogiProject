package model

import com.example.shogiproject.model.mainparts.Board
import com.example.shogiproject.model.mainparts.Piece
import com.example.shogiproject.model.mainparts.Player
import com.example.shogiproject.model.mainparts.Position
import com.example.shogiproject.model.piecetype.*
import com.example.shogiproject.model.types.CellType
import com.example.shogiproject.model.types.Color
import com.example.shogiproject.model.types.Direction
import java.util.concurrent.ThreadLocalRandom

class GameRound {
    val board: Board = Board.getInstance()

    private lateinit var player1: Player

    private lateinit var player2: Player

    private lateinit var currentPlayer: Player

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

    fun getGameBoard(): Board {
        return board
    }

    init {
        player1 = Player(direction = Direction.BOTTOM)
        player2 = Player(direction = Direction.TOP)
        rollFirstPlayer()
        placePieces()
    }


    fun changeCurrentPlayer() {
        if (currentPlayer.getLastMovedPiece().getPieceType().getIsEvolved()) {
            currentPlayer.getLastMovedPiece().getPieceType().setCannotEvolve()
        }
        currentPlayer = if (currentPlayer == player1) player2 else player1
    }

    private fun rollFirstPlayer() {
        var oneCount: Int = 0
        var zeroCount: Int = 0
        for(i in 0..4) {
            val x: Int = ThreadLocalRandom.current().nextInt(2)
            if(x == 1) {
                oneCount++
            } else {
                zeroCount++
            }
        }
        if (oneCount > zeroCount) {
            currentPlayer = player1
            player1.setColor(Color.BLACK)
            player2.setColor(Color.WHITE)
        } else {
            currentPlayer = player2
            player2.setColor(Color.BLACK)
            player1.setColor(Color.WHITE)
        }
    }

    fun placePieces() {
        val bottomColor: CellType = if (currentPlayer.getColor() == Color.BLACK) CellType.BLACK else CellType.WHITE
        val topColor: CellType = if (bottomColor == CellType.BLACK) CellType.WHITE else CellType.BLACK

        for (i in 0..8) {
            for (j in 0..8) {
                board.getTable()[i][j] = Position(i, j, null, CellType.NONE)
            }
        }
        placeBottomPieces(bottomColor)
        placeTopPieces(topColor)

    }

    private fun placeBottomPieces(bottomColor: CellType) {
        for (i in 2..2) {
            for (j in 0..8) {
                board.getTable()[i][j]!!.setPiece(Piece(i, j, Pawn(), player1.getColor()))
                board.getTable()[i][j]!!.setCellType(bottomColor)
                player1.addToOwnedPositions(board.getTable()[i][j]!!)

            }
        }
        board.getTable()[5][4]!!.setPiece(Piece(5, 4, King(), player1.getColor()))
        board.getTable()[5][4]!!.setCellType(bottomColor)
        player1.addToOwnedPositions(board.getTable()[5][4]!!)
        board.getTable()[1][1]!!.setPiece(Piece(1, 1, Bishop(), player1.getColor()))
        board.getTable()[1][1]!!.setCellType(bottomColor)
        player1.addToOwnedPositions(board.getTable()[1][1]!!)
        board.getTable()[1][7]!!.setPiece(Piece(1, 7, Rook(), player1.getColor()))
        board.getTable()[1][7]!!.setCellType(bottomColor)
        player1.addToOwnedPositions(board.getTable()[1][7]!!)
        board.getTable()[0][0]!!.setPiece(Piece(0, 0, Lance(), player1.getColor()))
        board.getTable()[0][0]!!.setCellType(bottomColor)
        player1.addToOwnedPositions(board.getTable()[0][0]!!)
        board.getTable()[0][1]!!.setPiece(Piece(0, 1, Knight(), player1.getColor()))
        board.getTable()[0][1]!!.setCellType(bottomColor)
        player1.addToOwnedPositions(board.getTable()[0][1]!!)
        board.getTable()[0][2]!!.setPiece(Piece(0, 2, Silver(), player1.getColor()))
        board.getTable()[0][2]!!.setCellType(bottomColor)
        player1.addToOwnedPositions(board.getTable()[0][2]!!)
        board.getTable()[0][3]!!.setPiece(Piece(0, 3, Gold(), player1.getColor()))
        board.getTable()[0][3]!!.setCellType(bottomColor)
        player1.addToOwnedPositions(board.getTable()[0][3]!!)
        board.getTable()[0][4]!!.setPiece(Piece(0, 4, Lance(), player1.getColor()))
        board.getTable()[0][4]!!.setCellType(bottomColor)
        player1.addToOwnedPositions(board.getTable()[0][4]!!)
        board.getTable()[0][5]!!.setPiece(Piece(0, 5, Gold(), player1.getColor()))
        board.getTable()[0][5]!!.setCellType(bottomColor)
        player1.addToOwnedPositions(board.getTable()[0][5]!!)
        board.getTable()[0][6]!!.setPiece(Piece(0, 6, Silver(), player1.getColor()))
        board.getTable()[0][6]!!.setCellType(bottomColor)
        player1.addToOwnedPositions(board.getTable()[0][6]!!)
        board.getTable()[0][7]!!.setPiece(Piece(0, 7, Knight(), player1.getColor()))
        board.getTable()[0][7]!!.setCellType(bottomColor)
        player1.addToOwnedPositions(board.getTable()[0][7]!!)
        board.getTable()[0][8]!!.setPiece(Piece(0, 8, Lance(), player1.getColor()))
        board.getTable()[0][8]!!.setCellType(bottomColor)
        player1.addToOwnedPositions(board.getTable()[0][8]!!)

    }

    private fun placeTopPieces(topColor: CellType) {
        for (i in 6..6) {
            for (j in 0..8) {
                board.getTable()[i][j]!!.setPiece(Piece(i, j, Pawn(), player2.getColor()))
                board.getTable()[i][j]!!.setCellType(topColor)
                player2.addToOwnedPositions(board.getTable()[i][j]!!)
            }

        }

        board.getTable()[7][7]!!.setPiece(Piece(7, 7, Bishop(), player2.getColor()))
        board.getTable()[7][7]!!.setCellType(topColor)
        player2.addToOwnedPositions(board.getTable()[7][7]!!)
        board.getTable()[7][1]!!.setPiece(Piece(7, 1, Rook(), player2.getColor()))
        board.getTable()[7][1]!!.setCellType(topColor)
        player2.addToOwnedPositions(board.getTable()[7][1]!!)
        board.getTable()[8][0]!!.setPiece(Piece(8, 0, Lance(), player2.getColor()))
        board.getTable()[8][0]!!.setCellType(topColor)
        player2.addToOwnedPositions(board.getTable()[8][0]!!)
        board.getTable()[8][1]!!.setPiece(Piece(8, 1, Knight(), player2.getColor()))
        board.getTable()[8][1]!!.setCellType(topColor)
        player2.addToOwnedPositions(board.getTable()[8][1]!!)
        board.getTable()[8][2]!!.setPiece(Piece(8, 2, Silver(), player2.getColor()))
        board.getTable()[8][2]!!.setCellType(topColor)
        player2.addToOwnedPositions(board.getTable()[8][2]!!)
        board.getTable()[8][3]!!.setPiece(Piece(8, 3, Gold(), player2.getColor()))
        board.getTable()[8][3]!!.setCellType(topColor)
        player2.addToOwnedPositions(board.getTable()[8][3]!!)
        board.getTable()[8][4]!!.setPiece(Piece(8, 4, King(), player2.getColor()))
        board.getTable()[8][4]!!.setCellType(topColor)
        player2.addToOwnedPositions(board.getTable()[8][4]!!)
        board.getTable()[8][5]!!.setPiece(Piece(8, 5, Gold(), player2.getColor()))
        board.getTable()[8][5]!!.setCellType(topColor)
        player2.addToOwnedPositions(board.getTable()[8][5]!!)
        board.getTable()[8][6]!!.setPiece(Piece(8, 6, Silver(), player2.getColor()))
        board.getTable()[8][6]!!.setCellType(topColor)
        player2.addToOwnedPositions(board.getTable()[8][6]!!)
        board.getTable()[8][7]!!.setPiece(Piece(8, 7, Knight(), player2.getColor()))
        board.getTable()[8][7]!!.setCellType(topColor)
        player2.addToOwnedPositions(board.getTable()[8][7]!!)
        board.getTable()[8][8]!!.setPiece(Piece(8, 8, Lance(), player2.getColor()))
        board.getTable()[8][8]!!.setCellType(topColor)
        player2.addToOwnedPositions(board.getTable()[8][8]!!)
    }

}