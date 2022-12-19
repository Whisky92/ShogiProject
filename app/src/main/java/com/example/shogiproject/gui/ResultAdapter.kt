package com.example.shogiproject.gui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shogiproject.R

class ResultAdapter : RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {

    private var list = mutableListOf<com.example.rockpaperscissors.database.Result>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.result_view_holder, parent,false)

        return ResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val user = list[position]
        holder.playerName.text = user.name
        holder.playerCount.text = user.playerWins.toString()
        holder.botCount.text = user.botWins.toString()
    }

    override fun getItemCount() = list.size

    fun setData(data: List<com.example.rockpaperscissors.database.Result>) {

    }

    class ResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val playerName: TextView = itemView.findViewById(R.id.holder_text_name)
        val playerCount: TextView = itemView.findViewById(R.id.holder_text_player_count)
        val botCount: TextView = itemView.findViewById(R.id.holder_text_bot_count)
        val drawCount: TextView = itemView.findViewById(R.id.holder_text_draws)
    }
}