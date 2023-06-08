package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivityMusicScreenBinding
import com.example.androidproject.databinding.ActivityTelevisionScreenBinding
import com.example.demo.models.AppBarModel
import com.example.demo.models.ButtonImageModel
import com.example.demo.models.MusicControlModel

class TelevisionScreen : AppCompatActivity() {

    lateinit var binding: ActivityTelevisionScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelevisionScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {
        val appBarData = AppBarModel("Smart Television", "Sony A9F")
        binding.actionbar = appBarData

        val musicControl = MusicControlModel(
            AppCompatResources.getDrawable(this, R.drawable.rewind),
            AppCompatResources.getDrawable(this, R.drawable.play),
            AppCompatResources.getDrawable(this, R.drawable.fastforward)
        )
        binding.musicControlCard = musicControl

        val keyboardButton = ButtonImageModel(
            AppCompatResources.getDrawable(this, R.drawable.baseline_keyboard_24),
            AppCompatResources.getDrawable(this, R.drawable.baseline_navigate_next_24),
            "Casting"
        )
        binding.keyboardBtn = keyboardButton
    }
}