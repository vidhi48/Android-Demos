package com.example.demo.searchview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivitySearchViewBinding
import com.example.demo.searchview.adapters.SeriesAdapter
import com.example.demo.searchview.models.Series

class SearchViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchViewBinding
    private var seriesList = mutableListOf<Series>()
    private lateinit var adapter: SeriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        seriesList.add(
            Series(
                AppCompatResources.getDrawable(this, R.drawable.wednesday),
                "Wednesday", R.string.wedEpisodes, R.string.wedDate, R.string.wedPlatform
            )
        )
        seriesList.add(
            Series(
                AppCompatResources.getDrawable(this, R.drawable.dead),
                "All of Us Are Dead", R.string.deadEpi, R.string.deadDate, R.string.deadPlat
            )
        )
        seriesList.add(
            Series(
                AppCompatResources.getDrawable(this, R.drawable.family),
                "The Family Man", R.string.familyEpi, R.string.familyDate, R.string.familyPlat
            )
        )
        seriesList.add(
            Series(
                AppCompatResources.getDrawable(this, R.drawable.lucifer),
                "Lucifer", R.string.luciferEpi, R.string.luciferDate, R.string.luciferPlat
            )
        )
        seriesList.add(
            Series(
                AppCompatResources.getDrawable(this, R.drawable.sherlock),
                "Sherlock",
                R.string.sherlockEpi,
                R.string.sherlockDate,
                R.string.sherlockPlat
            )
        )
        seriesList.add(
            Series(
                AppCompatResources.getDrawable(this, R.drawable.friends),
                "Friends", R.string.friendsEpi, R.string.friendsDate, R.string.friendsPlat
            )
        )

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.layoutManager = layoutManager

        adapter = SeriesAdapter(seriesList)
        binding.recyclerView.adapter = adapter

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
               return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    filterData(newText)
                }
                return false
            }
        })
    }

    private fun filterData(query: String) {
        val filteredList: ArrayList<Series> = ArrayList()

        seriesList.forEach { item ->
            if (item.seriesName.contains(query, ignoreCase = true)) {
                filteredList.add(item)
            }
        }

        adapter.filterList(filteredList)
    }
}