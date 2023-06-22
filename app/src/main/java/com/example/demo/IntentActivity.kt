package com.example.demo

import android.app.Activity
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.NotificationCompat
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivityIntentBinding

class IntentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {

        binding.sendNotification.setOnClickListener {
            sendNotification()
        }

        binding.sendMessage.setOnClickListener {
            val number = "9856741238"
            val intent = Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null))
            intent.putExtra(Intent.EXTRA_TEXT, "Hello!")
            startActivity(intent)
        }

        binding.openGmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, "simform@gmail.com")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Dummy mail")
            intent.putExtra(Intent.EXTRA_TEXT, "This is a dummy message")
            startActivity(intent)
        }

        binding.openCamera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        val image = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                val data = it.data
                val imgUri = data?.data
                binding.image.setImageURI(imgUri)
            }
        }

        binding.selectImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            image.launch(intent)
        }
    }

    private fun sendNotification() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://open.spotify.com/"))
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        val notificationBuilder = NotificationCompat.Builder(this, "channelId")
            .setSmallIcon(R.drawable.baseline_notifications_24)
            .setContentTitle("Spotify")
            .setContentText("Tap to visit spotify")
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(1, notificationBuilder.build())
    }
}