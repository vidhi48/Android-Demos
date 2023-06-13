package com.example.demo

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
            val intent = Intent(this , MusicActivity::class.java)
            startActivity(intent)
        }

        binding.tvScreen.setOnClickListener{
            val intent = Intent(this, TelevisionActivity::class.java)
            startActivity(intent)
        }

        binding.acScreen.setOnClickListener{
            val intent = Intent(this, AirConditionerActivity::class.java)
            startActivity(intent)
        }
    }
}