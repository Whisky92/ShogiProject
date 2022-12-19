package com.example.rockpaperscissors.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ResultDao {
    @Query("SELECT * FROM Result")
    fun getAllResults(): LiveData<List<com.example.rockpaperscissors.database.Result>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg result: com.example.rockpaperscissors.database.Result)

    @Delete
    suspend fun delete(result: com.example.rockpaperscissors.database.Result)
}