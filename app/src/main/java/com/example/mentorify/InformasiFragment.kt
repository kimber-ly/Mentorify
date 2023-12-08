package com.example.mentorify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mentorify.Adapter.NotifProfileAdapter
import com.example.mentorify.Models.NotifProfileModel
import com.example.mentorify.databinding.FragmentInformasiBinding

class InformasiFragment : Fragment() {

    private lateinit var binding: FragmentInformasiBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentInformasiBinding.inflate(layoutInflater)

        val list = binding.listCardNotifProfile
        list.adapter = Peoples

        return binding.root
    }

    private val Peoples by lazy {

        val items = listOf<NotifProfileModel>(
            NotifProfileModel(R.drawable.people1_notif_profile, "Dzikri commented on your question"),
            NotifProfileModel(R.drawable.people2_notif_profile, "Putri  commented on your question"),
            NotifProfileModel(R.drawable.people3_notif_profile, "You've successfully booked a mentor today"),
            NotifProfileModel(R.drawable.people1_notif_profile, "Dzikri commented on your question"),
            NotifProfileModel(R.drawable.people2_notif_profile, "Putri  commented on your question"),
            NotifProfileModel(R.drawable.people3_notif_profile, "You've successfully booked a mentor today"),
            NotifProfileModel(R.drawable.people4_notif_profile, "You have successfully uploaded the question")

        )

        NotifProfileAdapter(items, object : NotifProfileAdapter.AdapterListener{
            override fun onClick(notif: NotifProfileModel) {
                Toast.makeText(activity, "test!", Toast.LENGTH_LONG).show()
            }
        })
    }
}