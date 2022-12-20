package com.example.shogiproject.gui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.shogiproject.R

class Recycler_adapter(context: Context, recyclerModel: ArrayList<RecyclerModel>, recyclerViewClickInterface: RecyclerViewClickInterface) :
    RecyclerView.Adapter<Recycler_adapter.MyViewHolder>() {

    val recyclerViewClickInterface: RecyclerViewClickInterface

    val context: Context
    val recyclerModel: ArrayList<RecyclerModel>

    init {
        this.context = context
        this.recyclerModel = recyclerModel
        this.recyclerViewClickInterface = recyclerViewClickInterface
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Recycler_adapter.MyViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.recycler_view_row, parent, false)
        return Recycler_adapter.MyViewHolder(view, recyclerViewClickInterface)
    }

    override fun onBindViewHolder(holder: Recycler_adapter.MyViewHolder, position: Int) {
        holder.textView1.setText(recyclerModel.get(position).catName)
        holder.textView2.setText(recyclerModel.get(position).dogName)
    }

    override fun getItemCount(): Int {
        return recyclerModel.size
    }

    class MyViewHolder : RecyclerView.ViewHolder {

        lateinit var textView1: TextView
        lateinit var textView2: TextView

        constructor(@NonNull itemView: View, recyclerViewClickInterface: RecyclerViewClickInterface) : super(itemView) {
            textView1 = itemView.findViewById(R.id.textView1)
            textView2 = itemView.findViewById(R.id.textView2)

            itemView.setOnClickListener(View.OnClickListener {
                if (recyclerViewClickInterface != null) {
                    val pos: Int = adapterPosition

                    if (pos != RecyclerView.NO_POSITION) {
                        recyclerViewClickInterface.onItemClick(pos)
                    }
                }
            })
        }

    }

}