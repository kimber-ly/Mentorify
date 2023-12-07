package com.example.mentorify

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.DatePicker
import android.widget.LinearLayout
import android.widget.TextView
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

        val btnSelect : Button = findViewById(R.id.btnSelectTime)
        btnSelect.setOnClickListener {
            val message : String? = "Pilih waktu yang tersedia"
            showCustomDialogBox(message)
        }

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

//        val btnbackavaibek: Button = findViewById(R.id.btn_backAvaibility)
//        btnbackavaibek.setOnClickListener(this)
//
        val btncheckavail: Button = findViewById(R.id.btn_checkAvaibility)
        btncheckavail.setOnClickListener(this)

        binding.btnBackAvaibility.setOnClickListener {
            onBackPressed();
        }

    }

    private fun showCustomDialogBox(message: String?) {
        val dialog = Dialog (this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.layout_time_picker_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val tvMessage : TextView = dialog.findViewById(R.id.tvMessage)
        val linear : LinearLayout = dialog.findViewById(R.id.linearBtn)
        val linear2 : LinearLayout = dialog.findViewById(R.id.linearBtn2)
        val btnYes : Button = dialog.findViewById(R.id.btnYes)
        val btnNo : Button = dialog.findViewById(R.id.btnNo)


        btnYes.setOnClickListener {
            Toast.makeText(this, "Click on Yes", Toast.LENGTH_LONG).show()
        }
        btnNo.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
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

//        TimePickerDialog(this, this, hour, minute, true).show()
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
//        savedHour = hourOfDay
//        savedMinute = minute

        binding.tvDateTime.text = "$savedDay-$savedMonth-$savedYear "

//        binding.tvDateWaktu.text = "Jam: $savedHour Minute: $savedMinute "
    }

    override fun onClick(v: View?) {
        if (v != null){
            when (v.id){
//                R.id.btn_backAvaibility -> {
//                    val intent = Intent(this@AvaibilityCheckActivity, OverviewActivity::class.java)
//                    startActivity(intent)
//                }
//
                    R.id.btn_checkAvaibility -> {
                    val intent2 = Intent(this@AvaibilityCheckActivity, pembayaran::class.java)
                    startActivity(intent2)
               }
            }
        }
    }
}