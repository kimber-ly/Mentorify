package com.example.mentorify

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mentorify.Adapter.MentorCardAdapter
import com.example.mentorify.Adapter.PopulerSearchPage
import com.example.mentorify.Models.MentorCardModel
import com.example.mentorify.Models.SearchPagePopularModel

class Profile_SavedMentor : AppCompatActivity() {
    lateinit var list_mentor : RecyclerView
    lateinit var backBtn : ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_saved_mentor)

        list_mentor = findViewById<RecyclerView>(R.id.list_mentor_savedmentor)
        list_mentor.adapter = Mentors

        backBtn = findViewById<ImageView>(R.id.back_btn_savedmentor)
        backBtn.setOnClickListener {
            Toast.makeText(this@Profile_SavedMentor, "this is back button", Toast.LENGTH_LONG).show()
        }
    }

    private val Mentors by lazy {

        val items = listOf<MentorCardModel>(
            MentorCardModel(R.drawable.card_orang5, "Al Ikhsan Akbar", "Mentor Coding", "Rp50.000"),
            MentorCardModel(R.drawable.card_orang7, "Putri Alifia", "Mentor Coding", "Rp50.000"),
            MentorCardModel(R.drawable.card_orang6, "Sambas Purnama Endang", "Mentor Coding", "Rp50.000"),
            MentorCardModel(R.drawable.card_orang4, "Faza Atsmaro H. S", "Mentor Coding", "Rp50.000"),
            MentorCardModel(R.drawable.carddzikri, "Dzikri Arfiansyah", "Mentor Coding", "Rp50.000"),
            MentorCardModel(R.drawable.card_orang5, "Al Ikhsan Akbar", "Mentor Coding", "Rp50.000"),
            MentorCardModel(R.drawable.card_orang7, "Putri Alifia", "Mentor Coding", "Rp50.000"),
            MentorCardModel(R.drawable.card_orang6, "Sambas Purnama Endang", "Mentor Coding", "Rp50.000"),
            MentorCardModel(R.drawable.card_orang4, "Faza Atsmaro H.S", "Mentor Coding", "Rp50.000"),
            MentorCardModel(R.drawable.carddzikri, "Dzikri Arfiansyah", "Mentor Coding", "Rp50.000"),
            MentorCardModel(R.drawable.card_orang5, "Al Ikhsan Akbar", "Mentor Coding", "Rp50.000"),
            MentorCardModel(R.drawable.card_orang7, "Putri Alifia", "Mentor Coding", "Rp50.000"),
            MentorCardModel(R.drawable.card_orang6, "Sambas Purnama Endang", "Mentor Coding", "Rp50.000"),
            MentorCardModel(R.drawable.card_orang4, "Faza Atsmaro H.S", "Mentor Coding", "Rp50.000"),
            MentorCardModel(R.drawable.carddzikri, "Dzikri Arfiansyah", "Mentor Coding", "Rp50.000")

        )

       MentorCardAdapter(items, object : MentorCardAdapter.AdapterListener{
            override fun onClick(mentor: MentorCardModel) {
                Toast.makeText(this@Profile_SavedMentor, "test!", Toast.LENGTH_LONG).show()
            }
        })


    }
}