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
import com.example.mentorify.OverviewActivity
import com.example.mentorify.R
import com.example.mentorify.RingkasanActivity


class MentorCardAdapter(
    var items: List<MentorCardModel>,
    var listener: AdapterListener
): RecyclerView.Adapter<MentorCardAdapter.ViewHolder>(){

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.image_mentor_card)
        val name: TextView = itemView.findViewById(R.id.name_mentor_card)
        val occasion: TextView = itemView.findViewById(R.id.occasion_mentor_card)
        val price: TextView = itemView.findViewById(R.id.price_mentor_card)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.mentor_card, parent, false)
    )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.image.setImageResource(item.image)
        holder.name.text = item.name
        holder.occasion.text = item.occasion
        holder.price.text = item.price

        holder.itemView.setOnClickListener{
            listener.onClick(item)
            val context = holder.itemView.context

            val intent = Intent(context, RingkasanActivity::class.java)

            val bundle = Bundle()
            bundle.putInt("gambar", item.image)
            bundle.putString("nama", item.name)
            bundle.putString("bidang", item.occasion)

            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }

    interface AdapterListener {
        fun onClick(mentor : MentorCardModel)
    }

}