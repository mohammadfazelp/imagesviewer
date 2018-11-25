package com.faz.imagesviewer.data.network.model.images

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Urls(@Expose
                @SerializedName("raw")
                var raw: String? = null,

                @Expose
                @SerializedName("full")
                var full: String? = null,

                @Expose
                @SerializedName("regular")
                var regular: String? = null,

                @Expose
                @SerializedName("small")
                var small: String? = null,

                @Expose
                @SerializedName("thumb")
                var thumb: String? = null)