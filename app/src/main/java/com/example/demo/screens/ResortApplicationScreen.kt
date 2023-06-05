package com.example.demo.screens

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demo.model.ResortInfo
import com.example.demo.screens.ResortNewApplication
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityResortApplicationScreenBinding
import com.example.myapplication.databinding.ActivityResortNewApplicationBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

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

//        val dialog = BottomSheetDialog(this)
//        val view = layoutInflater.inflate(R.layout.activity_resort_new_application, null)
//        dialog.setContentView(view)
//        dialog.show()
    }
}