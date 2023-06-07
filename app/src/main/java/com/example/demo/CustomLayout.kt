package com.example.demo

import android.content.Context
import android.util.AttributeSet
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityCustomLayoutDemoBinding

class CustomLayout(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    lateinit var binding: ActivityCustomLayoutDemoBinding

    init {
        setupCalculator()
    }

    private fun setupCalculator() {
        inflate(context, R.layout.activity_custom_layout_demo, this)
        val heightEdit = binding.heightEdit
        val weightEdit = binding.weightEdit
        val calculateBtn = binding.calculateBtn
        val resultText = binding.result

        calculateBtn.setOnClickListener {

            if (heightEdit.text?.isNotEmpty() == true && weightEdit.text?.isNotEmpty() == true) {
                val height = heightEdit.text.toString().toInt()
                val weight = weightEdit.text.toString().toInt()

                val bmiCalculate = calculateBMI(height, weight)

                if (bmiCalculate < 16) {
                    "Underweight".also { resultText.text = it }
                } else if (bmiCalculate >= 16 && bmiCalculate < 25) {
                    "Normal".also { resultText.text = it }
                } else if (bmiCalculate >= 25 && bmiCalculate < 30) {
                    "Overweight".also { resultText.text = it }
                } else if (bmiCalculate >= 30) {
                    "Suffering from obesity".also { resultText.text = it }
                }
            } else {
                Toast.makeText(context, "enter height and weight", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun calculateBMI(_height: Int, _weight: Int): Float {
        val height = _height.toFloat() / 100
        return _weight.toFloat() / (height * height)
    }
}