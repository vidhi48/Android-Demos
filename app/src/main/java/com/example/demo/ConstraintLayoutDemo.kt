package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityConstraintLayoutDemoBinding

open class ConstraintLayoutDemo : AppCompatActivity() {

    private lateinit var binding: ActivityConstraintLayoutDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConstraintLayoutDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signIn.setOnClickListener{
            Toast.makeText(this, "Login successfully", Toast.LENGTH_SHORT).show()
        }
    }
}