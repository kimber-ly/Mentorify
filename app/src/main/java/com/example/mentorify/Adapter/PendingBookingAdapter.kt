package com.example.mentorify.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mentorify.OverviewActivity
import com.example.mentorify.Models.HistoryBookingDataClass
import com.example.mentorify.PendingBookingDetailActivity
import com.example.mentorify.R

class PendingBookingAdapter(private val dataset: ArrayList<HistoryBookingDataClass>) :
    RecyclerView.Adapter<PendingBookingAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mentorName: TextView = view.findViewById(R.id.mentor_history_name)
        val datePending: TextView = view.findViewById(R.id.date)
        val timePending: TextView = view.findViewById(R.id.time)
        val btnDetail: Button = view.findViewById(R.id.btn_detail)

        init {
            btnDetail.setOnClickListener {
                val clickedItem: HistoryBookingDataClass = dataset[layoutPosition]
                val intent = Intent(view.context, PendingBookingDetailActivity::class.java)
                view.context.startActivity(intent)

            }

            mentorName.setOnClickListener {
                val intent = Intent(view.context, OverviewActivity::class.java)
                view.context.startActivity(intent)
            }

        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PendingBookingAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val pendingBookingView =
            inflater.inflate(R.layout.item_booking_pending, parent, false)
        return ViewHolder(pendingBookingView)

    }



    override fun onBindViewHolder(holder: PendingBookingAdapter.ViewHolder, position: Int) {
        val historyList: HistoryBookingDataClass = dataset[position]
        holder.mentorName.text = historyList.mentorName
        holder.datePending.text = historyList.dateHistory
        holder.timePending.text = historyList.timeHistory
    }

    override fun getItemCount(): Int = dataset.size

}