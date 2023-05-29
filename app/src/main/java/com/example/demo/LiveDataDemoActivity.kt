package com.example.demo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.model.LiveDataModel
import com.example.myapplication.databinding.ActivityLiveDataDemoBinding

class LiveDataDemoActivity: AppCompatActivity() {

    private lateinit var binding: ActivityLiveDataDemoBinding
    private val viewModel: LiveDataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLiveDataDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.updatedText = viewModel
        binding.lifecycleOwner = this
    }

}