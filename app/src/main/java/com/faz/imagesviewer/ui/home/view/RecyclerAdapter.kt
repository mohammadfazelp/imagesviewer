package com.faz.imagesviewer.ui.home.view

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.faz.imagesviewer.R
import com.faz.imagesviewer.utils.imageloader.DoubleCache
import com.faz.imagesviewer.utils.imageloader.ImageLoader
import kotlinx.android.synthetic.main.row_images.view.*

class RecyclerAdapter (private val photos: ArrayList<Photo>, context : Context)
    : RecyclerView.Adapter<RecyclerAdapter.PhotoHolder>()  {

    init {
      ImageLoader.setCache(DoubleCache(context))
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {

        val inflatedView = parent.inflate(R.layout.row_images, false)
        return PhotoHolder(inflatedView)
    }

    fun clearCache(){
        ImageLoader.clearCache()
    }
    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {

        val itemPhoto = photos[position]
        holder.bindPhoto(itemPhoto)
    }

    //1
    class PhotoHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        //2
        private var view: View = v
        private var photo: Photo? = null

        //3
        init {
            v.setOnClickListener(this)
        }

        //4
        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICK!")
        }

        companion object {
            //5
            private val PHOTO_KEY = "PHOTO"
        }

        fun bindPhoto(photo: Photo) {
            this.photo = photo
            ImageLoader.displayImage("https://picsum.photos/200/300", view.itemImage)
            view.itemDate.text = photo.date
            view.itemDescription.text = photo.desc
        }
    }
}