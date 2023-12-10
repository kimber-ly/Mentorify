package com.example.mentorify.Adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mentorify.Models.DataUser
import com.example.mentorify.Models.DataWhislist
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
        val selengkapnya_btn : Button = itemView.findViewById(R.id.selengkapnya_btn_mentor_card)

        val save_btn : ImageView = itemView.findViewById(R.id.bookmark_icon_mentor_card)
        var save_btn_state = 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.mentor_card, parent, false)
    )

    override fun getItemCount(): Int = items.size

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        if(DataWhislist.getAllData().find { name -> name.equals(item.name) }!=null){
            holder.save_btn.setImageResource(R.drawable.baseline_bookmark_24_blue)

        }
        holder.image.setImageResource(item.image)
        holder.name.text = item.name
        holder.occasion.text = item.occasion
        holder.price.text = item.price

        holder.selengkapnya_btn.setOnClickListener{
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

        holder.itemView.setOnClickListener{

        }

        holder.save_btn.setOnClickListener {
            if(holder.save_btn_state == 0){

                holder.save_btn.animate().apply {
                    duration = 200
                    scaleX(1.4F)
                    scaleY(1.4F)
                }.withEndAction {
                    holder.save_btn.animate().apply {
                        duration = 200
                        scaleX(1.0F)
                        scaleY(1.0F)
                    }.start()
                }
                holder.save_btn_state = 1
                holder.save_btn.setImageResource(R.drawable.baseline_bookmark_24_blue)
                DataWhislist.addWishlist(holder.name.text.toString())
                Toast.makeText(holder.itemView.context, "Mentor Telah Disimpan", Toast.LENGTH_LONG).show()
            }
            else if (holder.save_btn_state == 1){
                holder.save_btn.animate().apply {
                    duration = 200
                    scaleX(1.4F)
                    scaleY(1.4F)
                }.withEndAction {
                    holder.save_btn.animate().apply {
                        duration = 200
                        scaleX(1.0F)
                        scaleY(1.0F)
                    }.start()
                }
                holder.save_btn_state = 0
                holder.save_btn.setImageResource(R.drawable.baseline_bookmark_border_24)
                DataWhislist.delWishlist(holder.name.text.toString())
                notifyDataSetChanged()
                Toast.makeText(holder.itemView.context, "Dihapus Dari Tersimpan", Toast.LENGTH_LONG).show()
            }
        }
    }

    interface AdapterListener {
        fun onClick(mentor : MentorCardModel)
    }

}