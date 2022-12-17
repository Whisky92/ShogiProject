package com.example.shogiproject.gui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.shogiproject.R
import com.example.shogiproject.databinding.ActivityMainBinding

class PieceActivity : AppCompatActivity() {

  //  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_piece)

     /*   val btnBasic = findViewById<Button>(R.id.btn_basic_form)
        btnBasic.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainerView,BasicFormFragment())
            fragmentTransaction.commit()

        }

        val btnEvolved = findViewById<Button>(R.id.btn_evolved_form)
        btnEvolved.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainerView,EvolvedFormFragment())
            fragmentTransaction.commit()

        } */
    }
}