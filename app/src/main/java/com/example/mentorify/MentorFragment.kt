package com.example.mentorify

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.mentorify.Utils.SearchPageSection

class MentorFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mentor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnfaza: Button = view.findViewById(R.id.sort_btn_deh)
        btnfaza.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.sort_btn_deh){
            val int = Intent(requireActivity(), SearchPageSection::class.java)
            startActivity(int)
        }
    }
}