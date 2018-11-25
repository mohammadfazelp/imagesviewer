package com.faz.imagesviewer.ui.home.view

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.faz.imagesviewer.R
import com.faz.imageloader.DoubleCache
import com.faz.imageloader.ImageLoader
import com.faz.imagesviewer.data.network.model.images.ImageResponse
import kotlinx.android.synthetic.main.row_images.view.*

class RecyclerAdapter (private val imageList: ArrayList<ImageResponse>, context: Context)
    : RecyclerView.Adapter<RecyclerAdapter.ImageHolder>()  {

    init {
      ImageLoader.setCache(DoubleCache(context))
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {

        val inflatedView = parent.inflate(R.layout.row_images, false)
        return ImageHolder(inflatedView)
    }

    fun clearCache(){
        ImageLoader.clearCache()
    }

    override fun getItemCount() = imageList.size

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {

        val itemPhoto = imageList[position]
        holder.bindPhoto(itemPhoto)
    }

    class ImageHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v
        private var image: ImageResponse? = null

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICK!")
        }

        companion object {
            private val PHOTO_KEY = "PHOTO"
        }

        fun bindPhoto(image: ImageResponse) {
            this.image = image
            image.urls?.small?.let { ImageLoader.displayImage(it, view.itemImage) }
            view.itemTitle.text = image.user?.username
            view.itemDescription.text = image.user?.name
            image.user?.profile_image?.small?.let { ImageLoader.displayImage(it, view.avatarImageView) }
        }
    }

    fun clear(){
        imageList.clear()
        notifyDataSetChanged()
    }

    fun addAll(images : ArrayList<ImageResponse>){
        imageList.addAll(images)
        notifyDataSetChanged()
    }
}