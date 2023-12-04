package com.example.mentorify

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mentorify.databinding.ActivityPopularOverviewBinding


class PopularOverview : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPopularOverviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPopularOverviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgMentor.setImageResource(intent.getIntExtra("gambar", 0))
        binding.namaMentor.text = intent.getStringExtra("nama")
        binding.bidangMentor.text = intent.getStringExtra("bidang")

        val btnreview: Button = binding.btnReview1
        btnreview.setOnClickListener(this)

        val btnbackoverview: Button = binding.btnBackOverview
        btnbackoverview.setOnClickListener(this)

        val btncheckover: Button = binding.btnCheckOverview
        btncheckover.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.btn_Review1 -> {
                    val intent = Intent(this@PopularOverview, ReviewActivity::class.java)
                    startActivity(intent)
                }
                R.id.btn_backOverview -> {
                    val intent = Intent(this@PopularOverview, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.btn_checkOverview -> {
                    val intent = Intent(this@PopularOverview, AvaibilityCheckActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}