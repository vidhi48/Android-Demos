package com.example.demo

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.demo.model.ResortInfo
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityResortApplicationScreenBinding

class ResortApplicationScreen : AppCompatActivity() {

    lateinit var binding: ActivityResortApplicationScreenBinding
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResortApplicationScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingButton.setOnClickListener{
            showBottomSheet()
        }

        val info1 = ResortInfo(applicationContext.getDrawable(R.drawable.resort)!!, "Villa Gaanok Komang", "$78", "4.9")
        val info2 = ResortInfo(applicationContext.getDrawable(R.drawable.resort_image)!!, "Banny's Apartments", "$50", "5.0")
        val info3 = ResortInfo(applicationContext.getDrawable(R.drawable.resort_image2)!!, "Villa Parttes Ubad", "$112", "4.8")
        val info4 = ResortInfo(applicationContext.getDrawable(R.drawable.resort)!!, "Villa Gaanok Komang", "$78", "4.9")
        binding.villa1 = info1
        binding.villa2 = info2
        binding.villa3 = info3
        binding.villa4 = info4
    }

    private fun showBottomSheet() {
        val dialog = ResortNewApplication(this)
        dialog.behavior.peekHeight = 1950
        dialog.show()
    }
}