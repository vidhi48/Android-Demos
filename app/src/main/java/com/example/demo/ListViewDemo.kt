package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivityListViewDemoBinding
import com.example.androidproject.databinding.ActivityMusicScreenBinding
import com.example.demo.models.SongListModel

class ListViewDemo : AppCompatActivity() {

    private lateinit var binding: ActivityListViewDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_demo)

        val songs = mutableListOf<SongListModel>(
            SongListModel(R.drawable.perfect, R.string.perfect, R.string.perfectSinger, R.string.perfectTime),
                                                                    SongListModel(R.drawable.shape_song,R.string.shape, R.string.shapeSinger, R.string.shapeTime )
        )

        val songAdapter = ArrayAdapter<SongListModel>(this, R.layout.song_list_items, songs)
        binding.songList.adapter = songAdapter
    }
}
