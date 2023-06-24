package com.example.demo.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.androidproject.databinding.FragmentFirstNavigationBinding
import com.example.demo.models.UserViewModel

class FirstNavigationFragment : Fragment() {

    private lateinit var binding: FragmentFirstNavigationBinding
    private val viewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstNavigationBinding.inflate(layoutInflater)
        setupViews()
        return binding.root
    }

    private fun setupViews() {
        binding.passData.setOnClickListener {
            viewModel.name.value = binding.name.text.toString()
            viewModel.email.value = binding.email.text.toString()
            viewModel.password.value = binding.password.text.toString()
        }
    }
}