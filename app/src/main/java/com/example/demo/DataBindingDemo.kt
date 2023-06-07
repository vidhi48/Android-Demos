package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.demo.model.DemoViewModel
import com.example.myapplication.databinding.ActivityDataBindingDemoBinding

class DataBindingDemo : AppCompatActivity() {

    private lateinit var binding: ActivityDataBindingDemoBinding
    private val viewModel: DemoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDataBindingDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.demo = viewModel
        binding.lifecycleOwner = this
    }
}