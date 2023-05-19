package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.example.myapplication.R

class CheckboxDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox_demo)
        checkboxAction()
    }

    private fun checkboxAction() {
        val checkboxPainting = findViewById<CheckBox>(R.id.checkbox1)
        val checkboxReading = findViewById<CheckBox>(R.id.checkbox2)
        val checkboxSinging = findViewById<CheckBox>(R.id.checkbox3)
        val checkboxCooking = findViewById<CheckBox>(R.id.checkbox4)
        val button1 = findViewById<Button>(R.id.selectedButton)

        button1.setOnClickListener{
            var message = " "
            if (checkboxPainting.isChecked) {
                message += checkboxPainting.text.toString()
            }
            if (checkboxReading.isChecked) {
                message += checkboxReading.text.toString()
            }
            if (checkboxSinging.isChecked) {
                message += checkboxSinging.text.toString()
            }
            if (checkboxCooking.isChecked) {
                message += checkboxCooking.text.toString()
            }
            Toast.makeText(this, "Selected hobbies are: $message", Toast.LENGTH_SHORT).show()
        }
    }
}