package com.example.demo.recyclerview.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivityGridRecyclerViewBinding
import com.example.demo.recyclerview.adapters.SeriesAdapter
import com.example.demo.recyclerview.models.SeriesModel

class GridRecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGridRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGridRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val seriesList = mutableListOf<SeriesModel>()
        seriesList.add(SeriesModel(AppCompatResources.getDrawable(this, R.drawable.legacies), R.string.legacies))
        seriesList.add(SeriesModel(AppCompatResources.getDrawable(this, R.drawable.stranger_things), R.string.stranger))
        seriesList.add(SeriesModel(AppCompatResources.getDrawable(this, R.drawable.money_heist), R.string.money))
        seriesList.add(SeriesModel(AppCompatResources.getDrawable(this, R.drawable.human), R.string.human))
        seriesList.add(SeriesModel(AppCompatResources.getDrawable(this, R.drawable.blind), R.string.blind))

        val layoutManager = GridLayoutManager(this, 2)
        binding.gridRecycler.layoutManager = layoutManager

        val recyclerViewAdapter = SeriesAdapter(seriesList)
        binding.gridRecycler.adapter = recyclerViewAdapter
    }
}