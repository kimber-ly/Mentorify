package com.example.mentorify.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mentorify.InformasiFragment
import com.example.mentorify.OrderStatusFragment

class ViewPagerAdapterNotifikasi (fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        var fragment = Fragment()
        when(position){
            0 -> fragment = InformasiFragment()
            1 -> fragment = OrderStatusFragment()
        }
        return fragment
    }
}