package com.example.demo.screens

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demo.model.DrawableResource
import com.example.demo.model.ResortChipModel
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityResortScreenBinding

class ResortScreen : AppCompatActivity() {

    private lateinit var binding: ActivityResortScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResortScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setupViews() {
        val info1 =
            ResortChipModel(DrawableResource.Drawable(R.drawable.baseline_bed_24), "7 bedrooms")
        val info2 =
            ResortChipModel(DrawableResource.Drawable(R.drawable.baseline_pool_24), "Open pull")
        val info3 =
            ResortChipModel(DrawableResource.Drawable(R.drawable.baseline_bathtub_24), "3 bathtubs")
        binding.chipData1 = info1
        binding.chipData2 = info2
        binding.chipData3 = info3
    }
}