package com.example.mentorify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mentorify.Adapter.HistoryBookingAdapter
import com.example.mentorify.Adapter.UpcomingBookingAdapter
import com.example.mentorify.Models.HistoryBookingDataClass
import com.example.mentorify.databinding.FragmentHistoryBookingBinding
import com.example.mentorify.databinding.FragmentUpcomingBookingBinding


class UpcomingBookingFragment : Fragment() {
    private lateinit var binding: FragmentUpcomingBookingBinding
    private lateinit var adapter: UpcomingBookingAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUpcomingBookingBinding.inflate(inflater, container, false)
        val view = binding.root

        adapter = UpcomingBookingAdapter(dataset())
        binding.rvUpcoming.adapter = adapter
        binding.rvUpcoming.layoutManager = LinearLayoutManager(requireActivity())

        return view
    }

    private fun dataset(): ArrayList<HistoryBookingDataClass> {
        val dataNameMentor = resources.getStringArray(R.array.mentor_name)
        val dataDateHistory = resources.getStringArray(R.array.date)
        val dataTime = resources.getStringArray(R.array.time)
        val dataHistory = ArrayList<HistoryBookingDataClass>()

        for (i in dataNameMentor.indices) {
            val history = HistoryBookingDataClass(dataNameMentor[i], dataDateHistory[i], dataTime[i])
            dataHistory.add(history)
        }
        return dataHistory

    }


}