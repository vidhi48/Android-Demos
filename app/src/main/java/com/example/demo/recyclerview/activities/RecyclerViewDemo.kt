package com.example.demo.recyclerview.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivityRecyclerViewDemoBinding
import com.example.demo.recyclerview.adapters.SongAdapter
import com.example.demo.recyclerview.itemdecoration.RecyclerViewItemDecoration
import com.example.demo.recyclerview.models.Song
import com.example.demo.recyclerview.pagination.PaginationRecyclerView

class RecyclerViewDemo : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewDemoBinding
    private val songAdapter = SongAdapter()
    var pageSize = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecyclerViewDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val songList = mutableListOf<Song>()
        songList.add(
            Song(
                AppCompatResources.getDrawable(this, R.drawable.shape_song),
                R.string.shape,
                R.string.shapeSinger,
                R.string.shapeTime
            )
        )
        songList.add(
            Song(
                AppCompatResources.getDrawable(this, R.drawable.perfect),
                R.string.perfect,
                R.string.perfectSinger,
                R.string.perfectTime
            )
        )
        songList.add(
            Song(
                AppCompatResources.getDrawable(this, R.drawable.kesariya),
                R.string.kesariya,
                R.string.kesariyaSinger,
                R.string.kesariyaTime
            )
        )
        songList.add(
            Song(
                AppCompatResources.getDrawable(this, R.drawable.hawayein),
                R.string.hawayein,
                R.string.hawayeinSinger,
                R.string.hawayeinTime
            )
        )
        songList.add(
            Song(
                AppCompatResources.getDrawable(this, R.drawable.shape_song),
                R.string.shape,
                R.string.shapeSinger,
                R.string.shapeTime
            )
        )
        songList.add(
            Song(
                AppCompatResources.getDrawable(this, R.drawable.perfect),
                R.string.perfect,
                R.string.perfectSinger,
                R.string.perfectTime
            )
        )
        songList.add(
            Song(
                AppCompatResources.getDrawable(this, R.drawable.kesariya),
                R.string.kesariya,
                R.string.kesariyaSinger,
                R.string.kesariyaTime
            )
        )
        songList.add(
            Song(
                AppCompatResources.getDrawable(this, R.drawable.hawayein),
                R.string.hawayein,
                R.string.hawayeinSinger,
                R.string.hawayeinTime
            )
        )
        songList.add(
            Song(
                AppCompatResources.getDrawable(this, R.drawable.shape_song),
                R.string.shape,
                R.string.shapeSinger,
                R.string.shapeTime
            )
        )
        songList.add(
            Song(
                AppCompatResources.getDrawable(this, R.drawable.perfect),
                R.string.perfect,
                R.string.perfectSinger,
                R.string.perfectTime
            )
        )
        songList.add(
            Song(
                AppCompatResources.getDrawable(this, R.drawable.kesariya),
                R.string.kesariya,
                R.string.kesariyaSinger,
                R.string.kesariyaTime
            )
        )
        songList.add(
            Song(
                AppCompatResources.getDrawable(this, R.drawable.hawayein),
                R.string.hawayein,
                R.string.hawayeinSinger,
                R.string.hawayeinTime
            )
        )

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.songRecycler.layoutManager = layoutManager

        binding.songRecycler.addItemDecoration(
            RecyclerViewItemDecoration(
                this,
                R.drawable.item_divider_recyclerview
            )
        )

        binding.songRecycler.adapter = songAdapter

        binding.songRecycler.addOnScrollListener(object : PaginationRecyclerView(layoutManager) {
            var loading = false

            override fun loadMoreItems() {
                loading = true
                songAdapter.showLoading()

                Handler(Looper.getMainLooper()).postDelayed({
                    songAdapter.addList(songList)
                    loading = false
                    songAdapter.hideLoading()
                    pageSize++
                }, 2000)
            }

            override fun isLastPage(): Boolean {
                return PAGE_SIZE == pageSize

            }

            override fun isLoading(): Boolean {
                return loading
            }

        })
        songAdapter.submitSong(songList)
    }
}