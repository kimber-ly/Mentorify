package com.example.mentorify.Adapter

import android.content.Intent
import android.net.Uri
import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mentorify.Models.HistoryBookingDataClass
import com.example.mentorify.OverviewActivity
import com.example.mentorify.PendingBookingDetailActivity
import com.example.mentorify.R
import com.example.mentorify.UpcomingDetailActivity

class UpcomingBookingAdapter(private val dataset: ArrayList<HistoryBookingDataClass>) :
    RecyclerView.Adapter<UpcomingBookingAdapter.ViewHolder>() {
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val mentorName: TextView = view.findViewById(R.id.mentor_history_name)
        val datePending: TextView = view.findViewById(R.id.date)
        val timePending: TextView = view.findViewById(R.id.time)
        val btnDetail: Button = view.findViewById(R.id.btn_detail)
        val btnMeetNow: Button = view.findViewById(R.id.btn_meetNow)

        init {
            btnDetail.setOnClickListener {
                val clickedItem: HistoryBookingDataClass = dataset[layoutPosition]
                val intent = Intent(view.context, UpcomingDetailActivity::class.java)
                view.context.startActivity(intent)
            }

            mentorName.setOnClickListener {
                val intent = Intent(view.context, OverviewActivity::class.java)
                view.context.startActivity(intent)
            }

            btnMeetNow.setOnClickListener{
                //Isi disini
                val googleMeetUri = "https://meet.google.com/"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(googleMeetUri))
                if (intent.resolveActivity(view.context.packageManager) != null) {
                    view.context.startActivity(intent)
                } else {
                    // Jika tidak ada aplikasi yang dapat menangani intent, buka browser
                    val browserIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://meet.google.com/")
                    )
                    view.context.startActivity(browserIntent)
                }
            }


        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UpcomingBookingAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val upcomingBookingView =
            inflater.inflate(R.layout.item_booking_upcoming, parent, false)
        return ViewHolder(upcomingBookingView)
    }

    override fun onBindViewHolder(holder: UpcomingBookingAdapter.ViewHolder, position: Int) {
        val historyList: HistoryBookingDataClass = dataset[position]
        holder.mentorName.text = historyList.mentorName
        holder.datePending.text = historyList.dateHistory
        holder.timePending.text = historyList.timeHistory
    }

    override fun getItemCount(): Int = dataset.size
}