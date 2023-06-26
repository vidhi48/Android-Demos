package com.example.demo.whatsapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.demo.whatsapp.CallsFragment
import com.example.demo.whatsapp.ChatFragment
import com.example.demo.whatsapp.CommunityFragment
import com.example.demo.whatsapp.StatusFragment

class TabAdapter(fragmentActivity: FragmentActivity, private val tabCount: Int) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return tabCount
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CommunityFragment()
            1 -> ChatFragment()
            2 -> StatusFragment()
            3 -> CallsFragment()
            else -> CommunityFragment()
        }
    }
}