package com.example.demo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.model.SeriesViewModel
import com.example.myapplication.databinding.ActivitySeriesDemoBinding

class SeriesDemoActivity: AppCompatActivity() {

    private lateinit var binding: ActivitySeriesDemoBinding
    private val viewModel: SeriesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySeriesDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.seriesData = viewModel
        binding.lifecycleOwner = this
    }
}