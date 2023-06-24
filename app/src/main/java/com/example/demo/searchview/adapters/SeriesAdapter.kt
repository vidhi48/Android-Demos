package com.example.demo.searchview.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.databinding.ItemSeriesListBinding
import com.example.demo.searchview.models.Series

class SeriesAdapter(private var seriesList: List<Series>):
    RecyclerView.Adapter<SeriesAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemSeriesListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(series: Series) {
            binding.series = series
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemSeriesListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = seriesList[position]
        holder.bind(items)
    }

    override fun getItemCount(): Int {
       return seriesList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun filterList(filterList: List<Series>) {
        seriesList = filterList
        notifyDataSetChanged()
    }
}