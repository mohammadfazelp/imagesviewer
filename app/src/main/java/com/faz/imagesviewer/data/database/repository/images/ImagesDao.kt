package com.faz.imagesviewer.data.database.repository.images

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ImagesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(image: List<Image>)

    @Query("SELECT * FROM images")
    fun loadAll(): List<Image>
}