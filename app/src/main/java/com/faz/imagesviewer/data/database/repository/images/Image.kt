package com.faz.imagesviewer.data.database.repository.images

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "images")
data class Image(
        @Expose
        @PrimaryKey
        var id: Long,

        @Expose
        @SerializedName("image_url")
        @ColumnInfo(name = "image_url")
        var imgUrl: String,

        @Expose
        @SerializedName("created_at")
        @ColumnInfo(name = "created_at")
        var createdAt: String?,

        @Expose
        @SerializedName("updated_at")
        @ColumnInfo(name = "updated_at")
        var updatedAt: String?
)