package com.example.demo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {
        binding.speakerScreen.setOnClickListener{
            val intent = Intent(this , MusicScreen::class.java)
            startActivity(intent)
        }

        binding.tvScreen.setOnClickListener{
            val intent = Intent(this, TelevisionScreen::class.java)
            startActivity(intent)
        }

        binding.acScreen.setOnClickListener{
            val intent = Intent(this, AirConditionerScreen::class.java)
            startActivity(intent)
        }
    }
}