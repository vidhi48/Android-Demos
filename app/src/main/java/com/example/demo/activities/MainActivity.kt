package com.example.demo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidproject.databinding.ActivityMainBinding
import com.example.demo.recyclerview.activities.BottomNavigationActivity
import com.example.demo.recyclerview.activities.ExpandableListViewActivity
import com.example.demo.recyclerview.activities.ExpandableRecyclerActivity
import com.example.demo.recyclerview.activities.GridRecyclerViewActivity
import com.example.demo.recyclerview.activities.ListViewDemo
import com.example.demo.recyclerview.activities.MultiViewsRecyclerActivity
import com.example.demo.recyclerview.activities.RecyclerViewDemo
import com.example.demo.recyclerview.activities.StaggeredGridViewActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() = with(binding){
        list.setOnClickListener{
            val intent = Intent(this@MainActivity, ListViewDemo::class.java)
            startActivity(intent)
        }

        expandList.setOnClickListener{
            val intent = Intent(this@MainActivity, ExpandableListViewActivity::class.java)
            startActivity(intent)
        }

        recycle.setOnClickListener{
            val intent = Intent(this@MainActivity, RecyclerViewDemo::class.java)
            startActivity(intent)
        }

        expandRecycle.setOnClickListener{
            val intent = Intent(this@MainActivity, ExpandableRecyclerActivity::class.java)
            startActivity(intent)
        }

        gridRv.setOnClickListener{
            val intent = Intent(this@MainActivity, GridRecyclerViewActivity::class.java)
            startActivity(intent)
        }

        stagRv.setOnClickListener{
            val intent = Intent(this@MainActivity, StaggeredGridViewActivity::class.java)
            startActivity(intent)
        }

        multiRv.setOnClickListener{
            val intent = Intent(this@MainActivity, MultiViewsRecyclerActivity::class.java)
            startActivity(intent)
        }

        bottomNav.setOnClickListener{
            val intent = Intent(this@MainActivity, BottomNavigationActivity::class.java)
            startActivity(intent)
        }
    }
}