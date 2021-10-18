package com.vicksoson.hope.ui.homescreen

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vicksoson.hope.databinding.HomeListItemsBinding
import com.vicksoson.hope.model.Items

class ItemAdapter(private val onItemClick:Clicks):RecyclerView.Adapter<ItemAdapter.ItemViewholder>() {

    private val items = mutableListOf<Items>()

    inner class ItemViewholder(private val binding: HomeListItemsBinding):RecyclerView.ViewHolder(binding.root){
        fun bindItem(items: Items){
            binding.lengthValue.text = items.length
            binding.sizeValue.text = items.size
            binding.itemName.text = items.title
            //binding.itemImg.setImageResource(items.image)
        }
        val cardTitle:TextView=binding.itemName

    }

    fun setupItems(items: List<Items>){
        this.items.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder {
        return ItemViewholder(
            HomeListItemsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewholder, position: Int) {
        val items = items[position]
        holder.bindItem(items)

        holder.cardTitle.setOnClickListener {
            onItemClick.onClick(items.title)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}