package com.faz.imagesviewer.data.network.model.images.cat

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CategoryLinks(@Expose
                         @SerializedName("self")
                         var self: String? = null,

                         @Expose
                         @SerializedName("photos")
                         var photos: String? = null)