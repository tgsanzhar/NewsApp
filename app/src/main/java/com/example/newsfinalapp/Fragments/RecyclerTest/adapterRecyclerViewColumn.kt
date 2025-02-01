package com.example.newsfinalapp.Fragments.RecyclerTest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfinalapp.databinding.ItemColumnBinding
import com.example.newsfinalapp.databinding.ItemFilterBinding

class adapterRecyclerViewColumn (): ListAdapter<ChipItem, adapterRecyclerViewColumn.ViewHolder>(ChipItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemColumnBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(
        private val binding: ItemColumnBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ChipItem) {
            binding.name.text = item.name
        }
    }

    class ChipItemDiffUtil: DiffUtil.ItemCallback<ChipItem>() {

        override fun areItemsTheSame(oldItem: ChipItem, newItem: ChipItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ChipItem, newItem: ChipItem): Boolean {
            return oldItem == newItem
        }
    }
}
