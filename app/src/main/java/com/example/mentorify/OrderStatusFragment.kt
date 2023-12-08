package com.example.mentorify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mentorify.Adapter.OrderNotifProfileAdapter
import com.example.mentorify.Models.OrderNotifProfileModel
import com.example.mentorify.databinding.FragmentOrderStatusBinding

class OrderStatusFragment : Fragment() {

    private lateinit var binding: FragmentOrderStatusBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentOrderStatusBinding.inflate(layoutInflater)

        val list = binding.listOrderNotifProfile
        list.adapter = Orders

        return binding.root
    }

    private val Orders by lazy {

        val items = listOf<OrderNotifProfileModel>(
            OrderNotifProfileModel(R.drawable.card_orang4,
                "Mentor Coding", "2311071YC6JWQX", "12 - 11 - 2024", "16:05"),
            OrderNotifProfileModel(R.drawable.card_orang5,
                "Mentor Coding", "2311071YC6JWQX", "12 - 11 - 2024", "16:05"),
            OrderNotifProfileModel(R.drawable.card_orang6,
                "Mentor Coding", "2311071YC6JWQX", "12 - 11 - 2024", "16:05"),
            OrderNotifProfileModel(R.drawable.card_orang7,
                "Mentor Coding", "2311071YC6JWQX", "12 - 11 - 2024", "16:05"),
            OrderNotifProfileModel(R.drawable.carddzikri,
                "Mentor Coding", "2311071YC6JWQX", "12 - 11 - 2024", "16:05")

        )

        OrderNotifProfileAdapter(items, object : OrderNotifProfileAdapter.AdapterListener{
            override fun onClick(order: OrderNotifProfileModel) {
                Toast.makeText(activity, "test!", Toast.LENGTH_LONG).show()
            }
        })


    }
}