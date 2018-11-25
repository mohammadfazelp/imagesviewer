package com.faz.imagesviewer.ui.base.rv

import androidx.recyclerview.widget.RecyclerView
import androidx.core.view.ViewCompat
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.annotation.DrawableRes
import android.widget.LinearLayout
import androidx.annotation.NonNull


class RecycleViewDivider(context: Context, orientation: Int,
                         @param:NonNull protected var mDivider: Drawable?) :
        RecyclerView.ItemDecoration() {

    protected var mOrientation: Int = 0

    protected val mBounds = Rect()

    constructor(context: Context, orientation: Int, @DrawableRes resId: Int) : this(context,
            orientation, ContextCompat.getDrawable(context, resId)) {}

    init {
        setOrientation(orientation)
    }

    fun setOrientation(orientation: Int) {
        if (orientation != HORIZONTAL && orientation != VERTICAL) {
            throw IllegalArgumentException(
                    "Invalid orientation. It should be either HORIZONTAL or VERTICAL")
        }
        mOrientation = orientation
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        if (parent.layoutManager == null) {
            return
        }
        if (mOrientation == VERTICAL) {
            drawVertical(c, parent)
        } else {
            drawHorizontal(c, parent)
        }
    }

    @SuppressLint("NewApi")
    protected fun drawVertical(canvas: Canvas, parent: RecyclerView) {
        canvas.save()
        val left: Int
        val right: Int
        if (parent.clipToPadding) {
            left = parent.paddingLeft
            right = parent.width - parent.paddingRight
            canvas.clipRect(left, parent.paddingTop, right,
                    parent.height - parent.paddingBottom)
        } else {
            left = 0
            right = parent.width
        }

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            parent.getDecoratedBoundsWithMargins(child, mBounds)
            val bottom = mBounds.bottom + Math.round(ViewCompat.getTranslationY(child))
            val top = bottom - (mDivider?.intrinsicHeight ?: 0)
            mDivider?.setBounds(left, top, right, bottom)
            mDivider?.draw(canvas)
        }
        canvas.restore()
    }

    @SuppressLint("NewApi")
    protected fun drawHorizontal(canvas: Canvas, parent: RecyclerView) {
        canvas.save()
        val top: Int
        val bottom: Int
        if (parent.clipToPadding) {
            top = parent.paddingTop
            bottom = parent.height - parent.paddingBottom
            canvas.clipRect(parent.paddingLeft, top,
                    parent.width - parent.paddingRight, bottom)
        } else {
            top = 0
            bottom = parent.height
        }

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            parent.layoutManager?.getDecoratedBoundsWithMargins(child, mBounds)
            val right = mBounds.right + Math.round(ViewCompat.getTranslationX(child))
            val left = right - (mDivider?.intrinsicWidth ?: 0)
            mDivider?.setBounds(left, top, right, bottom)
            mDivider?.draw(canvas)
        }
        canvas.restore()
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (mOrientation == VERTICAL) {
            mDivider?.intrinsicHeight?.let { outRect.set(0, 0, 0, it) }
        } else {
            mDivider?.intrinsicWidth?.let { outRect.set(0, 0, it, 0) }
        }
    }

    companion object {

        const val HORIZONTAL = LinearLayout.HORIZONTAL
        const val VERTICAL = LinearLayout.VERTICAL
    }
}