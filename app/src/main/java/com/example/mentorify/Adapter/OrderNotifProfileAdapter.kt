package com.example.mentorify.Adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mentorify.Models.MentorCardModel
import com.example.mentorify.Models.OrderNotifProfileModel
import com.example.mentorify.OverviewActivity
import com.example.mentorify.R


class OrderNotifProfileAdapter(
    var items: List<OrderNotifProfileModel>,
    var listener: AdapterListener
): RecyclerView.Adapter<OrderNotifProfileAdapter.ViewHolder>(){

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.image_order_notif_profile_card)
        val title: TextView = itemView.findViewById(R.id.title_order_notif_profile_card)
        val id: TextView = itemView.findViewById(R.id.id_order_notif_profile_card)
        val date: TextView = itemView.findViewById(R.id.date_order_notif_profile_card)
        val time: TextView = itemView.findViewById(R.id.time_order_notif_profile_card)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.order_notif_profile_card, parent, false)
    )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.image.setImageResource(item.image)
        holder.title.text = item.title
        holder.id.text = item.id
        holder.date.text = item.date
        holder.time.text = item.time

        holder.itemView.setOnClickListener{
            listener.onClick(item)
        }
    }

    interface AdapterListener {
        fun onClick(orderCard : OrderNotifProfileModel)
    }

}