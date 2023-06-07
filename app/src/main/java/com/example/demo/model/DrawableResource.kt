package com.example.demo.model

import android.graphics.Bitmap as AndroidBitmap

sealed class DrawableResource {
    data class Drawable(val id: Int) : DrawableResource()
    data class Bitmap(val bitmap: AndroidBitmap) : DrawableResource()
}

