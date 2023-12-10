package com.example.mentorify

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mentorify.databinding.ActivityLoginBinding
import com.example.mentorify.getStarted.ForgetPassword
import com.example.mentorify.getStarted.RegisterActivity2
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        //hapus auth firebase & hanya regis yg pilih topik, login ga perlu pilih topik
        binding.loginBtn.setOnClickListener {
            val email = binding.gmailEdt.text.toString()
            val password = binding.passwordEdt.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()){
                    firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful){
                            val intent = Intent(this, RegisterActivity2::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this, it.exception.toString() , Toast.LENGTH_SHORT).show()
                        }
                    }
            }else{
                Toast.makeText(this, "Silahkan Isi formulir tersebut !!" , Toast.LENGTH_SHORT).show()
            }
        }

        val toRegister: TextView = findViewById(R.id.to_register_txt)
        val forgetPasswordTxt: TextView = findViewById(R.id.forgetPassword_txt)

        toRegister.setOnClickListener(this)
        forgetPasswordTxt.setOnClickListener(this)
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
            }
        }
    }
}