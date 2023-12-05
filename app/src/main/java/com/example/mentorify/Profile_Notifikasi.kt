package com.example.mentorify

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mentorify.Adapter.NotifProfileAdapter
import com.example.mentorify.Adapter.OrderNotifProfileAdapter
import com.example.mentorify.Models.NotifProfileModel
import com.example.mentorify.Models.OrderNotifProfileModel

class Profile_Notifikasi : AppCompatActivity() {
    lateinit var list_notif : RecyclerView
    lateinit var list_orders : RecyclerView
    lateinit var backBtn : ImageView
    lateinit var chatBtn : ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_notifikasi)

        list_notif = findViewById<RecyclerView>(R.id.list_card_notif_profile)
        list_notif.adapter = Peoples
        list_orders = findViewById<RecyclerView>(R.id.list_order_notif_profile)
        list_orders.adapter = Orders

        backBtn = findViewById<ImageView>(R.id.back_btn_notif_profile)
        backBtn.setOnClickListener {
            Toast.makeText(this@Profile_Notifikasi, "this is back button", Toast.LENGTH_LONG).show()
        }
        chatBtn = findViewById<ImageView>(R.id.chat_btn_notif_profile)
        chatBtn.setOnClickListener {
            Toast.makeText(this@Profile_Notifikasi, "this is chat button", Toast.LENGTH_LONG).show()
        }
    }

    private val Peoples by lazy {

        val items = listOf<NotifProfileModel>(
            NotifProfileModel(R.drawable.people1_notif_profile, "Dzikri commented on your question"),
            NotifProfileModel(R.drawable.people2_notif_profile, "Putri  commented on your question"),
            NotifProfileModel(R.drawable.people3_notif_profile, "You've successfully booked a mentor today"),
            NotifProfileModel(R.drawable.people1_notif_profile, "Dzikri commented on your question"),
            NotifProfileModel(R.drawable.people2_notif_profile, "Putri  commented on your question"),
            NotifProfileModel(R.drawable.people3_notif_profile, "You've successfully booked a mentor today"),
            NotifProfileModel(R.drawable.people4_notif_profile, "You have successfully uploaded the question")

        )

        NotifProfileAdapter(items, object : NotifProfileAdapter.AdapterListener{
            override fun onClick(notif: NotifProfileModel) {
                Toast.makeText(this@Profile_Notifikasi, "test!", Toast.LENGTH_LONG).show()
            }
        })


    }


    private val Orders by lazy {

        val items = listOf<OrderNotifProfileModel>(
            OrderNotifProfileModel(R.drawable.card_orang4,
                "Mentor Coding", "2311071YC6JWQX", "12 - 11 - 2024", "16:05"),
            OrderNotifProfileModel(R.drawable.card_orang5,
                "Mentor Coding", "2311071YC6JWQX", "12 - 11 - 2024", "16:05"),
            OrderNotifProfileModel(R.drawable.card_orang6,
                "Mentor Coding", "2311071YC6JWQX", "12 - 11 - 2024", "16:05"),
            OrderNotifProfileModel(R.drawable.card_orang7,
                "Mentor Coding", "2311071YC6JWQX", "12 - 11 - 2024", "16:05"),
            OrderNotifProfileModel(R.drawable.carddzikri,
                "Mentor Coding", "2311071YC6JWQX", "12 - 11 - 2024", "16:05")

            )

        OrderNotifProfileAdapter(items, object : OrderNotifProfileAdapter.AdapterListener{
            override fun onClick(order: OrderNotifProfileModel) {
                Toast.makeText(this@Profile_Notifikasi, "test!", Toast.LENGTH_LONG).show()
            }
        })


    }

}