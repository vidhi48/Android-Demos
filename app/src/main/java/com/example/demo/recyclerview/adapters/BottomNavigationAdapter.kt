package com.example.demo.recyclerview.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.HistoryFragment
import com.example.HomeFragment
import com.example.ProfileFragment

class BottomNavigationAdapter(fa: FragmentActivity, private val totalCount: Int): FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return totalCount
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HistoryFragment()
            1 -> HomeFragment()
            2 -> ProfileFragment()
            else -> HistoryFragment()
        }
    }
}