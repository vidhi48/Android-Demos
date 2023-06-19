package com.example.demo.recyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.databinding.ItemMovieAllDataBinding
import com.example.androidproject.databinding.ItemMovieDataBinding
import com.example.demo.recyclerview.models.DataModel

class MoviesAdapter(private val movieList: List<DataModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class MovieViewHolder(private val binding: ItemMovieDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: DataModel.MovieModel) {
            binding.movieData = movie
        }
    }

    class MovieAllViewHolder(private val binding: ItemMovieAllDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: DataModel.MovieAllDataModel) {
            binding.movieAllData = movie
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (MovieType.values()[viewType]) {
            MovieType.MOVIES -> {
                val movieBinding =
                    ItemMovieDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                MovieViewHolder(movieBinding)

            }

            MovieType.ALL_MOVIES -> {
                val movieAllBinding = ItemMovieAllDataBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                MovieAllViewHolder(movieAllBinding)
            }
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MovieViewHolder -> holder.bind(movieList[position] as DataModel.MovieModel)
            is MovieAllViewHolder ->  holder.bind(movieList[position] as DataModel.MovieAllDataModel)
        }
    }

    override fun getItemViewType(position: Int): Int =
        when (movieList[position]) {
            is DataModel.MovieModel -> MovieType.MOVIES.ordinal
            is DataModel.MovieAllDataModel -> MovieType.ALL_MOVIES.ordinal
        }

    enum class MovieType {
        MOVIES, ALL_MOVIES
    }
}