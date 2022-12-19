package com.example.rockpaperscissors.database

import android.app.Application
import androidx.lifecycle.LiveData

class ResultRepository(private val resultDao: ResultDao) {
    var allResults: LiveData<List<com.example.rockpaperscissors.database.Result>>
    init {
        allResults = resultDao.getAllResults()
    }

    suspend fun insertResult(name: String, playerWins: Int, botWins: Int, draws: Int) {
        val result: com.example.rockpaperscissors.database.Result = Result(name, playerWins, botWins, draws)
        resultDao.insert(result)
    }

    suspend fun deleteResult(name: String, playerWins: Int, botWins: Int, draws: Int) {
        val result: com.example.rockpaperscissors.database.Result = Result(name, playerWins, botWins, draws)
        resultDao.delete(result)
    }
}