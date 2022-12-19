package com.example.rockpaperscissors.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.rockpaperscissors.database.Result
import com.example.rockpaperscissors.database.ResultDatabase
import com.example.rockpaperscissors.database.ResultRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ResultViewModel(application: Application) : AndroidViewModel(application) {

    val allResults: LiveData<List<Result>>
    private val repository: ResultRepository

    init {
        val resultDao = ResultDatabase.getInstance(application).resultDao()
        repository = ResultRepository(resultDao)
        allResults = repository.allResults
    }

    fun insertResult(name: String, playerWins: Int, botWins: Int, draws: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertResult(name, playerWins, botWins, draws)
        }
    }

    fun deleteResult(name: String, playerWins: Int, botWins: Int, draws: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteResult(name, playerWins, botWins, draws)
        }
    }
}