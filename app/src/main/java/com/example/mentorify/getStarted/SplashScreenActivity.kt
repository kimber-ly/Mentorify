package com.example.mentorify.getStarted

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.example.mentorify.Models.DataUser
import com.example.mentorify.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val runnable = Runnable {
            run {
                val intent = Intent(this@SplashScreenActivity, OnboardingActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        Handler().postDelayed(runnable, 3000)

        DataUser.addUser(
            mapOf(
                "id" to "P00000",
                "title" to "populer",
                "image" to R.drawable.card_orang8,
                "name" to "Tonny Widjaja",
                "occasion" to "Android Developer",
                "price" to "Rp50.000",
                "rating" to "4.5",
                "session" to "20 sesi (15 penilaian)"
            )
        )
        DataUser.addUser(
            mapOf(
                "id" to "P00001",
                "title" to "populer",
                "image" to R.drawable.carddzikri,
                "name" to "Dzikri Arfiansyah",
                "occasion" to "Mentor Teknik Industri",
                "price" to "Rp50.000",
                "rating" to "4.6",
                "session" to "18 sesi (17 penilaian)"
            )
        )
        DataUser.addUser(
            mapOf(
                "id" to "P00002",
                "title" to "populer",
                "image" to R.drawable.card_orang4,
                "name" to "Faza Atsmaro",
                "occasion" to "Mentor Coding",
                "price" to "Rp50.000",
                "rating" to "4.4",
                "session" to "15 sesi (13 penilaian)"
            )
        )
        DataUser.addUser(
            mapOf(
                "id" to "P00003",
                "title" to "populer",
                "image" to R.drawable.card_orang1,
                "name" to "Siti Aulia",
                "occasion" to "Mentor Design",
                "price" to "Rp50.000",
                "rating" to "4.8",
                "session" to "23 sesi (18 penilaian)"
            )
        )
        DataUser.addUser(
            mapOf(
                "id" to "M00000",
                "title" to "top",
                "image" to R.drawable.card_orang5,
                "name" to "Al Ikhsan Akbar",
                "occasion" to "Mentor Coding",
                "price" to "Rp50.000",
                "rating" to "0",
                "session" to "0 sesi (0 penilaian)"
            )
        )
        DataUser.addUser(
            mapOf(
                "id" to "M00001",
                "title" to "top",
                "image" to R.drawable.card_orang7,
                "name" to "Putri Alifia",
                "occasion" to "Mentor Coding",
                "price" to "Rp50.000",
                "rating" to "0",
                "session" to "0 sesi (0 penilaian)"
            )
        )
        DataUser.addUser(
            mapOf(
                "id" to "M00002",
                "title" to "top",
                "image" to R.drawable.card_orang6,
                "name" to "Sambas Purnama Endang",
                "occasion" to "Mentor Coding",
                "price" to "Rp50.000",
                "rating" to "0",
                "session" to "0 sesi (0 penilaian)"
            )
        )
        DataUser.addUser(
            mapOf(
                "id" to "M00003",
                "title" to "top",
                "image" to R.drawable.card_orang4,
                "name" to "Faza Atsmaro H. S",
                "occasion" to "Mentor Coding",
                "price" to "Rp50.000",
                "rating" to "0",
                "session" to "0 sesi (0 penilaian)"
            )
        )
        DataUser.addUser(
            mapOf(
                "id" to "M00004",
                "title" to "top",
                "image" to R.drawable.carddzikri,
                "name" to "Dzikri Arfiansyah",
                "occasion" to "Mentor Coding",
                "price" to "Rp50.000",
                "rating" to "0",
                "session" to "0 sesi (0 penilaian)"
            )
        )

    }
}