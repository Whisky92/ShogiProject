package com.example.shogiproject.gui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shogiproject.R

class RecyclerView2 : AppCompatActivity(), RecyclerViewClickInterface{

    val models: ArrayList<RecyclerModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view_2)

        val recyclerView: RecyclerView = findViewById(R.id.my_recycler_view)

        setUpModelValues()

        val adapter: Recycler_adapter = Recycler_adapter(this, models, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
    private fun setUpModelValues() {
        val dogs: Array<String> = arrayOf("dog1","dog2","dog3")
        val cats: Array<String> = arrayOf("cat1","cat2","cat3")
        val people: Array<String> = arrayOf("person1","person2","person3")

        for (i in 0 until dogs.size) {
            models.add(RecyclerModel(dogs[i],cats[i],people[i]))
        }
    }

    override fun onItemClick(position: Int) {
        val intent: Intent = Intent(this, RecyclerView3::class.java)

        intent.putExtra("DOG_NAME", models.get(position).dogName)
        intent.putExtra("CAT_NAME", models.get(position).catName)
        intent.putExtra("PERSON_NAME", models.get(position).personName)

        startActivity(intent)
    }
}