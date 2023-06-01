package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.myapplication.databinding.ActivityResortApplicationScreenBinding

class ResortApplicationScreen : AppCompatActivity() {

    lateinit var binding: ActivityResortApplicationScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResortApplicationScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingButton.setOnClickListener{
            showBottomSheet()
        }
    }

    private fun showBottomSheet() {
        val dialog = ResortNewApplication(this)
        dialog.behavior.peekHeight = 1950
        dialog.show()
    }
}