package com.example.demo.webservices.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.example.androidproject.databinding.ActivityRegisterUserBinding
import com.example.demo.webservices.models.UserResponse
import com.example.demo.webservices.viewmodels.RegisterUserViewModel

class RegisterUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterUserBinding
    private val viewModel: RegisterUserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        viewModel.registerResponse.observe(this) {
            it?.let(this::showAlertDialog)
        }
        binding.loginBtn.setOnClickListener {
            viewModel.registerUser(
                binding.name.text.toString(),
                binding.email.text.toString(),
                binding.password.text.toString()
            )
        }
    }

    private fun showAlertDialog(registerResponse: UserResponse?) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Register Successfully")
        builder.setMessage("Welcome " + registerResponse?.username)
        builder.setNegativeButton("OK") { _, _ ->
            val intent = Intent(this, UserListActivity::class.java)
            startActivity(intent)
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
}




















