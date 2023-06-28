package com.example.demo.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidproject.databinding.FragmentFirstBinding
import com.example.demo.models.User

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding.passData.setOnClickListener {
            val user = User(
                binding.name.text.toString(),
                binding.email.text.toString(),
                binding.password.text.toString()
            )
            val action = FirstFragmentDirections.actionNavFragment1ToNavFragment2(user)
            findNavController().navigate(action)
        }
    }

}