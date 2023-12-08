package com.example.mentorify

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.example.mentorify.databinding.ActivityProfileEditDataDiriBinding
import java.text.SimpleDateFormat
import java.time.Year
import java.util.Calendar
import java.util.Date
import java.util.Locale

class Profile_EditDataDiri : AppCompatActivity() {
    val genders = arrayOf<String>("Pilih","Laki-Laki", "Perempuan")
    private lateinit var binding: ActivityProfileEditDataDiriBinding
    lateinit var datePickerBtn : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileEditDataDiriBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val backBtn = findViewById<ImageView>(R.id.back_btn_datadiripage)
//        backBtn.setOnClickListener {
//            Toast.makeText(this@Profile_EditDataDiri, "this is back button", Toast.LENGTH_LONG).show()
//        }

        binding.backBtnDatadiripage.setOnClickListener {
            onBackPressed()
        }

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
        val items = listOf("Institut Teknologi Bandung", "Universitas Gadjah Mada", "Universitas Indonesia", "Universitas Padjajaran")

        val autoComplete : AutoCompleteTextView = findViewById(R.id.auto_completeUniv)

        val adapter = ArrayAdapter(this,R.layout.list_item,items)

        autoComplete.setAdapter(adapter)

        autoComplete.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, _, i, l ->

            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(this,"Item: $itemSelected", Toast.LENGTH_SHORT).show()
        }



        //date picker
        datePickerBtn = findViewById(R.id.et_date_datadiripage)
        val myCalendar = Calendar.getInstance()
        val dPicker = DatePickerDialog.OnDateSetListener{ view, year, month, dayOfMonth ->
            setTheme(R.style.Theme_Mentorify)
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updatelable(myCalendar)
        }


        datePickerBtn.setOnClickListener {
            DatePickerDialog(this, dPicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

    private fun updatelable(c : Calendar){
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        datePickerBtn.setText(sdf.format(c.time))
    }

}