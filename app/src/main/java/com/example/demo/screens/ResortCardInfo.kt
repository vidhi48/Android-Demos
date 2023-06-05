package com.example.demo.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityResortCardInfoBinding

class ResortCardInfo : AppCompatActivity() {

    lateinit var binding: ActivityResortCardInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResortCardInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}