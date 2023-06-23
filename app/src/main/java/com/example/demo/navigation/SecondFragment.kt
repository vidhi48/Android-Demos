package com.example.demo.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.androidproject.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private val data: SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        setupViews()
        return binding.root
    }

    private fun setupViews() {
        val userDetails = data.user
        binding.apply {
            name.text = userDetails.name
            email.text = userDetails.email
            password.text = userDetails.password
        }

        binding.back.setOnClickListener {
            val action = SecondFragmentDirections.actionNavFragment2ToNavFragment1()
            findNavController().navigate(action)
        }
    }
}