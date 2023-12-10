package com.example.mentorify

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mentorify.Adapter.MentorCardAdapter
import com.example.mentorify.Models.DataUser
import com.example.mentorify.Models.DataWhislist
import com.example.mentorify.Models.MentorCardModel
import com.example.mentorify.Models.PopularKategoryModel
import com.example.mentorify.databinding.ActivityProfileSavedMentorBinding

class Profile_SavedMentor : AppCompatActivity() {
    lateinit var list_mentor : RecyclerView
    lateinit var backBtn : ImageView
    private lateinit var binding: ActivityProfileSavedMentorBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileSavedMentorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list_mentor = findViewById<RecyclerView>(R.id.list_mentor_savedmentor)
        list_mentor.adapter = Mentors


//        backBtn = findViewById<ImageView>(R.id.back_btn_savedmentor)
//        backBtn.setOnClickListener {
//            Toast.makeText(this@Profile_SavedMentor, "this is back button", Toast.LENGTH_LONG).show()
//        }
        binding.backBtnSavedmentor.setOnClickListener {
            onBackPressed()
        }
    }

    private val Mentors by lazy {
        val items : ArrayList<MentorCardModel> = ArrayList()

        for(user in DataUser.getAllData()){
           if (DataWhislist.getAllData().find { name -> name.equals(user.get("name") as String) }!=null){
            items.add(
                MentorCardModel(
                user.get("image") as Int,
                user.get("name") as String,
                user.get("occasion") as String,
                user.get("price") as String)
            )

           }
        }

        val items_ = listOf<MentorCardModel>(
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