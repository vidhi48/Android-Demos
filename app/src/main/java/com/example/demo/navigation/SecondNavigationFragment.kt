package com.example.demo.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.androidproject.databinding.FragmentSecondNavigationBinding
import com.example.demo.models.UserViewModel

class SecondNavigationFragment : Fragment() {

    private lateinit var binding: FragmentSecondNavigationBinding
    private val viewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondNavigationBinding.inflate(layoutInflater)
        setupViews()
        return binding.root
    }

    private fun setupViews() {
        viewModel.name.observe(viewLifecycleOwner) {
            binding.name.text = it
        }
        viewModel.email.observe(viewLifecycleOwner) {
            binding.email.text = it
        }
        viewModel.password.observe(viewLifecycleOwner) {
            binding.password.text = it
        }
    }
}