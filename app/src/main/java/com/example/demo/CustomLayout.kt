package com.example.demo

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.myapplication.R

class CustomLayout(context: Context, attrs: AttributeSet): ConstraintLayout(context, attrs) {

    init {
        setupCalculator()
    }

    private fun setupCalculator() {
        val layout = inflate(context, R.layout.activity_custom_layout_demo, this)
        val heightEdit = findViewById<EditText>(R.id.heightEdit)
        val weightEdit = findViewById<EditText>(R.id.weightEdit)
        val calculateBtn = findViewById<Button>(R.id.calculateBtn)
        val resultText = findViewById<TextView>(R.id.result)

        calculateBtn.setOnClickListener {

            if (heightEdit.text.isNotEmpty() && weightEdit.text.isNotEmpty()) {
                val height = heightEdit.text.toString().toInt()
                val weight = weightEdit.text.toString().toInt()

                val BMI = calculateBMI(height, weight)

                if (BMI < 16) {
                    resultText.text = "Underweight"
                } else if (BMI >= 16 && BMI < 25) {
                    resultText.text = "Normal"
                } else if (BMI >= 25 && BMI < 30) {
                    resultText.text = "Overweight"
                } else if (BMI >= 30) {
                    resultText.text = "Suffering from obesity"
                }
            } else {
                Toast.makeText(context, "enter height and weight", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun calculateBMI(height: Int, weight: Int): Float {
        val height = height.toFloat() / 100
        return weight.toFloat() / (height * height)
    }
}