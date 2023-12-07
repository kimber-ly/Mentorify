package com.example.mentorify.getStarted

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mentorify.MainActivity
import com.example.mentorify.R

class RegisterActivity2 : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var startTopic: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register2)

        recyclerView = findViewById(R.id.recyclerView_choose_topic)
        val topicData = insertData()
        val adapter = TopicAdapter(topicData)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        startTopic = findViewById(R.id.start_topic_btn)
        startTopic.setOnClickListener {
            val intent = Intent(this@RegisterActivity2, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun insertData(): List<ChooseTopic> {
        return listOf(
            ChooseTopic(topicImg = R.drawable.data_science, topicName = "Data Science"),
            ChooseTopic(topicImg = R.drawable.teknik_industri, topicName = "Teknik Industri"),
            ChooseTopic(topicImg = R.drawable.management, topicName = "Manajemen"),
            ChooseTopic(topicImg = R.drawable.coding, topicName = "Pemrograman"),
            ChooseTopic(topicImg = R.drawable.design, topicName = "Desain"),
            ChooseTopic(topicImg = R.drawable.marketing, topicName = "Pemasaran"),
            ChooseTopic(topicImg = R.drawable.sistem_informasi, topicName = "Sistem Informasi"),
            ChooseTopic(topicImg = R.drawable.bisnis_digital, topicName = "Bisnis Digital"),
            ChooseTopic(topicImg = R.drawable.medical, topicName = "Kesehatan"),
        )
    }
}