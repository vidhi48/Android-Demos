package com.example.demo.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivityNavigationDrawerBinding
import com.google.android.material.navigation.NavigationView

class NavigationDrawerActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityNavigationDrawerBinding
    private var menuItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {

        setSupportActionBar(binding.toolbar)
        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        toggle.isDrawerIndicatorEnabled = true
        binding.drawerLayout.addDrawerListener(toggle)

        binding.navigationView.setNavigationItemSelectedListener(this)
        changeFragment(FirstNavigationFragment())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar_items, menu)
        if (menu != null) {
            menuItem = menu.findItem(R.id.search)
        }
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        binding.drawerLayout.close()

        when (item.itemId) {
            R.id.signUp -> {
                supportActionBar?.title = item.title
                menuItem?.isVisible = false
                changeFragment(FirstNavigationFragment())
            }

            R.id.settings -> {
                supportActionBar?.title = item.title
                menuItem?.isVisible = false
                changeFragment(SecondNavigationFragment())
            }

            R.id.songs -> {
                supportActionBar?.title = item.title
                menuItem?.isVisible = true
                changeFragment(ThirdNavigationFragment())
            }
        }
        title = item.title
        return true
    }

    private fun changeFragment(fragments: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.nav_host_fragment, fragments)
        }
    }
}