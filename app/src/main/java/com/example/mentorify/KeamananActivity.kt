package com.example.mentorify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mentorify.databinding.ActivityKeamananBinding

class KeamananActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKeamananBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKeamananBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtnKeamanan.setOnClickListener {
            onBackPressed()
        }
    }
}