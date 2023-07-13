package com.example.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivityMainBinding
import com.example.demo.webservices.activities.DisplayUsersActivity
import com.example.demo.webservices.activities.ImageUploadActivity
import com.example.demo.webservices.activities.NewsActivity
import com.example.demo.webservices.activities.RegisterUserActivity
import com.example.demo.webservices.activities.RegisterUserOkHttpActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() = with(binding) {

        loginHttp.setOnClickListener {
            val intent = Intent(this@MainActivity, DisplayUsersActivity::class.java)
            startActivity(intent)
        }

        displayRetrofit.setOnClickListener {
            val intent = Intent(this@MainActivity, RegisterUserActivity::class.java)
            startActivity(intent)
        }

        apiOkhttp.setOnClickListener {
            val intent = Intent(this@MainActivity, RegisterUserOkHttpActivity::class.java)
            startActivity(intent)
        }

        imageUpload.setOnClickListener {
            val intent = Intent(this@MainActivity, ImageUploadActivity::class.java)
            startActivity(intent)
        }

        news.setOnClickListener {
            val intent = Intent(this@MainActivity, NewsActivity::class.java)
            startActivity(intent)
        }
    }
}