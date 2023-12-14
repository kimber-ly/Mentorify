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
import com.example.mentorify.databinding.ActivityRegisterBinding
import com.example.mentorify.getStarted.RegisterActivity2
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toLogin: TextView = findViewById(R.id.to_login_txt)
        toLogin.setOnClickListener(this)

        binding.registerBtn.setOnClickListener {
            val institution = binding.edtInstitutions.text.toString()
            val password = binding.passwordEdt.text.toString()
            val fullname = binding.fullNameEdt.text.toString()
            val phone = binding.phoneEdt.text.toString()
            val email = binding.gmailEdt.text.toString()

            // Call the register function with the user input
            register(institution, password, fullname, phone, email)

        }

    }

    private fun register(
        institution: String,
        password: String,
        fullname: String,
        phone: String,
        email: String
    ) {
        // Get Retrofit instance
        val retrofitInstance = RetrofitInstance.getRetrofitInstance()

        // Create an instance of the API interface
        val apiInterface = retrofitInstance.create(ApiInterface::class.java)

        // Create user body object with registration information
        val registerInfo = UserBody(institution, password, fullname, phone, email)

        // Make a network request to register the user
        apiInterface.registerUser(registerInfo).enqueue(object : Callback<ResponseBody?> {
            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                Toast.makeText(
                    this@RegisterActivity,
                    "Pendaftaran gagal. Error: ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(call: Call<ResponseBody?>, response: Response<ResponseBody?>) {
                // Check the HTTP response code
                if (response.code() == 200) {
                    Toast.makeText(
                        this@RegisterActivity, "Pendaftaran Berhasil", Toast.LENGTH_SHORT
                    ).show()
                    val intent = Intent(
                        this@RegisterActivity,
                        RegisterActivity2::class.java
                    )
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Pendaftaran gagal. Error code: ${response.code()}",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.d("Register Activity","Pendaftaran gagal")
                }
            }
        })
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.to_login_txt -> {
                    val intent = Intent(
                        this@RegisterActivity,
                        LoginActivity::class.java
                    )
                    startActivity(intent)
                }
            }
        }
    }
}