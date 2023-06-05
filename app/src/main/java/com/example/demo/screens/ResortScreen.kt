package com.example.demo.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityResortScreenBinding

class ResortScreen : AppCompatActivity() {

    private lateinit var binding: ActivityResortScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResortScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}