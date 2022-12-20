package com.example.shogiproject.gui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shogiproject.databinding.ActivityWebDataBinding
import com.example.shogiproject.databinding.ItemMyPostItemBinding
import com.example.shogiproject.web.MyPostItem

class WebDataAdapterRecyclerView : RecyclerView.Adapter<WebDataAdapterRecyclerView.WebDataViewHolder>() {

    inner class WebDataViewHolder(val binding: ItemMyPostItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<MyPostItem>() {
        override fun areItemsTheSame(oldItem: MyPostItem, newItem: MyPostItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MyPostItem, newItem: MyPostItem): Boolean {
            return oldItem == newItem
        }
    }
    private val differ = AsyncListDiffer(this, diffCallback)
    var myPostItems: List<MyPostItem>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun getItemCount() = myPostItems.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WebDataViewHolder {
        return WebDataViewHolder(
            ItemMyPostItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: WebDataViewHolder, position: Int) {
        holder.binding.apply {
            val myPost = myPostItems[position]
            itemEmail.text = myPost.email
            itemName.text = myPost.name
        }
    }
}