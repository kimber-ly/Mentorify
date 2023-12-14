package com.example.mentorify

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mentorify.api.ApiInterface
import com.example.mentorify.api.RetrofitInstance
import com.example.mentorify.api.UserBody
import com.example.mentorify.api.UserLogin
import com.example.mentorify.databinding.ActivityLoginBinding
import com.example.mentorify.getStarted.ForgetPassword
import com.example.mentorify.getStarted.RegisterActivity2
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toRegister: TextView = findViewById(R.id.to_register_txt)
        val forgetPasswordTxt: TextView = findViewById(R.id.forgetPassword_txt)
        val toLogin: Button = findViewById(R.id.login_btn)

        toRegister.setOnClickListener(this)
        forgetPasswordTxt.setOnClickListener(this)

        toLogin.setOnClickListener(this)
        binding.loginBtn.setOnClickListener {
            val email = binding.gmailEdt.text.toString()
            val password = binding.passwordEdt.text.toString()

            // Call the register function with the user input
            login(email, password)

        }
    }

    private fun login(
        email:String,
        password: String,
    ) {
        // Get Retrofit instance
        val retrofitInstance = RetrofitInstance.getRetrofitInstance()

        // Create an instance of the API interface
        val apiInterface = retrofitInstance.create(ApiInterface::class.java)

        // Create user body object with registration information
        val loginInfo = UserLogin(email, password)

        // Make a network request to register the user
        apiInterface.login(loginInfo).enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(call: Call<ResponseBody?>, response: Response<ResponseBody?>) {
                // Check the HTTP response code
                if (response.code() == 200) {
                    Toast.makeText(
                        this@LoginActivity, "Login Berhasil", Toast.LENGTH_SHORT
                    ).show()
                    val intent = Intent(
                        this@LoginActivity,
                        MainActivity::class.java
                    )
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        "Login gagal. Error code: ${response.code()}",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.d("Login","Login gagal")
                }
            }

            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                Toast.makeText(
                    this@LoginActivity,
                    "Login gagal. Error: ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.to_register_txt -> {
                    val intent = Intent(
                        this@LoginActivity,
                        RegisterActivity::class.java
                    )
                    startActivity(intent)
                }

                R.id.forgetPassword_txt -> {
                    val intent = Intent(
                        this@LoginActivity,
                        ForgetPassword::class.java
                    )
                    startActivity(intent)
                }

//                R.id.login_btn -> {
//                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
//                    startActivity(intent)
//                }
            }
        }
    }
}