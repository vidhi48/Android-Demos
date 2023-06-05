package com.example.demo.screens

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demo.model.ResortChipModel
import com.example.demo.model.ResortInfo
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityResortScreenBinding

class ResortScreen : AppCompatActivity() {

    private lateinit var binding: ActivityResortScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResortScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupChips()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setupChips() {
        val info1 = ResortChipModel(applicationContext.getDrawable(R.drawable.baseline_bed_24)!!, "7 bedrooms")
        val info2 = ResortChipModel(applicationContext.getDrawable(R.drawable.baseline_pool_24)!!, "Open pull")
        val info3 = ResortChipModel(applicationContext.getDrawable(R.drawable.baseline_bathtub_24)!!, "3 bathtubs")
        val info4 = ResortChipModel(applicationContext.getDrawable(R.drawable.baseline_bed_24)!!, "7 bedrooms")
        binding.chipData1 = info1
        binding.chipData2 = info2
        binding.chipData3 = info3
        binding.chipData4 = info4
    }
}