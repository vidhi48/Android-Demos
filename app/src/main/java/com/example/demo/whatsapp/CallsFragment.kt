package com.example.demo.whatsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentCallsBinding
import com.example.demo.whatsapp.adapters.CallsAdapter
import com.example.demo.whatsapp.models.Calls


class CallsFragment : Fragment() {

    private lateinit var binding: FragmentCallsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCallsBinding.inflate(layoutInflater)
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        val callsList = mutableListOf<Calls>()
        callsList.add(
            Calls(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_image),"Sandra Adams", "Today, 3:32 pm", AppCompatResources.getDrawable(requireContext(), R.drawable.baseline_local_phone_24))
        )

        callsList.add(
            Calls(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_chat2),"Arijit", "Today, 1:44 pm", AppCompatResources.getDrawable(requireContext(), R.drawable.baseline_local_phone_24))
        )

        callsList.add(
            Calls(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_chat3),"Sandra", "Today, 10:55 am", AppCompatResources.getDrawable(requireContext(), R.drawable.baseline_videocam_24))
        )
        callsList.add(
            Calls(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_chat4),"Klaus", "Yesterday, 10:24 pm", AppCompatResources.getDrawable(requireContext(), R.drawable.baseline_local_phone_24))
        )
        callsList.add(
            Calls(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_image),"Sandra Adams",  "Yesterday, 9:51 pm", AppCompatResources.getDrawable(requireContext(), R.drawable.baseline_local_phone_24))
        )
        callsList.add(
            Calls(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_chat2),"Sandra Adams",  "Yesterday, 9:51 pm", AppCompatResources.getDrawable(requireContext(), R.drawable.baseline_videocam_24))
        )

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.callsRv.layoutManager = layoutManager

        val adapter = CallsAdapter(callsList)
        binding.callsRv.adapter = adapter
    }
}