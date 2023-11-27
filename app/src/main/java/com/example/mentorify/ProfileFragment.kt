package com.example.mentorify

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import com.example.mentorify.Utils.SearchPageSection

class ProfileFragment : Fragment() {
    private lateinit var btnEditProfile : LinearLayout
    private lateinit var btnSavedMentor : LinearLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)


        //<----- intent edit profile ----->
        btnEditProfile = view.findViewById(R.id.datadiri_btn_profile)
        btnEditProfile.setOnClickListener {
            startActivity(Intent(requireActivity(), Profile_EditDataDiri::class.java))
        }


        //<----- intent saved mentor ----->
        btnSavedMentor = view.findViewById(R.id.saved_btn_profile)
        btnSavedMentor.setOnClickListener {
            startActivity(Intent(requireActivity(), Profile_SavedMentor::class.java))
        }

        return view
    }
}