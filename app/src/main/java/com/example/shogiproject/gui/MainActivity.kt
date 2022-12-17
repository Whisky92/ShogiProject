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

        var btnPiece = findViewById<Button>(R.id.piece_button)
        btnPiece.setOnClickListener {
            val intent = Intent(this, PieceActivity::class.java)
            startActivity(intent)
        }

    }

}