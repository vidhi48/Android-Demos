package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.R

class LinearLayoutDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_layout_demo)

        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener{
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
        }
    }
}