package com.faz.imagesviewer.data.network.model.images

import com.faz.imagesviewer.data.network.model.images.cat.Category
import com.faz.imagesviewer.data.network.model.images.usr.User
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImageResponse(@Expose
                              @SerializedName("id")
                              var id: String? = null,

                              @Expose
                              @SerializedName("created_at")
                              var created_at: String? = null,

                              @Expose
                              @SerializedName("width")
                              var width: Double? = null,

                              @Expose
                              @SerializedName("height")
                              var height: Double? = null,

                              @Expose
                              @SerializedName("color")
                              var color: String? = null,

                              @Expose
                              @SerializedName("likes")
                              var likes: Long? = null,

                              @Expose
                              @SerializedName("liked_by_user")
                              var liked_by_user:Boolean? =null,

                              @Expose
                              @SerializedName("user")
                              var user: User?=null,

                              @Expose
                              @SerializedName("urls")
                              var urls: Urls?=null,

                              @Expose
                              @SerializedName("categories")
                              var categories: ArrayList<Category>?=null,

                              @Expose
                              @SerializedName("links")
                              var links : Links? =null)


