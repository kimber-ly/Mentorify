package com.example.mentorify

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mentorify.getStarted.RegisterActivity2

class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnRegister: Button = findViewById(R.id.register_btn)
        val toLogin: TextView = findViewById(R.id.to_login_txt)

        btnRegister.setOnClickListener(this)
        toLogin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.register_btn -> {
                    val intent = Intent(this@RegisterActivity,
                        RegisterActivity2::class.java)
                    startActivity(intent)
                }
                R.id.to_login_txt -> {
                    val intent = Intent(this@RegisterActivity,
                        LoginActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}