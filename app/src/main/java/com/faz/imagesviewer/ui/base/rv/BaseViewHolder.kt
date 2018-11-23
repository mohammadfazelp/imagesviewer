package com.faz.imagesviewer.ui.base.rv

import androidx.annotation.IdRes
import android.util.SparseArray
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val viewArray = SparseArray<View>()

    fun getView(@IdRes viewId: Int): View? {
        var view: View? = viewArray.get(viewId)
        if (view == null) {
            view = itemView.findViewById<View>(viewId)
            viewArray.put(viewId, view)
        }
        return view
    }
}