package com.vicksoson.hope.api

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vicksoson.hope.R

class DataAdapter(
    private
    var dataList: List<RecyclerResponse>, private val context: Context
) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.home_list_items, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = dataList.get(position)
        //holder.size.text = dataModel.size
        holder.title.text = dataModel.title
        holder.length.text = dataModel.length

    }

    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        var title: TextView = itemLayoutView.findViewById(R.id.item_name)
        var length: TextView = itemLayoutView.findViewById(R.id.length_value)
        //var size: TextView = itemLayoutView.findViewById(R.id.size_value)
        // image: ImageView = itemLayoutView.findViewById(R.id.item_img)
    }
//    fun filterList(filteredNames: ArrayList < RecyclerResponse > ) {
//        Log.e("list", filteredNames.toString())
//        Log.e("list", filteredNames.size.toString())
//        // this.dataList.clear()
//        this.dataList = filteredNames
//        notifyDataSetChanged()
//    }
}