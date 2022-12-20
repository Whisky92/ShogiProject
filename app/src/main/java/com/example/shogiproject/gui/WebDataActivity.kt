package com.example.shogiproject.gui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shogiproject.R
import com.example.shogiproject.databinding.ActivityWebDataBinding
import com.example.shogiproject.web.RetrofitInstance
import retrofit2.HttpException
import java.io.IOException

class WebDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebDataBinding

    private lateinit var webDataAdapterRecyclerView: WebDataAdapterRecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()

        lifecycleScope.launchWhenCreated {
            binding.progressBar.isVisible = true
            val response = try {
                RetrofitInstance.api.getPostItems()
            } catch (e: IOException) {
                Log.e("WebDataActivity", "IOException occured")
                binding.progressBar.isVisible = false
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e("WebDataActivity", "HttpException occured")
                binding.progressBar.isVisible = false
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null) {
                webDataAdapterRecyclerView.myPostItems = response.body()!!
            } else {
                Log.e("WebDataActivity", "Response unsuccessful")
            }
            binding.progressBar.isVisible = false
        }

    }
    private fun setupRecyclerView() = binding.myRecyclerView.apply {
        webDataAdapterRecyclerView = WebDataAdapterRecyclerView()
        adapter = webDataAdapterRecyclerView
        layoutManager = LinearLayoutManager(this@WebDataActivity)
    }
}