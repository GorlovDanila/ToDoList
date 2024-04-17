package com.example.todolist.util

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.feature.note.impl.data.db.dao.NoteDao
import com.example.feature.note.impl.data.db.entity.NoteEntityDb

@Database(entities = [NoteEntityDb::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao
}
