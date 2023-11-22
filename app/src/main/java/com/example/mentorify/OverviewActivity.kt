package com.example.mentorify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class OverviewActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)

        val btnreview: Button = findViewById(R.id.btn_Review1)
        btnreview.setOnClickListener(this)

        val btnbackoverview: Button = findViewById(R.id.btn_backOverview)
        btnbackoverview.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.btn_Review1 -> {
                    val intent = Intent(this@OverviewActivity, ReviewActivity::class.java)
                    startActivity(intent)
                }
                R.id.btn_backOverview -> {
                    val intent = Intent(this@OverviewActivity, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}