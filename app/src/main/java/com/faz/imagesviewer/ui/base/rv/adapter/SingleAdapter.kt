package com.faz.imagesviewer.ui.base.rv.adapter

import androidx.annotation.LayoutRes


abstract class SingleAdapter<M>(list: List<M>, @param:LayoutRes private val mLayoutId: Int)
    : BaseAdapter<M>() {

    init {
        setData(list)
    }

    override fun bindLayout(viewType: Int): Int {
        return mLayoutId
    }
}