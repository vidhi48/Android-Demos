package com.example.demo

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import com.example.androidproject.R
import com.example.androidproject.R.*
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

        setupSeekBar()
        setupPowerButton()
        setupView()
    }

    private fun setupSeekBar() {

        binding.musicSeek.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

                binding.startText.text = p1.toString()
                binding.endText.text = p1.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        }
        )
    }

    private fun setupPowerButton() {
        var isOn = false
        binding.card.power.setOnClickListener{
            isOn = if (isOn) {
                binding.card.textOn.setTextColor(Color.GRAY)
                binding.card.textOff.setTextColor(Color.BLACK)
                false
            } else {
                binding.card.textOn.setTextColor(Color.BLACK)
                binding.card.textOff.setTextColor(Color.GRAY)
                true
            }
        }
    }

    private fun setupView() {

        binding.appBar.appToolBar.setNavigationOnClickListener {
            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
        }

        val appBarData = AppBarModel("Speaker", "Apple HomePod")
        binding.actionBar = appBarData

        val musicControl = MusicControlModel(
            AppCompatResources.getDrawable(this, drawable.back),
            AppCompatResources.getDrawable(this, drawable.pause),
            AppCompatResources.getDrawable(this, drawable.next)
        )
        binding.musicControlCard = musicControl

        val castingButton = ButtonImageModel(
            AppCompatResources.getDrawable(this, drawable.baseline_cast_24),
            AppCompatResources.getDrawable(this, drawable.baseline_navigate_next_24),
            "Casting"
        )
        binding.castingBtn = castingButton
    }
}