package com.example.shogiproject.gui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.example.shogiproject.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPiece = findViewById<Button>(R.id.piece_button)
        btnPiece.setOnClickListener {
            val intent = Intent(this, PieceActivity::class.java)
            startActivity(intent)
        }


        val btnGame = findViewById<Button>(R.id.play_button)
        btnGame.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }

        val btnRps = findViewById<Button>(R.id.rock_paper_scissors_button)
        btnRps.setOnClickListener {
            val intent = Intent(this, RpsActivity::class.java)
            startActivity(intent)
        }

        val btnDatas = findViewById<Button>(R.id.btn_data_bind)
        btnDatas.setOnClickListener {
            val intent = Intent(this, DataBindActivity::class.java)
            startActivity(intent)
        }

        val btnWebData = findViewById<Button>(R.id.web_data)
        btnWebData.setOnClickListener {
            val intent = Intent(this, WebDataActivity::class.java)
            startActivity(intent)
        }

        val btnRecycler2 = findViewById<Button>(R.id.btn_recycler_2)
        btnRecycler2.setOnClickListener {
            val intent = Intent(this, RecyclerView2::class.java)
            startActivity(intent)
        }

    }

}