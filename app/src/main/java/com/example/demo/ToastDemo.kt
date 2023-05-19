package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ToastDemo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast_demo)
        toastDemo()
        customToast()
    }

    private fun toastDemo() {
        val button1 = findViewById<Button>(R.id.toastButton)
        val edittext1 = findViewById<EditText>(R.id.editName)
        button1.setOnClickListener {
            lifecycleScope.launch {
                delay(1000)
                Toast.makeText(this@ToastDemo, "Welcome: " + edittext1.text.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun customToast() {
    }
}