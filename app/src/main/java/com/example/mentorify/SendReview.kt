package com.example.mentorify

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.mentorify.databinding.ActivitySendReviewBinding
import com.example.mentorify.databinding.ActivityUpcomingDetailBinding

class SendReview : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivitySendReviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySendReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnBack: ImageView = findViewById(R.id.btn_backHistory)
        btnBack.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view != null) {
            when (view.id) {
                R.id.btn_backHistory -> {
                    onBackPressed()
                }
                //isi disini
            }
        }
    }
}