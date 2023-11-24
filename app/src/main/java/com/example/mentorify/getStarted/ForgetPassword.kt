package com.example.mentorify.getStarted

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mentorify.databinding.ActivityForgetPasswordBinding

class ForgetPassword : AppCompatActivity() {
    private lateinit var binding: ActivityForgetPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitEmailBtn.setOnClickListener{
            val intent = Intent(this@ForgetPassword, ForgetPassword2::class.java)
            startActivity(intent)
        }
    }
}