package com.example.demo.whatsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
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
        setSupportActionBar(binding.toolbar)
        setupTabBar()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.whatsapp_action_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.camera -> {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupTabBar() = with(binding) {
        val tabList = listOf<Any>("Community", "Chats", "Status", "Calls")
        tabLayout.apply {
            addTab(this.newTab())
            addTab(this.newTab())
            addTab(this.newTab())
            addTab(this.newTab())
        }

        val adapter = TabAdapter(this@WhatsAppActivity, tabLayout.tabCount)
        viewPager.adapter = adapter
        viewPager.currentItem = 1

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            if (position == 0) {
                tab.icon =
                    AppCompatResources.getDrawable(this@WhatsAppActivity, R.drawable.community)
            } else {
                tab.text = tabList[position].toString()
            }
        }.attach()
    }
}