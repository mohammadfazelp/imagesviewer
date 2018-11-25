package com.faz.imagesviewer.data.database
import androidx.room.Database
import androidx.room.RoomDatabase
import com.faz.imagesviewer.data.database.repository.images.QuestionsDao
import com.faz.imagesviewer.data.database.repository.images.Image
import okio.Options


@Database(entities = [(Image::class), (Options::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun questionsDao(): QuestionsDao
}