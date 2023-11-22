package com.example.mentorify.getStarted

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mentorify.R

class TopicAdapter(private val topics: List<ChooseTopic>):
    RecyclerView.Adapter<TopicAdapter.Viewholder>() {
    inner class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val topicImg: ImageView = itemView.findViewById(R.id.topic_img)
        val topicName: TextView = itemView.findViewById(R.id.topic_txt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val topicView = inflater.inflate(R.layout.favorite_topics, parent, false)

        return Viewholder(topicView)
    }

    override fun getItemCount(): Int {
        return topics.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val topic: ChooseTopic = topics[position]

        val image = holder.topicImg
        image.setImageResource(topic.topicImg)

        val name = holder.topicName
        name.text = topic.topicName
    }
}