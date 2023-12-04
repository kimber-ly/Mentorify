package com.example.mentorify

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mentorify.databinding.ActivityRegisterBinding
import com.example.mentorify.getStarted.RegisterActivity2
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.registerBtn.setOnClickListener {
            val fullname = binding.fullNameEdt.text.toString()
            val email = binding.gmailEdt.text.toString()
            val phone = binding.phoneEdt.text.toString()
            val kampus = binding.asalKampusEdt.text.toString()
            val password = binding.passwordEdt.text.toString()
            val confirmpassword = binding.confirmPasswordEdt.text.toString()

            if (fullname.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty() && kampus.isNotEmpty() && password.isNotEmpty() && confirmpassword.isNotEmpty()){
                if (password == confirmpassword){

                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful){
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this, it.exception.toString() , Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this, "Password Tidak Cocok" , Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Silahkan Daftarkan diri anda terlebih dahulu" , Toast.LENGTH_SHORT).show()
            }
        }

        val toLogin: TextView = findViewById(R.id.to_login_txt)

        toLogin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.to_login_txt -> {
                    val intent = Intent(this@RegisterActivity,
                        LoginActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}