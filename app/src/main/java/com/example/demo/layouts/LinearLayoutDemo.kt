package com.example.demo.layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import com.example.demo.model.Person
import com.example.demo.model.ViewModelDemo
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityDataBindingBinding
import com.example.myapplication.databinding.ActivityLinearLayoutDemoBinding

class LinearLayoutDemo : AppCompatActivity() {

    private lateinit var binding: ActivityLinearLayoutDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLinearLayoutDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val person = Person("vidhi")
        binding.updateText = person

        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener{
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
        }
    }
}