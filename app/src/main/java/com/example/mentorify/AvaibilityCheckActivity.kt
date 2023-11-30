package com.example.mentorify

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import com.example.mentorify.databinding.ActivityAvaibilityCheckBinding
import java.util.Calendar

class AvaibilityCheckActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener,
    View.OnClickListener {

    private lateinit var binding: ActivityAvaibilityCheckBinding

    var day = 0
    var month = 0
    var year = 0
    var hour = 0
    var minute = 0

    var savedDay = 0
    var savedMonth = 0
    var savedYear = 0
    var savedHour = 0
    var savedMinute = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAvaibilityCheckBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pickDate()

        val items = listOf("Kotlin", "Java", "My Sql", "FireBase DataBase")

        val autoComplete : AutoCompleteTextView = findViewById(R.id.auto_complete)

        val adapter = ArrayAdapter(this,R.layout.list_item,items)

        autoComplete.setAdapter(adapter)

        autoComplete.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->

            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(this,"Item: $itemSelected", Toast.LENGTH_SHORT).show()
        }

        val btnbackavaibek: Button = findViewById(R.id.btn_backAvaibility)
        btnbackavaibek.setOnClickListener(this)

        val btncheckavail: Button = findViewById(R.id.btn_checkAvaibility)
        btncheckavail.setOnClickListener(this)

    }

    private fun getDateTimeCalendar(){
        val cal = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
        hour = cal.get(Calendar.HOUR)
        minute = cal.get(Calendar.MINUTE)
    }

    private fun pickDate() {
        binding.btnChange.setOnClickListener {
            getDateTimeCalendar()

            DatePickerDialog(this, this, year, month, day).show()
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        savedDay = dayOfMonth
        savedMonth = month
        savedYear = year

        getDateTimeCalendar()

        TimePickerDialog(this, this, hour, minute, true).show()
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        savedHour = hourOfDay
        savedMinute = minute

        binding.tvDateTime.text = "$savedDay-$savedMonth-$savedYear "

        binding.tvDateWaktu.text = "Hour: $savedHour Minute:$savedMinute "
    }

    override fun onClick(v: View?) {
        if (v != null){
            when (v.id){
                R.id.btn_backAvaibility -> {
                    val intent = Intent(this@AvaibilityCheckActivity, OverviewActivity::class.java)
                    startActivity(intent)
                }

                R.id.btn_checkAvaibility -> {
                    val intent2 = Intent(this@AvaibilityCheckActivity, pembayaran::class.java)
                    startActivity(intent2)
                }
            }
        }
    }



}