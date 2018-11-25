package com.faz.imagesviewer.data.network.model.images.cat

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Category(@Expose
                    @SerializedName("id")
                    var id: Long? = null,

                    @Expose
                    @SerializedName("title")
                    var title: String? = null,

                    @Expose
                    @SerializedName("photo_count")
                    var photo_count: Int? = null,

                    @Expose
                    @SerializedName("links")
                    var links: CategoryLinks? = null)