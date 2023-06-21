package com.example.demo


import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidproject.databinding.ActivityPendingIntentDemoBinding

class PendingIntentDemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPendingIntentDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPendingIntentDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sendAlert.setOnClickListener {
           sendAlert()
        }
    }

    private fun sendAlert() {
        val intent = Intent(this, IntentFilterDemoActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (1 * 10000), pendingIntent)
    }
}