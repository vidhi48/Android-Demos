package com.example.demo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.example.myapplication.R

class CustomView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    companion object {
        private const val DEFAULT_FACE_COLOR = Color.CYAN
        private const val DEFAULT_EYES_COLOR = Color.BLACK
        private const val DEFAULT_MOUTH_COLOR = Color.BLACK
        private const val DEFAULT_BORDER_COLOR = Color.LTGRAY
        private const val DEFAULT_BORDER_WIDTH = 2.0f
    }

    private var faceColor = DEFAULT_FACE_COLOR
    private var eyesColor = DEFAULT_EYES_COLOR
    private var mouthColor = DEFAULT_MOUTH_COLOR
    private var borderColor = DEFAULT_BORDER_COLOR
    private var borderWidth = DEFAULT_BORDER_WIDTH

    private val paint = Paint()
    private val mouthPath = Path()
    private var faceSize = 0

    init {
        paint.isAntiAlias = true
        setupAttributes(attrs)
    }

    private fun setupAttributes(attrs: AttributeSet) {
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.CustomView, 0, 0)
        faceColor = typedArray.getColor(R.styleable.CustomView_faceColor, DEFAULT_FACE_COLOR)
        eyesColor = typedArray.getColor(R.styleable.CustomView_eyesColor, DEFAULT_EYES_COLOR)
        mouthColor = typedArray.getColor(R.styleable.CustomView_mouthColor, DEFAULT_MOUTH_COLOR)
        borderColor = typedArray.getColor(R.styleable.CustomView_borderColor, DEFAULT_BORDER_COLOR)
        borderWidth =
            typedArray.getDimension(R.styleable.CustomView_borderWidth, DEFAULT_BORDER_WIDTH)
    }

    override fun onDraw(canvas: Canvas) {
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

        val leftEyeRect =
            RectF(faceSize * 0.32f, faceSize * 0.23f, faceSize * 0.43f, faceSize * 0.50f)
        canvas?.drawOval(leftEyeRect, paint)

        val rightEyeRect =
            RectF(faceSize * 0.57f, faceSize * 0.23f, faceSize * 0.68f, faceSize * 0.50f)
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
