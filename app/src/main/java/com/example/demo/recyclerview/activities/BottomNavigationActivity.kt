package com.example.demo.recyclerview.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivityBottomNavigationBinding
import com.example.demo.recyclerview.adapters.BottomNavigationAdapter

class BottomNavigationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        binding.viewPager.adapter = BottomNavigationAdapter(this, 3)
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            @SuppressLint("ResourceType")
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> binding.bottomNavigation.selectedItemId = R.id.history
                    1 -> binding.bottomNavigation.selectedItemId = R.id.home
                    2 -> binding.bottomNavigation.selectedItemId = R.id.profile
                }
                super.onPageSelected(position)
            }
        })

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.history -> binding.viewPager.setCurrentItem(0,true)
                R.id.home -> binding.viewPager.setCurrentItem(1,true)
                R.id.profile -> binding.viewPager.setCurrentItem(2,true)
            }
            true
        }
    }
}
