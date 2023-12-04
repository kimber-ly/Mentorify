package com.example.mentorify

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.mentorify.Utils.SearchPageSection

class ProfileFragment : Fragment() {
    private lateinit var btnEditProfile : LinearLayout
    private lateinit var btnNotifProfile : LinearLayout
    private lateinit var btnSecurityProfile : LinearLayout
    private lateinit var btnHistory : LinearLayout
    private lateinit var btnSavedMentor : LinearLayout
    private lateinit var btnBecomeMentor : TextView
    private lateinit var logout : ImageView

    @SuppressLint("MissingInflatedId")
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


        //<----- intent history transaction ----->
        btnHistory = view.findViewById(R.id.historyTrans_btn_profile)
        btnHistory.setOnClickListener {
            startActivity(Intent(requireActivity(), Profile_RiwayatTransaksi::class.java))
        }

        //<----- evt notif ----->
        btnNotifProfile = view.findViewById(R.id.notif_btn_profile)
        btnNotifProfile.setOnClickListener {
            startActivity(Intent(requireActivity(), Profile_Notifikasi::class.java))
        }

        //<----- evt secure ----->
        btnSecurityProfile = view.findViewById(R.id.secureity_btn_profile)
        btnSecurityProfile.setOnClickListener {
            Toast.makeText(activity, "test", Toast.LENGTH_LONG).show()
        }

        //<----- evt btn become mentor ----->
        btnBecomeMentor = view.findViewById(R.id.switch_mentor_btn_profile)
        btnBecomeMentor.setOnClickListener {
            Toast.makeText(activity, "test", Toast.LENGTH_LONG).show()
        }

        //<----- evt btn logout ----->
        logout = view.findViewById(R.id.logout)
        logout.setOnClickListener {

            val builder = AlertDialog.Builder(requireActivity())
            builder.setTitle("Confirm")
            builder.setMessage("Anda yakin mau melakukan log out?")
//            builder.setIcon(android.R.drawable.ic_dialog_alert)
            builder.setCancelable(false)
            builder.setPositiveButton("Yes"){ dialogInterface, _ ->
                startActivity(Intent(requireActivity(), LoginActivity::class.java))
                dialogInterface.cancel()
            }
            builder.setNeutralButton("Cancel"){ dialogInterface, _ ->
                dialogInterface.cancel()
            }
            builder.setNegativeButton("No"){ dialogInterface, _ ->
                dialogInterface.cancel()
            }
            builder.create().show()


        }


        return view
    }
}