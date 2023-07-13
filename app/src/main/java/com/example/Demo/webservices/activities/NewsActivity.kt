package com.example.demo.webservices.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.androidproject.databinding.ActivityNewsBinding
import com.example.demo.webservices.adapters.NewsAdapter
import com.example.demo.webservices.viewmodels.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsBinding
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        viewModel.getNews()
        val adapter = NewsAdapter()
        binding.rvNews.adapter = adapter
        viewModel.news.observe(this) {
            adapter.addNews(it.articles)
        }
    }
}