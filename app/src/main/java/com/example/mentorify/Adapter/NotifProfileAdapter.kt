package com.example.mentorify.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mentorify.Models.NotifProfileModel
import com.example.mentorify.R


class NotifProfileAdapter(
    var items : List<NotifProfileModel>,
    var listener : AdapterListener
): RecyclerView.Adapter<NotifProfileAdapter.ViewHolder>(){

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val image = itemView.findViewById<ImageView>(R.id.image_notif_profile)
        val text = itemView.findViewById<TextView>(R.id.text_notif_profile)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.notif_profile_card, parent, false)
    )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardNotif = items[position]

        holder.image.setImageResource(cardNotif.image)
        holder.text.text = cardNotif.text

        holder.itemView.setOnClickListener{
            listener.onClick(cardNotif)
        }
    }

    interface AdapterListener {
        fun onClick(notif: NotifProfileModel)
    }

}