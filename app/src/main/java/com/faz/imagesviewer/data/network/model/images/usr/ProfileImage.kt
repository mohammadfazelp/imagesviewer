package com.faz.imagesviewer.data.network.model.images.usr

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProfileImage(@Expose
                        @SerializedName("small")
                        var small: String? = null,

                        @Expose
                        @SerializedName("medium")
                        var medium: String? = null,

                        @Expose
                        @SerializedName("large")
                        var large: String? = null)