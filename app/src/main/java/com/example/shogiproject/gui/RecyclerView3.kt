package com.example.shogiproject.gui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.shogiproject.R

class RecyclerView3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view_3)

        val dogName = intent.getStringExtra("DOG_NAME")
        val catName = intent.getStringExtra("CAT_NAME")
        val personName = intent.getStringExtra("PERSON_NAME")

        val textView1 = findViewById<TextView>(R.id.textView3)
        val textView2 = findViewById<TextView>(R.id.textView4)
        val textView3 = findViewById<TextView>(R.id.textView5)

        textView1.setText(dogName)
        textView2.setText(catName)
        textView3.setText(personName)
    }
}