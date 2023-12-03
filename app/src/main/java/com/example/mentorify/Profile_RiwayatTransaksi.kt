package com.example.mentorify

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mentorify.Adapter.MentorCardAdapter
import com.example.mentorify.Adapter.TransactionHistoryAdapter
import com.example.mentorify.Models.MentorCardModel
import com.example.mentorify.Models.TransactionHistoryModel

class Profile_RiwayatTransaksi : AppCompatActivity() {
    private lateinit var listHistory : RecyclerView
    private lateinit var backBtn : ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_riwayat_transaksi)

        listHistory = findViewById<RecyclerView>(R.id.list_histori_transaksi)
        listHistory.adapter = histories

        backBtn = findViewById<ImageView>(R.id.back_btn_histori_transaksi)
        backBtn.setOnClickListener {
            Toast.makeText(this@Profile_RiwayatTransaksi, "this is back button", Toast.LENGTH_LONG).show()
        }
    }

    private val histories by lazy {

        val items = listOf<TransactionHistoryModel>(
            TransactionHistoryModel("20231113-000000001", "Sambas Purnama - ","Mentor Desain", R.drawable.status_waiting),
            TransactionHistoryModel("20231113-000002001", "Al Ikhsan Akbar - ","Mentor Coding", R.drawable.status_reject),
            TransactionHistoryModel("20231113-002030001", "Putri Alifiani - ","Mentor Digital Marketing", R.drawable.status_accept),
            TransactionHistoryModel("20231113-000000001", "Sambas Purnama - ","Mentor Desain", R.drawable.status_waiting),
            TransactionHistoryModel("20231113-000002001", "Al Ikhsan Akbar - ","Mentor Coding", R.drawable.status_reject),
            TransactionHistoryModel("20231113-002030001", "Putri Alifiani - ","Mentor Digital Marketing", R.drawable.status_accept),
            TransactionHistoryModel("20231113-000000001", "Sambas Purnama - ","Mentor Desain", R.drawable.status_waiting),
            TransactionHistoryModel("20231113-000002001", "Al Ikhsan Akbar - ","Mentor Coding", R.drawable.status_reject),
            TransactionHistoryModel("20231113-002030001", "Putri Alifiani - ","Mentor Digital Marketing", R.drawable.status_accept),
            TransactionHistoryModel("20231113-000000001", "Sambas Purnama - ","Mentor Desain", R.drawable.status_waiting),
            TransactionHistoryModel("20231113-000002001", "Al Ikhsan Akbar - ","Mentor Coding", R.drawable.status_reject),
            TransactionHistoryModel("20231113-002030001", "Putri Alifiani - ","Mentor Digital Marketing", R.drawable.status_accept)

        )

        TransactionHistoryAdapter(items, object : TransactionHistoryAdapter.AdapterListener{
            override fun onClick(item: TransactionHistoryModel) {
                Toast.makeText(this@Profile_RiwayatTransaksi, "test!", Toast.LENGTH_LONG).show()
            }
        })


    }
}