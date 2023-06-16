package com.example.demo.recyclerview.models

import android.graphics.drawable.Drawable

data class ExpandableModel(
    val title: String,
    val images: Drawable?, val description: String, var isExpand: Boolean = false)