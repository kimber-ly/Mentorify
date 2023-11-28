package com.example.mentorify

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.mentorify.databinding.ActivityPendingBookingDetailBinding
import com.example.mentorify.databinding.ActivityUpcomingDetailBinding
import com.example.mentorify.databinding.FragmentUpcomingBookingBinding

class UpcomingDetailActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUpcomingDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityUpcomingDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnBack: ImageView = findViewById(R.id.btn_backUpcoming)
        btnBack.setOnClickListener(this)

        val btnMeetNow: Button = findViewById(R.id.btn_meetNow)
        btnMeetNow.setOnClickListener(this)

    }
    override fun onClick(view: View){
        if (view != null) {
            when (view.id) {
                R.id.btn_backUpcoming -> {
                    onBackPressed()
                }
                R.id.btn_meetNow -> {
                    val googleMeetUri = "https://meet.google.com/"
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(googleMeetUri))
                    startActivity(intent)
                }
            }
        }
    }


}