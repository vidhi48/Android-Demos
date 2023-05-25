package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.R

class RelativeLayoutDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative_layout_demo)

        val buttonSignup = findViewById<Button>(R.id.register)
        buttonSignup.setOnClickListener{
            Toast.makeText(this, "Register Successfully", Toast.LENGTH_SHORT).show()
        }
    }
}