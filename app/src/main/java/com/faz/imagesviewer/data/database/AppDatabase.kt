package com.faz.imagesviewer.data.database
import androidx.room.Database
import androidx.room.RoomDatabase
import com.faz.imagesviewer.data.database.repository.images.Image
import com.faz.imagesviewer.data.database.repository.images.ImagesDao

@Database(entities = [(Image::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun imagesDao(): ImagesDao
}