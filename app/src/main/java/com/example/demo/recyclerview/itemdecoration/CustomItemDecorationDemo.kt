package com.example.demo.recyclerview.itemdecoration

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView

class CustomItemDecorationDemo : RecyclerView.ItemDecoration() {

    override fun onDraw(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(canvas, parent, state)
        val dividerLeft = 0
        val dividerRight = parent.width
        val height = 30
        val childCount = parent.childCount
        for (i in 0 until childCount - 1) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val dividerTop = child.bottom + height
            canvas.drawLine(
                dividerLeft.toFloat(),
                dividerTop.toFloat(),
                dividerRight.toFloat(),
                dividerTop.toFloat(),
                Paint().apply {
                    color = Color.RED
                    strokeWidth = 15f
                })
        }
    }
}