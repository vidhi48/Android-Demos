package com.example.demo.webservices.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.androidproject.databinding.ActivityUserListBinding
import com.example.demo.webservices.adapters.UserListAdapter
import com.example.demo.webservices.viewmodels.UserListViewModel

class UserListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserListBinding
    private lateinit var viewModel: UserListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        viewModel = ViewModelProvider(this)[UserListViewModel::class.java]
        viewModel.getUser()
        val userAdapter = UserListAdapter()
        viewModel.userLiveData.observe(this) {
            viewModel.userLiveData.value?.let { userAdapter.addItem(it) }
            binding.recyclerView.adapter = userAdapter
        }
    }
}