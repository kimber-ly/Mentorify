package com.example.mentorify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class Profile_EditDataDiri : AppCompatActivity() {
    val genders = arrayOf<String>("Pilih","Laki-Laki", "Perempuan")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_edit_data_diri)
        val spinner = findViewById<Spinner>(R.id.et_gender_datadiripage)
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, genders)
        arrayAdapter.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item)

        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@Profile_EditDataDiri, "selected gender:"+genders[position], Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}