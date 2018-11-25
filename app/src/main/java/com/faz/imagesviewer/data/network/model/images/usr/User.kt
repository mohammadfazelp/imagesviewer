package com.faz.imagesviewer.data.network.model.images.usr

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(@Expose
                @SerializedName("id")
                var id: String? = null,

                @Expose
                @SerializedName("username")
                var username: String? = null,

                @Expose
                @SerializedName("name")
                var name: String? = null,

                @Expose
                @SerializedName("profile_image")
                var profile_image: ProfileImage? = null,

                @Expose
                @SerializedName("links")
                var links: UserLinks? = null)