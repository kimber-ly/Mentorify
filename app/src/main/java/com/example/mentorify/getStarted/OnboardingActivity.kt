package com.example.mentorify.getStarted

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mentorify.LoginActivity
import com.example.mentorify.R
import com.example.mentorify.RegisterActivity
import com.ramotion.paperonboarding.PaperOnboardingFragment
import com.ramotion.paperonboarding.PaperOnboardingPage

class OnboardingActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var register: Button
    private lateinit var login: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        register = findViewById(R.id.get_started_btn)
        register.setOnClickListener(this)

        login = findViewById(R.id.already_have_acc_btn)
        login.setOnClickListener(this)

        val fragmentManager = supportFragmentManager
        val paperOnboardingFragment = PaperOnboardingFragment.newInstance(getData())

        fragmentManager
            .beginTransaction()
            .add(R.id.onboarding_container, paperOnboardingFragment)
            .commit()
    }

    private fun getData(): ArrayList<PaperOnboardingPage>? {
        val page1 = PaperOnboardingPage("Selamat Datang",
            "Selamat datang di Mentorify, tempat dimana pembelajaran menjadi sebuah perjalanan yang penuh inspirasi.",
            Color.WHITE,
            R.drawable.onboarding_img_1,
            R.drawable.baseline_waving_hand_24
        )
        val page2 = PaperOnboardingPage("Mentor Professional",
            "Anda terhubung langsung dengan mentor professional untuk membimbing langkah - langkah sukses akademis Anda.",
            Color.WHITE,
            R.drawable.onboarding_img_2,
            R.drawable.baseline_school_24
        )
        val page3 = PaperOnboardingPage("Forum Tanya Jawab",
            "Kami memberikan ruang untuk saling berbagi pengalaman dan bertanya.",
            Color.WHITE,
            R.drawable.onboarding_img_3,
            R.drawable.baseline_people_24
        )
        val page4 = PaperOnboardingPage("Dapatkan Bimbingan dari para Professional",
            "Raih potensi penuh anda dengan dukungan pribadi dari mentor berpengalaman dan komunitas yang mendukung pertumbuhan Anda secara holistik.",
            Color.WHITE,
            R.drawable.onboarding_img_4,
            R.drawable.baseline_thumb_up_24
        )

        val elements = ArrayList<PaperOnboardingPage>()
        elements.add(page1)
        elements.add(page2)
        elements.add(page3)
        elements.add(page4)

        return elements
    }

    override fun onClick(v: View) {
        when (v.id){
            R.id.get_started_btn -> {
                val intent = Intent(this@OnboardingActivity, RegisterActivity::class.java)
                startActivity(intent)
            }
            R.id.already_have_acc_btn -> {
                val intent = Intent(this@OnboardingActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}