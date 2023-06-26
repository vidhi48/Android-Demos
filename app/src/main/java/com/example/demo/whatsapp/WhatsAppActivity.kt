package com.example.demo.whatsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivityWhatsAppBinding
import com.example.demo.whatsapp.adapters.TabAdapter
import com.google.android.material.tabs.TabLayoutMediator

class WhatsAppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWhatsAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWhatsAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupTabBar()
    }

    private fun setupTabBar() {

        val tabList = listOf<Any>("Community","Chats","Status", "Calls")

        binding.tabLayout.apply {
            addTab(this.newTab())
            addTab(this.newTab())
            addTab(this.newTab())
            addTab(this.newTab())
        }

        val adapter = TabAdapter(this, binding.tabLayout.tabCount)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab, position ->
            if (position == 0) {
                tab.icon = AppCompatResources.getDrawable(this, R.drawable.community)
            } else {
                tab.text = tabList[position].toString()
            }
        }.attach()
    }
}