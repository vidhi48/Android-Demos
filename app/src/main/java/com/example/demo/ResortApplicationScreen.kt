package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityConstraintLayoutDemoBinding
import com.example.myapplication.databinding.ActivityResortApplicationScreenBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

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
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(R.layout.activity_resort_new_application)
        dialog.show()
    }
}