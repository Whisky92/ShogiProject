package com.example.shogiproject.gui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.shogiproject.R
import com.example.shogiproject.databinding.ActivityMainBinding
import com.example.shogiproject.databinding.ActivityPieceBinding

class PieceActivity : AppCompatActivity() {

    lateinit var binding: ActivityPieceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPieceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBasicForm.setOnClickListener {
            replaceFragment(BasicFormFragment())
        }

        binding.btnEvolvedForm.setOnClickListener {
            replaceFragment(EvolvedFormFragment())
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}