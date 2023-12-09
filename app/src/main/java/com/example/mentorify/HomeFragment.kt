package com.example.mentorify

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mentorify.Adapter.MentorCardAdapter
import com.example.mentorify.Adapter.PopularKategoriAdapter
import com.example.mentorify.Models.MentorCardModel
import com.example.mentorify.Models.PopularKategoryModel
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

        binding.searchBarHome.setOnClickListener {
            startActivity(Intent(requireActivity(), SearchPageSection::class.java))
        }

        val adapter = PopularKategoriAdapter(popularMentorData())
        binding.popularKategoriContent.adapter = adapter
        binding.popularKategoriContent.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.topMatchesRecycler.adapter = Mentor
        binding.topMatchesRecycler.layoutManager = GridLayoutManager(requireContext(), 2)

        return binding.root
    }

    private fun popularMentorData(): ArrayList<PopularKategoryModel> {
        return arrayListOf(
            PopularKategoryModel(
                image = R.drawable.card_orang8,
                name = "Tommy Widjaja",
                occasion = "Android Developer",
                price = "Rp50.000",
                rating = "4.5",
                session = "20 sessions (15 reviews)"
            ),
            PopularKategoryModel(
                image = R.drawable.carddzikri,
                name = "Dzikri Arfiansyah",
                occasion = "Mentor Teknik Industri",
                price = "Rp50.000",
                rating = "4.6",
                session = "18 sessions (17 reviews)"
            ),
            PopularKategoryModel(
                image = R.drawable.card_orang4,
                name = "Faza Atsmaro",
                occasion = "Mentor Coding",
                price = "Rp50.000",
                rating = "4.4",
                session = "15 sessions (13 reviews)"
            ),
            PopularKategoryModel(
                image = R.drawable.card_orang1,
                name = "Siti Aulia",
                occasion = "Mentor Design",
                price = "Rp50.000",
                rating = "4.8",
                session = "23 sessions (18 reviews)"
            ),
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val btnsiti: Button = binding.btnSelengkapnyasiti
//        btnsiti.setOnClickListener(this)

        val btndzik: TextView = binding.btnSeeallPopular
        btndzik.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
//        if (v?.id == R.id.btn_selengkapnyasiti){
//            val int = Intent(activity, OverviewActivity::class.java)
//            startActivity(int)
//        }
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
//                Toast.makeText(requireContext(), "test!", Toast.LENGTH_LONG).show()
//                val intent = Intent(requireContext(), OverviewActivity::class.java)
//                startActivity(intent)
            }
        })
    }
}