package com.example.demo.recyclerview.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivityExpandableRecyclerBinding
import com.example.demo.recyclerview.adapters.ExpandableAdapter
import com.example.demo.recyclerview.models.ExpandableModel

class ExpandableRecyclerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExpandableRecyclerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExpandableRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val languageList = mutableListOf<ExpandableModel>()
        languageList.add(
            ExpandableModel(
                "Java", "Java is an Object Oriented Programming language." +
                        " Java is used in all kind of applications like Mobile Applications (Android is Java based), " +
                        "desktop applications, web applications, client server applications, enterprise applications and many more. ",
                false)
        )
        languageList.add(
            ExpandableModel("Kotlin", "Kotlin is a statically typed, general-purpose programming language" +
                    " developed by JetBrains, that has built world-class IDEs like IntelliJ IDEA, PhpStorm, Appcode, etc.",
                false)
        )
        languageList.add(
            ExpandableModel("Python", "Python is a high-level, general-purpose and a very popular programming language." +
                    " Python programming language (latest Python 3) is being used in web development, Machine Learning applications, " +
                    "along with all cutting edge technology in Software Industry.",
                false)
        )
        languageList.add(
            ExpandableModel("CPP", "C++ is a general purpose programming language and widely used now a days for " +
                    "competitive programming. It has imperative, object-oriented and generic programming features. ",
                false)
        )

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.expandRecycler.layoutManager = layoutManager

        val recyclerViewAdapter = ExpandableAdapter(languageList)
        binding.expandRecycler.adapter = recyclerViewAdapter
        recyclerViewAdapter.notifyDataSetChanged()
    }
}