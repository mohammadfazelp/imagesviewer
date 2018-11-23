package com.faz.imagesviewer.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginRequest {

    data class ServerLoginRequest internal constructor(@Expose
                                                       @SerializedName("email") internal
                                                       val email: String,
                                                       @Expose
                                                       @SerializedName("password") internal
                                                       val password: String)
}