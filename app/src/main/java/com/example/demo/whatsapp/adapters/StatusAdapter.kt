package com.example.demo.whatsapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.databinding.ItemStatusListBinding
import com.example.demo.whatsapp.models.Status

class StatusAdapter(private var statusList: List<Status>) :
    RecyclerView.Adapter<StatusAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemStatusListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(status: Status) {
            binding.status = status
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemStatusListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = statusList[position]
        holder.bind(items)
    }

    override fun getItemCount(): Int {
        return statusList.size
    }
}