package com.example.mentorify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ReviewActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val btnoverview: Button = findViewById(R.id.btn_Overview2)
        btnoverview.setOnClickListener(this)

        val btnbackreview: Button = findViewById(R.id.btn_backReview)
        btnbackreview.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.btn_Overview2 -> {
                    val intent = Intent(this@ReviewActivity, OverviewActivity::class.java)
                    startActivity(intent)
                }
                R.id.btn_backReview -> {
                    val intent = Intent(this@ReviewActivity, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}