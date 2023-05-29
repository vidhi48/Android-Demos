package com.example.demo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class SplashScreenDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen_demo)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashScreenDemo, SeriesDemoActivity::class.java)
            startActivity(intent)
        }, 2000)
    }
}