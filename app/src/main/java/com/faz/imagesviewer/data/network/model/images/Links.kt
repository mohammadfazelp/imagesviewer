package com.faz.imagesviewer.data.network.model.images

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Links(@Expose
                 @SerializedName("self")
                 var self: String? = null,

                 @Expose
                 @SerializedName("html")
                 var html: String? = null,

                 @Expose
                 @SerializedName("download")
                 var download: String? = null)