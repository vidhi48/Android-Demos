package com.example.demo.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentThirdNavigationBinding
import com.example.demo.adapters.SongAdapter
import com.example.demo.models.SharedViewModel
import com.example.demo.models.Song

class ThirdNavigationFragment : Fragment() {

    private lateinit var binding: FragmentThirdNavigationBinding
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdNavigationBinding.inflate(layoutInflater)
        binding.passData.setOnClickListener {
            viewModel.sendData(binding.data.text.toString())
        }
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        var songList = mutableListOf<Song>()
        songList.add(
            Song(
                AppCompatResources.getDrawable(requireContext(), R.drawable.shape_song),
                "Shape Of You",
                R.string.shapeSinger,
                R.string.shapeTime
            )
        )
        songList.add(
            Song(
                AppCompatResources.getDrawable(requireContext(), R.drawable.perfect),
                "Perfect",
                R.string.perfectSinger,
                R.string.perfectTime
            )
        )
        songList.add(
            Song(
                AppCompatResources.getDrawable(requireContext(), R.drawable.kesariya),
                "Kesariya",
                R.string.kesariyaSinger,
                R.string.kesariyaTime
            )
        )
        songList.add(
            Song(
                AppCompatResources.getDrawable(requireContext(), R.drawable.hawayein),
                "Hawayein",
                R.string.hawayeinSinger,
                R.string.hawayeinTime
            )
        )
        songList.add(
            Song(
                AppCompatResources.getDrawable(requireContext(), R.drawable.shape_song),
                "Shape Of You",
                R.string.shapeSinger,
                R.string.shapeTime
            )
        )
        songList.add(
            Song(
                AppCompatResources.getDrawable(requireContext(), R.drawable.perfect),
                "Perfect",
                R.string.perfectSinger,
                R.string.perfectTime
            )
        )
        songList.add(
            Song(
                AppCompatResources.getDrawable(requireContext(), R.drawable.kesariya),
                "Kesariya",
                R.string.kesariyaSinger,
                R.string.kesariyaTime
            )
        )
        songList.add(
            Song(
                AppCompatResources.getDrawable(requireContext(), R.drawable.hawayein),
                "Hawayein",
                R.string.hawayeinSinger,
                R.string.hawayeinTime
            )
        )
        songList.add(
            Song(
                AppCompatResources.getDrawable(requireContext(), R.drawable.shape_song),
                "Shape Of You",
                R.string.shapeSinger,
                R.string.shapeTime
            )
        )
        songList.add(
            Song(
                AppCompatResources.getDrawable(requireContext(), R.drawable.perfect),
                "Perfect",
                R.string.perfectSinger,
                R.string.perfectTime
            )
        )
        songList.add(
            Song(
                AppCompatResources.getDrawable(requireContext(), R.drawable.kesariya),
                "Kesariya",
                R.string.kesariyaSinger,
                R.string.kesariyaTime
            )
        )
        songList.add(
            Song(
                AppCompatResources.getDrawable(requireContext(), R.drawable.hawayein),
                "Hawayein",
                R.string.hawayeinSinger,
                R.string.hawayeinTime
            )
        )

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.searchRv.layoutManager = layoutManager

        val adapter = SongAdapter(songList)
        binding.searchRv.adapter = adapter
    }
}