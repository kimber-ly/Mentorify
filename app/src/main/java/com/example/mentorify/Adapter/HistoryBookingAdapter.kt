package com.example.mentorify.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mentorify.DetailsHistoryActivity
import com.example.mentorify.MentorFragment
import com.example.mentorify.Models.HistoryBookingDataClass
import com.example.mentorify.OverviewActivity
import com.example.mentorify.R


class HistoryBookingAdapter(private val dataset: ArrayList<HistoryBookingDataClass>) :
    RecyclerView.Adapter<HistoryBookingAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mentorName: TextView = view.findViewById(R.id.mentor_history_name)
        val dateHistory: TextView = view.findViewById(R.id.date_history)
        val timeHistory: TextView = view.findViewById(R.id.time_history)
        val btnDetail: Button = view.findViewById(R.id.btn_detail)

        init {
            btnDetail.setOnClickListener {
                val clickedItem: HistoryBookingDataClass = dataset[adapterPosition]
                val intent = Intent(view.context, DetailsHistoryActivity::class.java)
                view.context.startActivity(intent)
                intent.putExtra("MENTOR_NAME", clickedItem.mentorName)
                intent.putExtra("DATE_HISTORY", clickedItem.dateHistory)
                intent.putExtra("TIME_HISTORY", clickedItem.timeHistory)

            }
            mentorName.setOnClickListener {
                val intent = Intent(view.context, OverviewActivity::class.java)
                view.context.startActivity(intent)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val historyBookingView =
            inflater.inflate(R.layout.item_booking_history, parent, false)
        return ViewHolder(historyBookingView)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val historyList: HistoryBookingDataClass = dataset[position]
        holder.mentorName.text = historyList.mentorName
        holder.dateHistory.text = historyList.dateHistory
        holder.timeHistory.text = historyList.timeHistory
    }

}