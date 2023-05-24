package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import com.example.myapplication.R
import com.google.android.material.appbar.MaterialToolbar

class AppBarDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_bar_demo)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.search -> Toast.makeText(this, "Search Clicked", Toast.LENGTH_SHORT).show()
            R.id.refresh -> Toast.makeText(this, "Refresh Clicked", Toast.LENGTH_SHORT).show()
            R.id.more -> Toast.makeText(this, "Copy Clicked", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}
