package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivityButtonImagesBinding

class ButtonImages : AppCompatActivity() {

    lateinit var binding: ActivityButtonImagesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityButtonImagesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}