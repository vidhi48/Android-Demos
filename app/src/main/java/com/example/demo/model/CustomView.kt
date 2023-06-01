package com.example.demo.model

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class CustomView(context: Context, attrs: AttributeSet): View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val faceColor = Color.CYAN
    private val eyesColor = Color.BLACK
    private val mouthColor = Color.BLACK
    private val borderColor = Color.LTGRAY
    private val borderWidth = 5.0f
    private var faceSize = 320
    private val mouthPath = Path()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawFace(canvas)
        drawEyes(canvas)
        drawMouth(canvas)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        faceSize = measuredWidth.coerceAtMost(measuredHeight)
        setMeasuredDimension(faceSize, faceSize)
    }

    private fun drawFace(canvas: Canvas?) {
        paint.color = faceColor
        paint.style = Paint.Style.FILL

        val radius = faceSize / 2f
        canvas?.drawCircle(faceSize / 2f, faceSize / 2f, radius, paint)

        paint.color = borderColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth
        canvas?.drawCircle(faceSize / 2f, faceSize / 2f, radius - borderWidth / 2f, paint)
    }

    private fun drawEyes(canvas: Canvas?) {
        paint.color = eyesColor
        paint.style = Paint.Style.FILL

        val leftEyeRect = RectF(faceSize * 0.32f, faceSize * 0.23f, faceSize * 0.43f, faceSize * 0.50f)
        canvas?.drawOval(leftEyeRect, paint)

        val rightEyeRect = RectF(faceSize * 0.57f, faceSize * 0.23f, faceSize * 0.68f, faceSize * 0.50f)
        canvas?.drawOval(rightEyeRect, paint)
    }

    private fun drawMouth(canvas: Canvas?) {
        mouthPath.moveTo(faceSize * 0.22f, faceSize * 0.7f)
        mouthPath.quadTo(faceSize * 0.50f, faceSize * 0.80f, faceSize * 0.78f, faceSize * 0.70f)
        mouthPath.quadTo(faceSize * 0.50f, faceSize * 0.90f, faceSize * 0.22f, faceSize * 0.70f)
        paint.color = mouthColor
        paint.style = Paint.Style.FILL
        canvas?.drawPath(mouthPath, paint)
    }
}