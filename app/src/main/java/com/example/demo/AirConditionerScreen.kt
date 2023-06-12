package com.example.demo

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivityAirConditionerScreenBinding
import com.example.demo.models.AppBarModel
import com.example.demo.models.ButtonModel
import com.google.android.material.tabs.TabLayout

class AirConditionerScreen : AppCompatActivity() {

    lateinit var binding: ActivityAirConditionerScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAirConditionerScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupTabBar()
        setupPowerButton()
        setupViews()
    }

    private fun setupTabBar() {
        val appBarData = AppBarModel("Air Conditioner", "LG Dual Inverter")
        binding.actionBar = appBarData

        binding.tabLayout.addTab(binding.tabLayout.newTab().setIcon(R.drawable.sun))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setIcon(R.drawable.snowflake))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setIcon(R.drawable.wind))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setIcon(R.drawable.drop))
        binding.tabLayout.tabGravity = TabLayout.GRAVITY_FILL
    }

    private fun setupPowerButton() {
        var isOn = false
        binding.power.setOnClickListener{
            isOn = !isOn
            if (isOn) {
                binding.textOn.setTextColor(Color.GRAY)
                binding.textOff.setTextColor(Color.BLACK)
            } else {
                binding.textOn.setTextColor(Color.BLACK)
                binding.textOff.setTextColor(Color.GRAY)
            }
        }
    }

    private fun setupViews() {

        binding.appBar.appToolBar.setNavigationOnClickListener {
            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
        }

        val swingButton = ButtonModel(AppCompatResources.getDrawable(this, R.drawable.refresh), "Swing")
        binding.swingBtn = swingButton

        val timerButton = ButtonModel(AppCompatResources.getDrawable(this, R.drawable.stopwatch), "Timer")
        binding.timerBtn = timerButton

        val autoButton = ButtonModel(AppCompatResources.getDrawable(this, R.drawable.light), "Auto")
        binding.autoBtn = autoButton

        val settingButton = ButtonModel(AppCompatResources.getDrawable(this, R.drawable.settings), "Settings")
        binding.settingBtn = settingButton
    }
}