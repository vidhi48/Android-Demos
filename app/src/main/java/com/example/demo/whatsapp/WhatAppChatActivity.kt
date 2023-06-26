package com.example.demo.whatsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivityWhatAppChatBinding

class WhatAppChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWhatAppChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWhatAppChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            add(R.id.fragmentChat, WhatsappChatFragment(), null)
        }
    }
}