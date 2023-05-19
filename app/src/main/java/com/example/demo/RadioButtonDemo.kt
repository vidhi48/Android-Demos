package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.myapplication.R

class RadioButtonDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button_demo)
        radioAction()
    }

    private fun radioAction() {
        val radioGroup1 = findViewById<RadioGroup>(R.id.radioGroup)
        radioGroup1.setOnCheckedChangeListener { _, checkedId ->
            val radioButton = findViewById<RadioButton>(checkedId)
            Toast.makeText(this, radioButton.text, Toast.LENGTH_SHORT).show()
        }
    }
}