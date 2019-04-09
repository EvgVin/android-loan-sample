package com.evgvin.loan.ui.common

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import android.view.View
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.evgvin.loan.R
import com.evgvin.loan.ui.selfie.SelfieFragment

/**
 * Custom camera view border class.
 * Used in [SelfieFragment].
 */
class CameraViewBorder @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private val rectPaint = Paint()
    private val iconPaint = Paint()
    private var transparentColor = Color.argb(0, 0, 0, 0)

    init {
        rectPaint.apply {
            color = transparentColor
            isAntiAlias = true
            xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_ATOP)
        }
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        canvas?.apply {
            drawRect(setupRect(), rectPaint)

            val bitmap = drawableToBitmap(R.drawable.selfie_corner_icon)
            bitmap?.let {
                var x = paddingStart
                var y = paddingBottom
                canvas.rotateAndDrawBitmap(it, 0f, x, y, iconPaint)

                x = width - paddingEnd - it.width
                canvas.rotateAndDrawBitmap(it, 90f, x, y, iconPaint)

                y = height - paddingBottom - it.height
                canvas.rotateAndDrawBitmap(it, 180f, x, y, iconPaint)

                x = paddingStart
                canvas.rotateAndDrawBitmap(it, 270f, x, y, iconPaint)
            }
        }
    }

    private fun setupRect() = Rect().apply {
        left = paddingStart
        top = paddingTop
        right = width - paddingEnd
        bottom = height - paddingBottom
    }

    private fun drawableToBitmap(@DrawableRes resource: Int): Bitmap? {
        val drawable = ContextCompat.getDrawable(context, resource)

        if (drawable is BitmapDrawable) return drawable.bitmap

        var bitmap: Bitmap? = null

        drawable?.let {
            bitmap = Bitmap.createBitmap(it.intrinsicWidth, it.intrinsicHeight, Bitmap.Config.ARGB_8888)

            val canvas = Canvas(bitmap!!)
            it.setBounds(0, 0, canvas.width, canvas.height)
            it.draw(canvas)
        }

        return bitmap
    }

    private fun Canvas.rotateAndDrawBitmap(bitmap: Bitmap, rotation: Float, left: Int, top: Int, paint: Paint) {
        val rotator = Matrix()

        val xRotate = bitmap.width / 2f
        val yRotate = bitmap.height / 2f
        rotator.postRotate(rotation, xRotate, yRotate);

        rotator.postTranslate(left.toFloat(), top.toFloat());

        drawBitmap(bitmap, rotator, paint);
    }

}