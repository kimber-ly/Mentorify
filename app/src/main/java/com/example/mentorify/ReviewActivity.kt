package com.example.mentorify

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mentorify.databinding.ActivityReviewBinding

class ReviewActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityReviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mentorReviewImg.setImageResource(intent.getIntExtra("gambar", 0))
        binding.mentorReviewName.text = intent.getStringExtra("nama")
        binding.mentorReviewOccasion.text = intent.getStringExtra("bidang")

        val btnoverview: Button = binding.btnOverview2
        btnoverview.setOnClickListener(this)

        val btnbackreview: Button = binding.btnBackReview
        btnbackreview.setOnClickListener(this)

        val btncheckreviewdz: Button = binding.btnCheckReview
        btncheckreviewdz.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.btn_Overview2 -> {
                    val intent = Intent(this@ReviewActivity, OverviewActivity::class.java)

                    val bundle = Bundle()
                    bundle.putInt("gambar", intent.getIntExtra("gambar", 0))
                    bundle.putString("nama", intent.getStringExtra("nama"))
                    bundle.putString("bidang", intent.getStringExtra("bidang"))

                    intent.putExtras(bundle)
                    startActivity(intent)
                }
                R.id.btn_backReview -> {
                    val intent = Intent(this@ReviewActivity, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.btn_checkReview -> {
                    val intent = Intent(this@ReviewActivity, AvaibilityCheckActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}