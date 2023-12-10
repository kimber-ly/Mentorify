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
import com.example.mentorify.Models.PopularKategoryModel
import com.example.mentorify.PopularOverview
import com.example.mentorify.R
import com.example.mentorify.RingkasanActivity

class PopularKategoriAdapter (private var popularMentor: ArrayList<PopularKategoryModel>):
    RecyclerView.Adapter<PopularKategoriAdapter.ViewHolder>() {
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.popular_mentor_img)
        val name: TextView = view.findViewById(R.id.popular_mentor_name)
        val occasion: TextView = view.findViewById(R.id.popular_mentor_occasion)
        val session: TextView = view.findViewById(R.id.popular_kategori_session)
        val price: TextView = view.findViewById(R.id.popular_mentor_price)
        val rating: TextView = view.findViewById(R.id.popular_mentor_rating)

        val selengkapnya: Button = view.findViewById(R.id.selengkapnya_btn)

        val save_btn : ImageView = view.findViewById(R.id.popular_save_btn)
        var save_btn_state = 0


    }
        @SuppressLint("NotifyDataSetChanged")
        fun setFilteredList(mList: ArrayList<PopularKategoryModel>){
            popularMentor = mList
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.popular_kategori, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return popularMentor.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val popular = popularMentor[position]

        holder.image.setImageResource(popular.image)
        holder.name.text = popular.name
        holder.occasion.text = popular.occasion
        holder.session.text = popular.session
        holder.price.text = popular.price
        holder.rating.text = popular.rating

        holder.selengkapnya.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, RingkasanActivity::class.java)

            val bundle = Bundle()
            bundle.putInt("gambar", popular.image)
            bundle.putString("nama", popular.name)
            bundle.putString("bidang", popular.occasion)

            intent.putExtras(bundle)
            context.startActivity(intent)
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
                Toast.makeText(holder.itemView.context, "Dihapus Dari Tersimpan", Toast.LENGTH_LONG).show()
            }
        }
    }
}