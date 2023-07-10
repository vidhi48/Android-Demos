package com.example.demo.webservices.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidproject.databinding.ItemUserListBinding
import com.example.demo.webservices.models.Data

class UserListAdapter: RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    private val users: MutableList<Data> = mutableListOf()

    class ViewHolder(private val binding: ItemUserListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(user: Data) {
            binding.user = user
            Glide.with(binding.root.context)
                .load(user.avatar)
                .circleCrop()
                .into(binding.images)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemUserListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(users[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItem(list: List<Data>) {
        users.clear()
        users.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return users.size
    }
}