package com.example.mentorify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

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

    }
}