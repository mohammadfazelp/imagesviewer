package com.faz.imagesviewer.ui.base.rv.listener

import android.view.View

interface IOnItemLongClickListener {
    fun onItemLongClick(view: View, position: Int): Boolean
}