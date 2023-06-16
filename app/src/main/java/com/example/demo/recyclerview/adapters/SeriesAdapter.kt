package com.example.demo.recyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.databinding.ItemListGridBinding
import com.example.demo.recyclerview.models.SeriesModel

class SeriesAdapter(private val seriesList: List<SeriesModel>) :
    RecyclerView.Adapter<SeriesAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemListGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(series: SeriesModel) {
            binding.seriesData = series
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemListGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = seriesList[position]
        holder.bind(items)
    }

    override fun getItemCount(): Int {
        return seriesList.size
    }
}