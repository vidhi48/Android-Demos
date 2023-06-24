package com.example.demo.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentThirdNavigationBinding
import com.example.demo.navigation.adapters.SongAdapter
import com.example.demo.models.Song

class ThirdNavigationFragment : Fragment() {

    private lateinit var binding: FragmentThirdNavigationBinding
    private var songList = mutableListOf<Song>()
    private lateinit var adapter: SongAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdNavigationBinding.inflate(layoutInflater)
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
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

        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.searchRv.layoutManager = layoutManager

        val adapter = SongAdapter(songList)
        binding.searchRv.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.action_bar_items, menu)
        val searchItem = menu.findItem(R.id.search)
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterData(newText)
                return false
            }
        })

        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun filterData(query: String) {
        val filteredList = mutableListOf<Song>()

        songList.forEach { item ->
            if (item.songTitle.contains(query, ignoreCase = true)) {
                filteredList.add(item)
            }
        }
        adapter.filterList(filteredList)
    }
}