package com.example.shogiproject.gui

import android.graphics.Color
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TableRow
import androidx.core.content.ContextCompat
import androidx.core.view.get
import com.example.shogiproject.R
import model.GameRound

class GameActivity : AppCompatActivity() {

    lateinit var gameTable: TableLayout

    lateinit var game: GameRound

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        gameTable = findViewById<TableLayout>(R.id.game_table)
        game = GameRound()
        fillBoard()
    }

    fun fillBoard() {

            val row = gameTable.getChildAt(2) as TableRow
            for (j in 0 until row.childCount) {
                val imgView = getGuiCoordAt(2, j)
              //  imgView.setBackground(getDrawable(R.drawable.border_possible))
                imgView.setImageResource(R.drawable.pawn_piece)
            }
        var imgView = getGuiCoordAt(0,8)
        imgView.setImageResource(R.drawable.lance_piece)
        imgView = getGuiCoordAt(0, 0)
        imgView.setImageResource(R.drawable.lance_piece)
        imgView = getGuiCoordAt(0, 2)
        imgView.setImageResource(R.drawable.silver_piece)
        imgView = getGuiCoordAt(0, 6)
        imgView.setImageResource(R.drawable.silver_piece)

        }

    fun getGuiCoordAt(x: Int, y: Int): ImageView {
        val guiX: Int = 8-x
        val guiY: Int = y
        val imgView = (gameTable.getChildAt(guiX) as TableRow).getChildAt(guiY) as ImageView
        return imgView
    }
}