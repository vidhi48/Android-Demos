package com.example.demo.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.example.androidproject.R
import kotlin.math.sqrt

class RemoteCustomView(context: Context?, attrs: AttributeSet) : View(context, attrs) {

    private val mSlices = 4
    private val degreeStep = 360 / mSlices
    private val quarterDegreeMinus = -45
    private var outerRadius = 0f
    private var innerRadius = 0f
    private var radius = 20f

    private var outerRadiusSquare = 0f
    private var innerRadiusSquare = 0f
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val sliceOval = RectF()
    private val innerRadiusRatio = 0.5f

    private val colors = intArrayOf(Color.LTGRAY, Color.LTGRAY, Color.LTGRAY, Color.LTGRAY)
    private var centerX = 0
    private var centerY = 0

    private val path = Path()

    init {
        paint.strokeWidth = 2f
    }

    public override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        centerX = w / 2
        centerY = h / 2
        outerRadius = (if (centerX > centerY) centerY else centerX).toFloat()
        innerRadius = outerRadius * innerRadiusRatio
        outerRadiusSquare = outerRadius * outerRadius
        innerRadiusSquare = innerRadius * innerRadius
        sliceOval.left = centerX - outerRadius
        sliceOval.right = centerX + outerRadius
        sliceOval.top = centerY - outerRadius
        sliceOval.bottom = centerY + outerRadius
    }

    public override fun onDraw(canvas: Canvas) {

        //slices
        var startAngle = quarterDegreeMinus
        for (i in 0 until mSlices) {
            paint.style = Paint.Style.FILL
            paint.color = colors[i % colors.size]
            canvas.drawArc(sliceOval, startAngle.toFloat(), degreeStep.toFloat(), true, paint)
            paint.style = Paint.Style.STROKE
            paint.color = Color.GRAY
            canvas.drawArc(sliceOval, startAngle.toFloat(), degreeStep.toFloat(), true, paint)
            startAngle += degreeStep
        }

        //inside circle
        paint.style = Paint.Style.FILL
        paint.color = Color.WHITE
        canvas.drawCircle(centerX.toFloat(), centerX.toFloat(), innerRadius, paint)

        //triangle button
//        val halfHeight = (sqrt(3.0) / 2.0 * radius).toFloat()
//        val halfWidth = radius / 2f
//        path.moveTo(startAngle * 0.2f, centerY + halfHeight)
//        path.lineTo(centerX + halfWidth, centerY + halfHeight)
//        path.lineTo(centerX.toFloat(), centerY - radius)
//        paint.color = context.getColor(R.color.grayIcon)
//        paint.style = Paint.Style.FILL
//        canvas.drawPath(path, paint)
    }
}