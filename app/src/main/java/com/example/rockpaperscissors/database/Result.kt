package com.example.rockpaperscissors.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Result(
    @ColumnInfo(name = "player") val name: String,
    @ColumnInfo(name = "player_wins") val playerWins: Int,
    @ColumnInfo(name = "bot_wins") val botWins: Int,
    @ColumnInfo(name = "draws") val draws: Int
)
{
    @PrimaryKey(autoGenerate = true) var uid: Int? = null

}