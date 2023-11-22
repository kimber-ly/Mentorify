package com.example.mentorify.Adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mentorify.Models.SearchPageKategoriModel
import com.example.mentorify.R

class KategoriSearchPage(
    var items : List<SearchPageKategoriModel>,
    var listener : AdapterListener
): RecyclerView.Adapter<KategoriSearchPage.ViewHolder>(){

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val icon = itemView.findViewById<ImageView>(R.id.icon_kategori_searchpage)
        val name = itemView.findViewById<TextView>(R.id.label_kategori_searchpage)
        val arrow = itemView.findViewById<ImageView>(R.id.icon_arrow_searchpage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.category_list_searchpage, parent, false)
    )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.icon.setImageResource(item.icon)
        holder.name.text = item.name
        holder.arrow.setImageResource(item.arrow)

        holder.itemView.setOnClickListener{
            listener.onClick(item)
        }
    }

    interface AdapterListener {
        fun onClick(category: SearchPageKategoriModel)
    }

}