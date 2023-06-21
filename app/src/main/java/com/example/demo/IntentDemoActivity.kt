package com.example.demo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidproject.databinding.ActivityIntentDemoBinding

class IntentDemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntentDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIntentDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupButtons()
    }

    private fun setupButtons() {
        binding.explicitIntent.setOnClickListener{

            val passData = binding.passData.text.toString()
            val intent = Intent(this, LifeCycleActivity::class.java)
            intent.putExtra("data", passData)
            startActivity(intent)
        }

        binding.implicitIntent.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))
            startActivity(intent)
        }

        binding.location.setOnClickListener {
            val location = Uri.parse("geo:23.028602304078483, 72.4994533962854")
            val intent = Intent(Intent.ACTION_VIEW, location)
            startActivity(intent)
        }

        binding.phoneNumber.setOnClickListener{
            val phoneNumber = Uri.parse("tel:9532544328")
            val intent = Intent(Intent.ACTION_VIEW, phoneNumber)
            startActivity(intent)
        }
    }
}