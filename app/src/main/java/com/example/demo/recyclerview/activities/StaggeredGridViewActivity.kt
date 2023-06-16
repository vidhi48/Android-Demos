package com.example.demo.recyclerview.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivityStaggeredGridViewBinding
import com.example.demo.recyclerview.adapters.SeriesAdapter
import com.example.demo.recyclerview.models.SeriesModel

class StaggeredGridViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStaggeredGridViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStaggeredGridViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val seriesList = mutableListOf<SeriesModel>()
        seriesList.add(SeriesModel(AppCompatResources.getDrawable(this, R.drawable.legacies), R.string.legaciesDesc))
        seriesList.add(SeriesModel(AppCompatResources.getDrawable(this, R.drawable.stranger_things), R.string.stranger))
        seriesList.add(SeriesModel(AppCompatResources.getDrawable(this, R.drawable.money_heist), R.string.moneyDesc))
        seriesList.add(SeriesModel(AppCompatResources.getDrawable(this, R.drawable.human), R.string.humanDesc))
        seriesList.add(SeriesModel(AppCompatResources.getDrawable(this, R.drawable.blind), R.string.blind))

        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.stagRecycler.layoutManager = layoutManager

        val recyclerViewAdapter = SeriesAdapter(seriesList)
        binding.stagRecycler.adapter = recyclerViewAdapter
    }
}