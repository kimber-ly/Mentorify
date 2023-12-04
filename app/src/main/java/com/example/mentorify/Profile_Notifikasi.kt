package com.example.mentorify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mentorify.Adapter.NotifProfileAdapter
import com.example.mentorify.Models.NotifProfileModel

class Profile_Notifikasi : AppCompatActivity() {
    lateinit var list_notif : RecyclerView
    lateinit var backBtn : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_notifikasi)

        list_notif = findViewById<RecyclerView>(R.id.list_card_notif_profile)
        list_notif.adapter = Peoples

        backBtn = findViewById<ImageView>(R.id.back_btn_notif_profile)
        backBtn.setOnClickListener {
            Toast.makeText(this@Profile_Notifikasi, "this is back button", Toast.LENGTH_LONG).show()
        }
    }

    private val Peoples by lazy {

        val items = listOf<NotifProfileModel>(
            NotifProfileModel(R.drawable.people1_notif_profile, "Dzikri commented on your question"),
            NotifProfileModel(R.drawable.people2_notif_profile, "Putri  commented on your question"),
            NotifProfileModel(R.drawable.people3_notif_profile, "You've successfully booked a mentor today"),
            NotifProfileModel(R.drawable.people4_notif_profile, "You have successfully uploaded the question"),

        )

        NotifProfileAdapter(items, object : NotifProfileAdapter.AdapterListener{
            override fun onClick(notif: NotifProfileModel) {
                Toast.makeText(this@Profile_Notifikasi, "test!", Toast.LENGTH_LONG).show()
            }
        })


    }

}