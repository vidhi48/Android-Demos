package com.example.demo.recyclerview.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidproject.databinding.ActivityExpandableListViewBinding
import com.example.demo.recyclerview.adapters.ExpandableListAdapter

class ExpandableListViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExpandableListViewBinding
    private var adapter: ExpandableListAdapter? = null

    private val dataItems: HashMap<String, List<String>>
        get() {
            val items = HashMap<String, List<String>>()
            val cricketItems = mutableListOf<String>()
            cricketItems.add("India")
            cricketItems.add("Pakistan")
            cricketItems.add("Australia")
            cricketItems.add("England")

            val footballItems = mutableListOf<String>()
            footballItems.add("Brazil")
            footballItems.add("Spain")
            footballItems.add("Germany")
            footballItems.add("Italy")

            val basketItems = mutableListOf<String>()
            basketItems.add("United States")
            basketItems.add("Africa")
            basketItems.add("India")

            items["Cricket Teams"] = cricketItems
            items["Football Teams"] = footballItems
            items["Basketball Teams"] = basketItems

            return items
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExpandableListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupExpandableListView()
    }

    private fun setupExpandableListView() {
        val listData = dataItems
        val titleList = ArrayList(listData.keys)
        adapter = ExpandableListAdapter(this, titleList as ArrayList<String>, listData)
        binding.expandList.setAdapter(adapter)
    }
}