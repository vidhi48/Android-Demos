package com.example.demo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.databinding.ItemListSongBinding
import com.example.demo.models.SongModel

class SongAdapter(private val songList: List<SongModel>):
    RecyclerView.Adapter<SongAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemListSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = songList[position]
        holder.bind(items)
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    class ViewHolder(private val binding: ItemListSongBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(songs: SongModel) {
            binding.songData = songs
        }
    }
}