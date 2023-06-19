package com.example.demo.recyclerview.models

import android.graphics.drawable.Drawable

sealed class DataModel {
    data class MovieModel(val title: Int, val releaseDate: Int) :
        DataModel()

    data class MovieAllDataModel(
        val title: Int,
        val image: Drawable?,
        val releaseDate: Int,
        val description: Int,
        val ratings: Int
    ) : DataModel()
}
