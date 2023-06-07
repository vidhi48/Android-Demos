package com.example.demo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class SplashScreenDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen_demo)

        val backgroundImage: ImageView = findViewById(R.id.splashImage)
        backgroundImage.animation = AnimationUtils.loadAnimation(this, R.anim.splash_animation)
        backgroundImage.animation.start()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashScreenDemo, SeriesDemoActivity::class.java)
            startActivity(intent)
        }, 2000)
    }
}