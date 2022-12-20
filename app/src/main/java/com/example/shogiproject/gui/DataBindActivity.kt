package com.example.shogiproject.gui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.rockpaperscissors.model.DataIncr
import com.example.shogiproject.R
import com.example.shogiproject.databinding.DataLayoutBinding
import com.example.shogiproject.web.RetrofitInstance

class DataBindActivity : AppCompatActivity() {
    private lateinit var viewModel: DataIncr
    private lateinit var binding: DataLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.data_layout)
        viewModel = ViewModelProvider(this).get(DataIncr::class.java)

        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        binding.addData.setOnClickListener {
            viewModel.incr()
        }
    }
}