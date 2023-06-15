package com.example.demo.recyclerview.itemdecoration

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.R

class RecyclerViewItemDecoration(context: Context, resId: Int): RecyclerView.ItemDecoration() {
    private val divider: Drawable = ContextCompat.getDrawable(context, R.drawable.item_divider_recyclerview)!!

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        val dividerLeft = 0
        val dividerRight = parent.width

        for (i in 0 until parent.childCount) {
            if (i != parent.childCount - 1) {
                val child = parent.getChildAt(i)
                val params = child.layoutParams as RecyclerView.LayoutParams
                val dividerTop = child.bottom
                val dividerBottom = dividerTop + divider.intrinsicHeight
                divider.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom)
                divider.draw(c)
            }
        }
    }
}