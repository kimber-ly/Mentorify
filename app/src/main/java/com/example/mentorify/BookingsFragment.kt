package com.example.mentorify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import com.example.mentorify.Adapter.vpBokingsAdapter
import com.example.mentorify.databinding.FragmentBookingsBinding
import com.google.android.material.search.SearchBar

class BookingsFragment : Fragment() {
    private var _binding: FragmentBookingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookingsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        val adapter = vpBokingsAdapter(childFragmentManager)

        adapter.addFragment(UpcomingBookingFragment(),"Upcoming")
        adapter.addFragment(PendingBookingFragment(),"Pending")
        adapter.addFragment(HistoryBookingFragment(),"History")

        binding.vpBookings.adapter = adapter
        binding.tabLayoutBookings.setupWithViewPager(binding.vpBookings)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}