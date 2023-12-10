package com.example.mentorify

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.mentorify.Adapter.MentorCardAdapter
import com.example.mentorify.Models.MentorCardModel
import com.example.mentorify.Utils.SearchPageSection
import com.example.mentorify.databinding.FragmentMentorBinding

class MentorFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentMentorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMentorBinding.inflate(layoutInflater)
        binding.mentorRecyclerView.adapter = Mentor


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnfaza: Button = binding.sortBtnDeh
        btnfaza.setOnClickListener(this)

        val btnfilter: Button = binding.filterBtn
        btnfilter.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.sort_btn_deh) {
            val int = Intent(requireActivity(), SearchPageSection::class.java)
            startActivity(int)
        }else if(v?.id == R.id.filter_btn){
            val int = Intent(requireActivity(), filter::class.java)
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