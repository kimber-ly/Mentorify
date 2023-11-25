package com.example.mentorify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.mentorify.databinding.ActivityOverviewBinding


class OverviewActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityOverviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOverviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnreview: Button = findViewById(R.id.btn_Review1)
        btnreview.setOnClickListener(this)

        val btnbackoverview: Button = findViewById(R.id.btn_backOverview)
        btnbackoverview.setOnClickListener(this)

        val btncheckover: Button = findViewById(R.id.btn_checkOverview)
        btncheckover.setOnClickListener(this)
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
                R.id.btn_checkOverview -> {
                    val intent = Intent(this@OverviewActivity, AvaibilityCheckActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}