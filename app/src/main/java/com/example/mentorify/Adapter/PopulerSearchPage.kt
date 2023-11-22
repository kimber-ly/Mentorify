package com.example.mentorify.Adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mentorify.Models.SearchPagePopularModel
import com.example.mentorify.R

class PopulerSearchPage(
    var items : List<SearchPagePopularModel>,
    var listener : AdapterListener
): RecyclerView.Adapter<PopulerSearchPage.ViewHolder>(){

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.item_name_searchpage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.popular_list_searchpage, parent, false)
    )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.name.text = item.name
        holder.itemView.setOnClickListener{
            listener.onClick(item)
        }
    }

    interface AdapterListener {
        fun onClick(feature : SearchPagePopularModel)
    }

}