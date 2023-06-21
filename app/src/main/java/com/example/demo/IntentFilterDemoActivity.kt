package com.example.demo

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.androidproject.databinding.ActivityIntentFilterDemoBinding

class IntentFilterDemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntentFilterDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIntentFilterDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {
        binding.openGmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, "simform@gmail.com")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Dummy mail")
            intent.putExtra(Intent.EXTRA_TEXT, "Dummy message")
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
}