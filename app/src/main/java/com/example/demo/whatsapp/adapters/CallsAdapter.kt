package com.example.demo.whatsapp.adapters

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.databinding.ItemCallsListBinding
import com.example.demo.whatsapp.models.Calls

class CallsAdapter(private var callList: List<Calls>):
    RecyclerView.Adapter<CallsAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemCallsListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(calls: Calls) {
            binding.callData = calls
            binding.phone.setOnClickListener {
                val phoneNumber = Uri.parse("tel:9532544328")
                val intent = Intent(Intent.ACTION_VIEW, phoneNumber)
                binding.root.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemCallsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = callList[position]
        holder.bind(items)
    }

    override fun getItemCount(): Int {
        return callList.size
    }
}
