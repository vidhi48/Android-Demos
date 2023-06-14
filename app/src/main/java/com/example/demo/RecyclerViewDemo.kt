package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivityRecyclerViewDemoBinding
import com.example.demo.adapters.SongAdapter
import com.example.demo.models.SongModel

class RecyclerViewDemo : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecyclerViewDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.songRecycler.layoutManager = LinearLayoutManager(this)
        setupData()
    }

    private fun setupData() {
        val songList = mutableListOf<SongModel>()
        songList.add(SongModel(AppCompatResources.getDrawable(this, R.drawable.shape_song), R.string.shape, R.string.shapeSinger, R.string.shapeTime))
        songList.add(SongModel(AppCompatResources.getDrawable(this, R.drawable.perfect), R.string.perfect, R.string.perfectSinger, R.string.perfectTime))
        songList.add(SongModel(AppCompatResources.getDrawable(this, R.drawable.kesariya), R.string.kesariya, R.string.kesariyaSinger, R.string.kesariyaTime))
        songList.add(SongModel(AppCompatResources.getDrawable(this, R.drawable.hawayein), R.string.hawayein, R.string.hawayeinSinger, R.string.hawayeinTime))
        songList.add(SongModel(AppCompatResources.getDrawable(this, R.drawable.shape_song), R.string.shape, R.string.shapeSinger, R.string.shapeTime))
        songList.add(SongModel(AppCompatResources.getDrawable(this, R.drawable.perfect), R.string.perfect, R.string.perfectSinger, R.string.perfectTime))
        songList.add(SongModel(AppCompatResources.getDrawable(this, R.drawable.kesariya), R.string.kesariya, R.string.kesariyaSinger, R.string.kesariyaTime))
        songList.add(SongModel(AppCompatResources.getDrawable(this, R.drawable.hawayein), R.string.hawayein, R.string.hawayeinSinger, R.string.hawayeinTime))
        songList.add(SongModel(AppCompatResources.getDrawable(this, R.drawable.shape_song), R.string.shape, R.string.shapeSinger, R.string.shapeTime))
        songList.add(SongModel(AppCompatResources.getDrawable(this, R.drawable.perfect), R.string.perfect, R.string.perfectSinger, R.string.perfectTime))
        songList.add(SongModel(AppCompatResources.getDrawable(this, R.drawable.kesariya), R.string.kesariya, R.string.kesariyaSinger, R.string.kesariyaTime))
        songList.add(SongModel(AppCompatResources.getDrawable(this, R.drawable.hawayein), R.string.hawayein, R.string.hawayeinSinger, R.string.hawayeinTime))

        val recyclerViewAdapter = SongAdapter(songList)
        binding.songRecycler.adapter = recyclerViewAdapter
    }
}