package com.example.demo.tabLayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.demo.HomeFragment
import com.example.demo.MovieFragment
import com.example.demo.SportsFragment

class AdapterDemo(fragmentActivity: FragmentActivity, private val tabCount: Int) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return tabCount
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> SportsFragment()
            2 -> MovieFragment()
            else -> SportsFragment()
        }
    }
}