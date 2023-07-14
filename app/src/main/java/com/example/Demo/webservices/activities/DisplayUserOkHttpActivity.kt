package com.example.demo.webservices.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.androidproject.databinding.ActivityDisplayUserOkHttpBinding
import com.example.demo.webservices.adapters.DisplayUserOkHttpAdapter
import com.example.demo.webservices.viewmodels.DisplayUserOkHttpViewModel

class DisplayUserOkHttpActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDisplayUserOkHttpBinding
    private val viewModel: DisplayUserOkHttpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayUserOkHttpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        val adapter = DisplayUserOkHttpAdapter()
        viewModel.getUser(this)
        viewModel.users.observe(this) {
            adapter.addUser(it)
            binding.userRv.adapter = adapter
        }
    }
}