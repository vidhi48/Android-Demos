package com.example.demo.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.example.androidproject.R

class RemoteCustomView(context: Context?, attrs: AttributeSet) : View(context, attrs) {

    private val mSlices = 4
    private val degreeStep = 360 / mSlices
    private val quarterDegreeMinus = -45
    private var outerRadius = 0f
    private var innerRadius = 0f

    private var outerRadiusSquare = 0f
    private var innerRadiusSquare = 0f
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val sliceOval = RectF()
    private val innerRadiusRatio = 0.5f

    private val colors = intArrayOf(context!!.getColor(R.color.lightGray), context.getColor(R.color.lightGray), context.getColor(R.color.lightGray), context.getColor(R.color.lightGray))
    private var centerX = 0
    private var centerY = 0

    init {
        paint.strokeWidth = 2f
    }

    public override fun onSizeChanged(_width: Int, _height: Int, oldw: Int, oldh: Int) {
        centerX = _width / 2
        centerY = _height / 2
        outerRadius = (if (centerX > centerY) centerY else centerX).toFloat()
        innerRadius = outerRadius * innerRadiusRatio
        outerRadiusSquare = outerRadius * outerRadius
        innerRadiusSquare = innerRadius * innerRadius
        sliceOval.left = centerX - outerRadius
        sliceOval.right = centerX + outerRadius
        sliceOval.top = centerY - outerRadius
        sliceOval.bottom = centerY + outerRadius
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        outerRadius = measuredWidth.coerceAtMost(measuredHeight).toFloat()
        setMeasuredDimension(outerRadius.toInt(), outerRadius.toInt())
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
    }
}