package com.example.demo.screens

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.demo.model.NewApplicationViewModel
import com.example.myapplication.databinding.ActivityResortNewApplicationBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.chip.Chip
import java.text.NumberFormat
import java.util.Calendar
import java.util.Currency

class ResortNewApplication(private val activity: AppCompatActivity) : BottomSheetDialog(activity) {

    private lateinit var binding: ActivityResortNewApplicationBinding
    private var viewModel: NewApplicationViewModel =
        ViewModelProvider(activity)[NewApplicationViewModel::class.java]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResortNewApplicationBinding.inflate(layoutInflater)
        binding.lifecycleOwner = activity
        binding.newApplicationViewModel = viewModel
        setContentView(binding.root)

        setupPicker()
        setupViews()
    }

    private fun setupPicker() {

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

        val resorts = listOf(
            "Any type",
            "Adventure Resorts",
            "Beach Resorts",
            "Golf Resorts",
            "Luxury Resorts"
        )
        val adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, resorts)
        binding.typeSpinner.adapter = adapter

        binding.typeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    private fun setupViews() {
        binding.rangeSlider.setLabelFormatter { value: Float ->
            val format = NumberFormat.getCurrencyInstance()
            format.maximumFractionDigits = 0
            format.currency = Currency.getInstance("USD")
            format.format(value.toDouble())
        }

        var price = ""
        binding.rangeSlider.addOnChangeListener { slider, _, _ ->
            price = "$${slider.values[0]} - $${slider.values[1]}"
            binding.priceData.text = price
        }

        val selectedList = mutableListOf<String>()
        for (i in 0 until binding.chipGroup.childCount) {
            val chip = binding.chipGroup.getChildAt(i) as Chip
            chip.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    selectedList.add(chip.text.toString())
                }
            }
        }

        var destination = ""
        viewModel.destination.observe(this) {
            destination = it
        }

        var date = ""
        viewModel.date.observe(this) {
            date = it
        }

        var night = ""
        viewModel.nights.observe(this) {
            night = it
        }

        var guests = ""
        viewModel.guests.observe(this) {
            guests = it
        }

        var bedrooms = ""
        viewModel.bedrooms.observe(this) {
            bedrooms = it
        }

        binding.bookBtn.setOnClickListener {
            Toast.makeText(
                activity, "Destination: $destination\nDate: $date\nNights: $night " +
                        "\nGuests: $guests \nBedrooms: $bedrooms \nPrice: $price" +
                        "\nSelected Features: $selectedList", Toast.LENGTH_SHORT
            ).show()
        }
        closeKeyboard()
    }

    private fun closeKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val keyboard =
                context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            keyboard.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}
