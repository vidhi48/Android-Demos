package com.example.demo.webservices.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.databinding.ItemUsersOkhttpBinding
import com.example.demo.webservices.models.UserResponse

class DisplayUserOkHttpAdapter : RecyclerView.Adapter<DisplayUserOkHttpAdapter.ViewHolder>() {
    val users: MutableList<UserResponse> = mutableListOf()

    class ViewHolder(private val binding: ItemUsersOkhttpBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: UserResponse) {
            binding.users = user
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            ItemUsersOkhttpBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addUser(list: List<UserResponse>) {
        users.clear()
        users.addAll(list)
        notifyDataSetChanged()
    }
}