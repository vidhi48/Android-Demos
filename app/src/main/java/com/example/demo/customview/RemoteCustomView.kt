package com.example.demo.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Point
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

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

    private val colors = intArrayOf(Color.LTGRAY, Color.LTGRAY, Color.LTGRAY, Color.LTGRAY)
    private var centerX = 0
    private var centerY = 0

    private val point = Point()
    private val radius = width / 4f

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

        val sectionWidth = radius / 2
        paint.color = Color.GRAY
        paint.style = Paint.Style.FILL

        point.x = centerX - 20
        point.y = (centerY - sectionWidth - 210).toInt()
        val topTriangle = triangleButton(point, 40, Direction.TOP)
        canvas.drawPath(topTriangle, paint)

        point.x = centerX - 20
        point.y = (centerY + sectionWidth + 210).toInt()
        val bottomTriangle = triangleButton(point, 40, Direction.BOTTOM)
        canvas.drawPath(bottomTriangle, paint)

        point.x = (centerX - sectionWidth - 210).toInt()
        point.y = centerY - 20
        val leftTriangle = triangleButton(point, 40, Direction.LEFT)
        canvas.drawPath(leftTriangle, paint)

        point.x = (centerX + sectionWidth + 210).toInt()
        point.y = centerY - 20
        val rightTriangle = triangleButton(point, 40, Direction.RIGHT)
        canvas.drawPath(rightTriangle, paint)
    }

    private fun triangleButton(p1: Point, width: Int, direction: Direction): Path {
        var p2: Point? = null
        var p3: Point? = null
        when (direction) {
            Direction.TOP -> {
                p2 = Point(p1.x + width, p1.y)
                p3 = Point(p1.x + width / 2, p1.y - width)
            }
            Direction.BOTTOM -> {
                p2 = Point(p1.x + width, p1.y)
                p3 = Point(p1.x + width / 2, p1.y + width)
            }
            Direction.LEFT -> {
                p2 = Point(p1.x, p1.y + width)
                p3 = Point(p1.x - width, p1.y + width / 2)
            }
            Direction.RIGHT -> {
                p2 = Point(p1.x, p1.y + width)
                p3 = Point(p1.x + width, p1.y + width / 2)
            }
        }
        val path = Path()
        path.moveTo(p1.x.toFloat(), p1.y.toFloat())
        path.lineTo(p2.x.toFloat(), p2.y.toFloat())
        path.lineTo(p3.x.toFloat(), p3.y.toFloat())
        return path
    }

    enum class Direction {
        TOP, BOTTOM, LEFT, RIGHT
    }
}