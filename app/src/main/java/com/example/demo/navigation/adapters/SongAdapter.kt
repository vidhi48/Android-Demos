package com.example.demo.navigation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.databinding.ItemSongListBinding
import com.example.demo.models.Song

class SongAdapter(private var songList: List<Song>) :
    RecyclerView.Adapter<SongAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemSongListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(song: Song) {
            binding.song = song
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemSongListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = songList[position]
        holder.bind(items)
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun filterList(filterList: List<Song>) {
        songList = filterList
        notifyDataSetChanged()
    }
}