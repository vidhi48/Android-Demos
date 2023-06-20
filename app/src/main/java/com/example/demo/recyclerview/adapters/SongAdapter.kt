package com.example.demo.recyclerview.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.databinding.ItemListSongBinding
import com.example.androidproject.databinding.ItemLoadingBinding
import com.example.demo.recyclerview.models.Song

class SongAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    enum class ViewType {
        SONG,
        LOADING
    }

    private val songs: MutableList<Song> = mutableListOf()
    private var isLoading = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (ViewType.values()[viewType]) {
            ViewType.SONG -> ViewHolder(
                ItemListSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )

            ViewType.LOADING -> LoadingViewHolder(
                ItemLoadingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }

    fun showLoading() {
        isLoading = true
        notifyItemInserted(songs.count())
    }

    fun hideLoading() {
        isLoading = false
        notifyItemRemoved(songs.count())
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: List<Song>) {
        songs.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> holder.bind(songs[position])
            is LoadingViewHolder -> holder.bind(isLoading)
        }
    }

    override fun getItemCount(): Int = if (isLoading) {
        songs.count() + 1
    } else {
        songs.count()
    }

    override fun getItemViewType(position: Int): Int {
        return if (isLoading && position == songs.count()) ViewType.LOADING.ordinal else ViewType.SONG.ordinal
    }

    class ViewHolder(private val binding: ItemListSongBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(songs: Song) {
            binding.songData = songs
        }
    }

    class LoadingViewHolder(private val binding: ItemLoadingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(isLoading: Boolean) {
            binding.isLoading = isLoading
        }
    }

    fun submitSong(list: List<Song>) {
        songs.clear()
        songs.addAll(list)
        notifyDataSetChanged()
    }
}