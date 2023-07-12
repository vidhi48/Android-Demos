package com.example.demo.webservices.activities

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.example.androidproject.databinding.ActivityImageUploadBinding
import com.example.demo.webservices.viewmodels.ImageUploadViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
import java.io.FileOutputStream

@AndroidEntryPoint
class ImageUploadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageUploadBinding
    private val viewModel: ImageUploadViewModel by viewModels()
    private lateinit var imgUri: Uri
    private val contract = registerForActivityResult(ActivityResultContracts.GetContent()) {
        if (it != null) {
            imgUri = it
            binding.image.setImageURI(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    @SuppressLint("Recycle")
    private fun setupUI() {
        viewModel.imageResponse.observe(this) {
            Toast.makeText(this, "Image Uploaded Successfully", Toast.LENGTH_SHORT).show()
        }

        binding.selectBtn.setOnClickListener {
            contract.launch("image/*")
        }

        binding.uploadBtn.setOnClickListener {
            val filesDir = applicationContext.filesDir
            val file = File(filesDir, "image.png")
            val inputStream = contentResolver.openInputStream(imgUri)
            val outputStream = FileOutputStream(file)
            inputStream?.copyTo(outputStream)
            viewModel.uploadImage(file)
        }
    }
}