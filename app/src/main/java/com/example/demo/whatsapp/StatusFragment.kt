package com.example.demo.whatsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentStatusBinding
import com.example.demo.whatsapp.adapters.StatusAdapter
import com.example.demo.whatsapp.models.Status

class StatusFragment : Fragment() {

    private lateinit var binding: FragmentStatusBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatusBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val statusList = mutableListOf<Status>()
        statusList.add(
            Status(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_image),"Sandra Adams", "Today, 3:32 pm")
        )

        statusList.add(
            Status(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_chat2),"Arijit", "Today, 1:44 pm")
        )

        statusList.add(
            Status(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_chat3),"Sandra", "Today, 10:55 am")
        )
        statusList.add(
            Status(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_chat4),"Klaus", "Yesterday, 10:24 pm")
        )
        statusList.add(
            Status(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_image),"Sandra Adams",  "Yesterday, 9:51 pm")
        )

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.statusRv.layoutManager = layoutManager

        val adapter = StatusAdapter(statusList)
        binding.statusRv.adapter = adapter
    }
}