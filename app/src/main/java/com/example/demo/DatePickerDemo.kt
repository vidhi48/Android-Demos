package com.example.demo

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.R
import java.util.Calendar

class DatePickerDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker_demo)
        setupDatePicker()
        setupTimePicker()
    }

    private fun setupDatePicker() {
        val datePicker = findViewById<Button>(R.id.dateButton)
        val selectedDate = findViewById<TextView>(R.id.selectedDate)
        datePicker.setOnClickListener{
            val calender = Calendar.getInstance()
            val year = calender.get(Calendar.YEAR)
            val month = calender.get(Calendar.MONTH)
            val date = calender.get(Calendar.DATE)

            val datePickerDialog = DatePickerDialog(this, { _, year, monthOfYear, dayOfMonth ->
                    selectedDate.text = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                }, year, month, date
            )
            datePickerDialog.show()
        }
    }

    private fun setupTimePicker() {
        val timePicker = findViewById<Button>(R.id.timeButton)
        val selectedTime = findViewById<TextView>(R.id.selectedTime)
        timePicker.setOnClickListener{
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR)
            val minute = calendar.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(this, { _, hourOfDay, minute ->
                selectedTime.text = "$hourOfDay:$minute"
                }, hour, minute,false
            )
            timePickerDialog.show()
        }
    }
}