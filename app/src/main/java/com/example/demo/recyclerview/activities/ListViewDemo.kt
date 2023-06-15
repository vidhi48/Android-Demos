package com.example.demo.recyclerview.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivityListViewDemoBinding
import com.example.demo.recyclerview.adapters.LanguageAdapter

class ListViewDemo : AppCompatActivity() {

    lateinit var binding: ActivityListViewDemoBinding

    private val songProfile =
        listOf(
            R.drawable.java_image,
            R.drawable.kotlin_image,
            R.drawable.python_image,
            R.drawable.java_image,
            R.drawable.kotlin_image,
            R.drawable.python_image,
            R.drawable.java_image,
            R.drawable.kotlin_image,
            R.drawable.python_image,
            R.drawable.java_image,
            R.drawable.kotlin_image,
            R.drawable.python_image
        )
    private val language = listOf("Java", "Kotlin", "Python", "Java", "Kotlin", "Python", "Java", "Kotlin", "Python", "Java", "Kotlin", "Python")
    private val ratings = listOf(4, 4, 5, 4, 4, 5, 4, 4, 5, 4, 4, 5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListViewDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listAdapter = LanguageAdapter(this, songProfile, language, ratings)
        binding.languageList.adapter = listAdapter

    }
}
