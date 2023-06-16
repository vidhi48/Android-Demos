package com.example.demo.recyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.R
import com.example.androidproject.databinding.ItemListSongBinding
import com.example.demo.recyclerview.models.SongModel

class SongAdapter(private val songList: List<SongModel>, private val context: Context) :
    RecyclerView.Adapter<SongAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemListSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = songList[position]
        holder.itemView.animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.anim)
        holder.bind(items)
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    inner class ViewHolder(private val binding: ItemListSongBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(songs: SongModel) {
            binding.songData = songs
            binding.root.setOnClickListener {
                Toast.makeText(
                    context,
                    "Song ${binding.songTitle.text} clicked.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}