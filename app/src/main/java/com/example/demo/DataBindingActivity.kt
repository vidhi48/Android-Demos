package com.example.demo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.model.ViewModelDemo
import com.example.myapplication.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDataBindingBinding
    private val viewModel: ViewModelDemo by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDataBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.dataModel = viewModel
    }
}