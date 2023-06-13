package com.example.demo.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Paint.Style
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.androidproject.R
import kotlin.math.min

class SliderCustomView(context: Context, attrs: AttributeSet): View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var margin: Float
    private var rectangle: RectF? = null
    private val progress = 25f
    private val progressStart = 135f
    private val progressSweep = 270f
    private var progressAngle = 200f

    init {
        paint.color = Color.BLUE
        paint.style = Style.STROKE
        paint.strokeWidth = 15f
        margin = 20f

        progressAngle = (progress * progressSweep) / 100
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (rectangle == null) {
            val size = min(width.toFloat() - margin, height.toFloat() - margin)
            rectangle = RectF(margin + 20f, margin + 70f , size + 10f, size + 90f)

        }

        paint.color = Color.GRAY
        paint.style = Style.STROKE
        canvas.drawArc(rectangle!!, progressStart, progressSweep, false, paint)

        paint.color = ContextCompat.getColor(context, R.color.blue)
        paint.style = Style.STROKE
        canvas.drawArc(rectangle!!, progressStart, progressAngle, false, paint)

        val sweepAngle = progressStart + progressAngle
        val centerX = rectangle!!.centerX()
        val centerY = rectangle!!.centerY()

        val radius = rectangle!!.height() / 2
        val angle = (sweepAngle % 360) * Math.PI / 180
        val x = centerX + radius * StrictMath.cos(angle)
        val y = centerY + radius * kotlin.math.sin(angle)

        paint.style = Style.FILL
        canvas.drawCircle(x.toFloat() , y.toFloat(),30f,paint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = min(measuredWidth, measuredHeight)
        setMeasuredDimension(size,size)
    }
}