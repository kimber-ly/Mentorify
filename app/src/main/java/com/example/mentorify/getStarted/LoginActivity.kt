package com.example.mentorify

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mentorify.getStarted.ForgetPassword

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin: Button = findViewById(R.id.login_btn)
        val toRegister: TextView = findViewById(R.id.to_register_txt)
        val forgetPasswordTxt: TextView = findViewById(R.id.forgetPassword_txt)

        btnLogin.setOnClickListener(this)
        toRegister.setOnClickListener(this)
        forgetPasswordTxt.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.login_btn -> {
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.to_register_txt -> {
                    val intent = Intent(this@LoginActivity,
                        RegisterActivity::class.java)
                    startActivity(intent)
                }
                R.id.forgetPassword_txt -> {
                    val intent = Intent(this@LoginActivity,
                        ForgetPassword::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}