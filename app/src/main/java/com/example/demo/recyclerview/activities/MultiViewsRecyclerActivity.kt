package com.example.demo.recyclerview.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivityMultiViewsRecyclerBinding
import com.example.demo.recyclerview.adapters.MoviesAdapter
import com.example.demo.recyclerview.itemdecoration.RecyclerViewItemDecoration
import com.example.demo.recyclerview.models.DataModel

class MultiViewsRecyclerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMultiViewsRecyclerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMultiViewsRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
    }

   private fun setupRecyclerView() {
       val items = mutableListOf<DataModel>()

       items.add(DataModel.MovieModel(R.string.pathaan, R.string.pathaanDate))
       items.add(DataModel.MovieAllDataModel(R.string.custody, AppCompatResources.getDrawable(this, R.drawable.custody), R.string.custodyDate, R.string.custodyDesc, R.string.pathaanRatings))
       items.add(DataModel.MovieModel(R.string.custody , R.string.custodyDate))
       items.add(DataModel.MovieAllDataModel(R.string.pathaan, AppCompatResources.getDrawable(this, R.drawable.pathaan), R.string.pathaanDate, R.string.pathaanDesc, R.string.custodyRatings))
       items.add(DataModel.MovieModel(R.string.pathaan, R.string.pathaanDate))
       items.add(DataModel.MovieAllDataModel(R.string.custody, AppCompatResources.getDrawable(this, R.drawable.custody), R.string.custodyDate, R.string.custodyDesc, R.string.pathaanRatings))
       items.add(DataModel.MovieModel(R.string.custody , R.string.custodyDate))
       items.add(DataModel.MovieAllDataModel(R.string.pathaan, AppCompatResources.getDrawable(this, R.drawable.pathaan), R.string.pathaanDate, R.string.pathaanDesc, R.string.custodyRatings))
       items.add(DataModel.MovieModel(R.string.pathaan, R.string.pathaanDate))
       items.add(DataModel.MovieAllDataModel(R.string.custody, AppCompatResources.getDrawable(this, R.drawable.custody), R.string.custodyDate, R.string.custodyDesc, R.string.pathaanRatings))
       items.add(DataModel.MovieModel(R.string.custody , R.string.custodyDate))
       items.add(DataModel.MovieAllDataModel(R.string.pathaan, AppCompatResources.getDrawable(this, R.drawable.pathaan), R.string.pathaanDate, R.string.pathaanDesc, R.string.custodyRatings))


       val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
       binding.viewsRecycler.layoutManager = layoutManager

       val movieAdapter = MoviesAdapter(items)
       binding.viewsRecycler.adapter = movieAdapter
   }
}