package com.example.demo


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityResortNewApplicationBinding

class ResortNewApplication : AppCompatActivity() {

    private lateinit var binding: ActivityResortNewApplicationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResortNewApplicationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.newText.text = "hwief"
    }
}