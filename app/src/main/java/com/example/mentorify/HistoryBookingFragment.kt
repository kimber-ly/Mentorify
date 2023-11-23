package com.example.mentorify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mentorify.Adapter.HistoryBookingAdapter
import com.example.mentorify.Models.HistoryBookingDataClass
import com.example.mentorify.databinding.FragmentHistoryBookingBinding
import kotlin.collections.ArrayList

class HistoryBookingFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBookingBinding
    private lateinit var adapter: HistoryBookingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHistoryBookingBinding.inflate(inflater, container, false)
        val view = binding.root

        adapter = HistoryBookingAdapter(dataset())
        binding.rvHistory.adapter = adapter
        binding.rvHistory.layoutManager = LinearLayoutManager(requireActivity())

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
