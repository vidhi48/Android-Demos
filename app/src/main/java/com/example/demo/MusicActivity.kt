package com.example.demo

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.content.res.AppCompatResources
import com.example.androidproject.R
import com.example.androidproject.R.*
import com.example.androidproject.databinding.ActivityMusicBinding
import com.example.demo.models.AppBarModel
import com.example.demo.models.ButtonImageModel
import com.example.demo.models.MusicControlModel

class MusicActivity : AppCompatActivity() {

    lateinit var binding: ActivityMusicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMusicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSeekBar()
        setupPowerButton()
        setupMusicButton()
        setupView()
    }

    private fun setupSeekBar() {

        val songInMinutes = 4.45
        val totalDurationsInSeconds = (songInMinutes * 60).toInt()
        binding.musicSeek.max = totalDurationsInSeconds

        binding.musicSeek.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

                val minutes = binding.musicSeek.progress / 60
                val seconds = binding.musicSeek.progress % 60
                val currentTime = String.format("%02d:%02d", minutes, seconds)
                binding.startText.text = currentTime

                val remainingProgress = totalDurationsInSeconds - binding.musicSeek.progress
                val remainingMinutes = remainingProgress / 60
                val remainingSeconds = remainingProgress % 60
                val remainingTime = String.format("%02d:%02d", remainingMinutes, remainingSeconds)
                binding.endText.text = remainingTime
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
        binding.card.power.setOnClickListener {
            isOn = !isOn
            if (isOn) {
                binding.card.textOn.setTextColor(Color.GRAY)
                binding.card.textOff.setTextColor(Color.BLACK)
            } else {
                binding.card.textOn.setTextColor(Color.BLACK)
                binding.card.textOff.setTextColor(Color.GRAY)
            }
        }
    }

    private fun setupMusicButton() {
        var isPlaying = false

        binding.card.pause.setOnClickListener {
            isPlaying = !isPlaying
            if (isPlaying) {
                binding.card.pause.setImageResource(drawable.play)
            } else {
                binding.card.pause.setImageResource(drawable.pause)
            }
        }
    }

    private fun setupView() {

        binding.appBar.appToolBar.setNavigationOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val appBarData = AppBarModel(string.musicApp, string.musicAppSub)
        binding.actionBar = appBarData

        val musicControl = MusicControlModel(
            AppCompatResources.getDrawable(this, drawable.back),
            AppCompatResources.getDrawable(this, drawable.next)
        )
        binding.musicControlCard = musicControl

        val castingButton = ButtonImageModel(
            AppCompatResources.getDrawable(this, drawable.baseline_cast_24),
            AppCompatResources.getDrawable(this, drawable.baseline_navigate_next_24),
            string.casting
        )
        binding.castingBtn = castingButton
    }
}