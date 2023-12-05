package com.example.mentorify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mentorify.Adapter.ViewPagerAdapter
import com.example.mentorify.databinding.ActivityRingkasanBinding
import com.google.android.material.tabs.TabLayoutMediator

class RingkasanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRingkasanBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRingkasanBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
    }
}