package com.example.demo.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class RemoteCustomView(context: Context, attrs: AttributeSet) : View(context, attrs){

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val circleColor = Color.GRAY
    private var size = 200

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawOutsideCircle(canvas)
    }

    private fun drawOutsideCircle(canvas: Canvas) {
        paint.color = circleColor
        paint.style = Paint.Style.FILL
        val radius = size / 2f
        canvas.drawCircle(size / 2f, size / 2f, radius, paint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        size = measuredWidth.coerceAtMost(measuredHeight)
        setMeasuredDimension(size, size)
    }

}