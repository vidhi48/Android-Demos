package com.example.demo.webservices.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidproject.R
import com.example.androidproject.databinding.ItemsNewsBinding
import com.example.demo.webservices.models.Articles

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    val news: MutableList<Articles> = mutableListOf()

    class ViewHolder(private val binding: ItemsNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: Articles) {
            binding.news = news
            news.urlToImage?.let {
                Glide.with(binding.root.context)
                    .load(news.urlToImage)
                    .into(binding.imgNews)
            } ?: {
                binding.imgNews.setImageResource(R.drawable.news)
            }
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemsNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return news.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(news[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addNews(list: List<Articles>) {
        news.clear()
        news.addAll(list)
        notifyDataSetChanged()
    }
}