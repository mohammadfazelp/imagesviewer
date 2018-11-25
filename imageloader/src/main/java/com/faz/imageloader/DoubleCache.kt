package com.faz.imageloader

import android.content.Context
import android.graphics.Bitmap

class DoubleCache(context: Context) : ImageCache {

    private val memCache = MemoryCache()
    //private val diskCache = DiskCache(context)

    override fun get(url: String): Bitmap? {
        return memCache.get(url) /*?: diskCache.get(url)*/
    }

    override fun put(url: String, bitmap: Bitmap) {
        memCache.put(url, bitmap)
        //diskCache.put(url, bitmap)
    }

    override fun clear() {
        memCache.clear()
        //diskCache.clear()
    }
}