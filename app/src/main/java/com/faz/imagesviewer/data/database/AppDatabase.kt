package com.faz.imagesviewer.data.database
import androidx.room.Database
import androidx.room.RoomDatabase
import com.faz.imagesviewer.data.database.repository.questions.QuestionsDao
import com.faz.imagesviewer.data.database.repository.questions.Question
import okio.Options


@Database(entities = [(Question::class), (Options::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun questionsDao(): QuestionsDao
}