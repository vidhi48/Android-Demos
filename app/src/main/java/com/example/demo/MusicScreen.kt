package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivityMusicScreenBinding
import com.example.demo.models.AppBarModel
import com.example.demo.models.ButtonImageModel
import com.example.demo.models.MusicControlModel

class MusicScreen : AppCompatActivity() {

    lateinit var binding: ActivityMusicScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMusicScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {

        val appBarData = AppBarModel("Speaker", "Apple HomePod")
        binding.actionBar = appBarData

        val musicControl = MusicControlModel(
            AppCompatResources.getDrawable(this, R.drawable.back),
            AppCompatResources.getDrawable(this, R.drawable.pause),
            AppCompatResources.getDrawable(this, R.drawable.next)
        )
        binding.musicControlCard = musicControl

        val castingButton = ButtonImageModel(
            AppCompatResources.getDrawable(this, R.drawable.baseline_cast_24),
            AppCompatResources.getDrawable(this, R.drawable.baseline_navigate_next_24),
            "Casting"
        )
        binding.castingBtn = castingButton
    }
}