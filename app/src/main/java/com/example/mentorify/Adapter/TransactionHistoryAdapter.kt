package com.example.mentorify.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mentorify.Models.TransactionHistoryModel
import com.example.mentorify.R


class TransactionHistoryAdapter(
    var items : List<TransactionHistoryModel>,
    var listener : AdapterListener
): RecyclerView.Adapter<TransactionHistoryAdapter.ViewHolder>(){

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val id = itemView.findViewById<TextView>(R.id.idtrans_transhistory_card)
        val name = itemView.findViewById<TextView>(R.id.title_name_transhistory_card)
        val occasion = itemView.findViewById<TextView>(R.id.title_occasion_transhistory_card)
        val status = itemView.findViewById<ImageView>(R.id.status_transhistory)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.transaction_history_card, parent, false)
    )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.id.text = item.id
        holder.name.text = item.name
        holder.occasion.text = item.occasion
        holder.status.setImageResource(item.status)

        holder.itemView.setOnClickListener{
            listener.onClick(item)
        }
    }

    interface AdapterListener {
        fun onClick(item : TransactionHistoryModel)
    }

}