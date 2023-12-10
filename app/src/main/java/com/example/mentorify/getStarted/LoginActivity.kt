package com.example.mentorify

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mentorify.databinding.ActivityLoginBinding
import com.example.mentorify.getStarted.ForgetPassword
import com.example.mentorify.getStarted.RegisterActivity2
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tologin: Button = findViewById(R.id.login_btn)
        val toRegister: TextView = findViewById(R.id.to_register_txt)
        val forgetPasswordTxt: TextView = findViewById(R.id.forgetPassword_txt)

        toRegister.setOnClickListener(this)
        forgetPasswordTxt.setOnClickListener(this)
        tologin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
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
                R.id.login_btn -> {
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}