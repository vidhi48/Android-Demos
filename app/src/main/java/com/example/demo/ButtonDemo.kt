package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.R

class ButtonDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button_demo)
        buttonToast()
    }

    private fun buttonToast() {
        val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener() {
            Toast.makeText(this, "Button Tapped", Toast.LENGTH_SHORT).show()
        }
    }
}