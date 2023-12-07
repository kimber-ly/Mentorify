package com.example.mentorify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.mentorify.Adapter.ViewPagerAdapter
import com.example.mentorify.databinding.ActivityRingkasanBinding
import com.google.android.material.tabs.TabLayoutMediator

class RingkasanActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityRingkasanBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRingkasanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnavibility: Button = findViewById(R.id.btn_checkRingkasan)
        btnavibility.setOnClickListener(this)

        binding.imgMentor.setImageResource(intent.getIntExtra("gambar", 0))
        binding.namaMentor.text = intent.getStringExtra("nama")
        binding.bidangMentor.text = intent.getStringExtra("bidang")

        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        with(binding){
            viewPager.adapter = viewPagerAdapter

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                when(position){
                    0 -> tab.text = "Overview"
                    1 -> tab.text = "Review"
                }
            }.attach()
        }

        binding.btnBackRingkasan.setOnClickListener {
            onBackPressed()
        }
        binding.cbSaved.setOnCheckedChangeListener { checkBox, isChecked ->
            if (isChecked) {
                showToast("Item sudah di save")
            } else {
                showToast("Item dihapus")
            }
        }
    }

    private fun showToast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View?) {
        if (v != null){
            when (v.id){
                R.id.btn_checkRingkasan -> {
                    val intent = Intent(this@RingkasanActivity, AvaibilityCheckActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}