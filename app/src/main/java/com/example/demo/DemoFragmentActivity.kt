package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivityDemoFragmentBinding

class DemoFragmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDemoFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupFragments()
    }

    private fun setupFragments() {

        supportFragmentManager.commit {
            replace(R.id.fragments, LifeCycleFragment::class.java, null)
        }

        binding.fragmentOne.setOnClickListener{
            supportFragmentManager.commit {
                replace(R.id.fragments, LifeCycleFragment::class.java, null)
            }
        }

        binding.fragmentTwo.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.fragments, SecondFragment::class.java, null)
            }
        }
    }
}