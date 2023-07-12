package com.example.demo.webservices.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.androidproject.databinding.ActivityRegisterUserOkHttpBinding
import com.example.demo.webservices.viewmodels.RegisterUserOkHttpViewModel

class RegisterUserOkHttpActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterUserOkHttpBinding
    private val viewModel: RegisterUserOkHttpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterUserOkHttpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }
    private fun setupUI() {
        viewModel.validationError.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        binding.loginBtn.setOnClickListener {
            addUser()
        }

        viewModel.response.observe(this) {
            Toast.makeText(this, "User Added Successfully", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, DisplayUserOkHttpActivity::class.java)
            intent.putExtra("id", viewModel.data.toString())
            startActivity(intent)
        }
    }

    private fun addUser() {
        viewModel.validate(binding.name.text.toString(),binding.email.text.toString(), binding.password.text.toString())
    }
}