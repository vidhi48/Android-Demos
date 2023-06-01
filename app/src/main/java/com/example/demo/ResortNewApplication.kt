package com.example.demo

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import com.example.myapplication.databinding.ActivityResortNewApplicationBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.text.NumberFormat
import java.util.Calendar
import java.util.Currency


class ResortNewApplication(context: Context) : BottomSheetDialog(context) {

    private lateinit var binding: ActivityResortNewApplicationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResortNewApplicationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
        closeKeyboard()
    }

    private fun setupViews() {
        binding.dateText.setOnClickListener {
            val calender = Calendar.getInstance()
            val year = calender.get(Calendar.YEAR)
            val month = calender.get(Calendar.MONTH)
            val date = calender.get(Calendar.DATE)

            val datePickerDialog = DatePickerDialog(
                context, { _, year, monthOfYear, dayOfMonth ->
                    val selectedDate =
                        (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    binding.dateText.setText(selectedDate)
                }, year, month, date
            )
            datePickerDialog.show()
        }

        binding.rangeSlider.setLabelFormatter { value: Float ->
            val format = NumberFormat.getCurrencyInstance()
            format.maximumFractionDigits = 0
            format.currency = Currency.getInstance("USD")
            format.format(value.toDouble())
        }

        binding.rangeSlider.addOnChangeListener { slider, _, _ ->
            binding.priceData.text = "$${slider.values[0]} - $${slider.values[1]}"
        }

        val resorts = listOf(
            "Any type",
            "Adventure Resorts",
            "Beach Resorts",
            "Golf Resorts",
            "Luxury Resorts"
        )
        val adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, resorts)
        binding.typeSpinner.adapter = adapter

        binding.typeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

    }

    private fun closeKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val keyboard = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            keyboard.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

}