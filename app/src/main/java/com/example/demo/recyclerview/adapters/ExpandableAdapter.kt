package com.example.demo.recyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.databinding.ItemListExpandableBinding
import com.example.demo.recyclerview.models.ExpandableModel
import kotlin.math.exp

class ExpandableAdapter(private val languageList: List<ExpandableModel>) :
    RecyclerView.Adapter<ExpandableAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExpandableAdapter.ViewHolder {
        val view =
            ItemListExpandableBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpandableAdapter.ViewHolder, position: Int) {
        val items = languageList[position]
        holder.bind(items)
    }

    override fun getItemCount(): Int {
        return languageList.size
    }

    inner class ViewHolder(private val binding: ItemListExpandableBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(expand: ExpandableModel) {
            binding.expandableData = expand
            binding.expandView.visibility = if (expand.isExpand) View.VISIBLE else View.GONE
            binding.titleCard.setOnClickListener {
                expand.isExpand = !expand.isExpand
                notifyDataSetChanged()
            }
        }
    }
}