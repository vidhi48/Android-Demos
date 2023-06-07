package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivityMusicScreenBinding
import com.example.demo.models.ButtonImageModel

class MusicScreen : AppCompatActivity() {

    lateinit var binding: ActivityMusicScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMusicScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun setupView() {
        var button1 = ButtonImageModel(
            AppCompatResources.getDrawable(this, R.drawable.baseline_cast_24)!!, AppCompatResources.getDrawable(this, R.drawable.baseline_navigate_next_24)!!
        )
    }
}