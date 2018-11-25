package com.faz.imagesviewer.data.network.model.images.usr

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserLinks(@Expose
                     @SerializedName("self")
                     var self: String? = null,

                     @Expose
                     @SerializedName("html")
                     var html: String? = null,

                     @Expose
                     @SerializedName("photos")
                     var photos: String? = null,

                     @Expose
                     @SerializedName("likes")
                     var likes: String? = null)