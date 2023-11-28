package com.example.mentorify

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mentorify.Adapter.MentorCardAdapter
import com.example.mentorify.Models.MentorCardModel
import com.example.mentorify.Utils.SearchPageSection
import com.example.mentorify.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.topMatchesRecycler.adapter = Mentor
        binding.topMatchesRecycler.layoutManager = GridLayoutManager(requireContext(), 2)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnsiti: Button = binding.btnSelengkapnyasiti
        btnsiti.setOnClickListener(this)

        val btndzik: TextView = binding.btnSeeallPopular
        btndzik.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_selengkapnyasiti){
            val int = Intent(activity, OverviewActivity::class.java)
            startActivity(int)
        }
        if (v?.id == R.id.btn_seeall_popular){
            val int = Intent(activity, SearchPageSection::class.java)
            startActivity(int)
        }
    }

    private val Mentor by lazy {

        val items = listOf<MentorCardModel>(
            MentorCardModel(R.drawable.card_orang5, "Al Ikhsan Akbar", "Mentor Coding", "Rp50.000"),
            MentorCardModel(R.drawable.card_orang7, "Putri Alifia", "Mentor Coding", "Rp50.000"),
            MentorCardModel(
                R.drawable.card_orang6,
                "Sambas Purnama Endang",
                "Mentor Coding",
                "Rp50.000"
            ),
            MentorCardModel(
                R.drawable.card_orang4,
                "Faza Atsmaro H. S",
                "Mentor Coding",
                "Rp50.000"
            ),
            MentorCardModel(
                R.drawable.carddzikri,
                "Dzikri Arfiansyah",
                "Mentor Coding",
                "Rp50.000"
            ),
            MentorCardModel(R.drawable.card_orang5, "Al Ikhsan Akbar", "Mentor Coding", "Rp50.000"),
            MentorCardModel(R.drawable.card_orang7, "Putri Alifia", "Mentor Coding", "Rp50.000"),
            MentorCardModel(
                R.drawable.card_orang6,
                "Sambas Purnama Endang",
                "Mentor Coding",
                "Rp50.000"
            ),
            MentorCardModel(
                R.drawable.card_orang4,
                "Faza Atsmaro H.S",
                "Mentor Coding",
                "Rp50.000"
            ),
            MentorCardModel(
                R.drawable.carddzikri,
                "Dzikri Arfiansyah",
                "Mentor Coding",
                "Rp50.000"
            ),
            MentorCardModel(R.drawable.card_orang5, "Al Ikhsan Akbar", "Mentor Coding", "Rp50.000"),
            MentorCardModel(R.drawable.card_orang7, "Putri Alifia", "Mentor Coding", "Rp50.000"),
            MentorCardModel(
                R.drawable.card_orang6,
                "Sambas Purnama Endang",
                "Mentor Coding",
                "Rp50.000"
            ),
            MentorCardModel(
                R.drawable.card_orang4,
                "Faza Atsmaro H.S",
                "Mentor Coding",
                "Rp50.000"
            ),
            MentorCardModel(R.drawable.carddzikri, "Dzikri Arfiansyah", "Mentor Coding", "Rp50.000")

        )

        MentorCardAdapter(items, object : MentorCardAdapter.AdapterListener {
            override fun onClick(mentor: MentorCardModel) {
                Toast.makeText(requireContext(), "test!", Toast.LENGTH_LONG).show()
            }
        })
    }
}