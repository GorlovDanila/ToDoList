package com.example.todolist.di

import android.content.Context
import androidx.room.Room
import com.example.feature.note.impl.data.db.dao.NoteDao
import com.example.todolist.db.AppDatabase
import org.koin.dsl.module

private const val DATABASE_NAME = "note_db"

val appModule = module {
    single {
        provideDatabase(
            context = get()
        )
    }
    single {
        provideNoteDao(
            database = get()
        )
    }
}

private fun provideDatabase(
    context: Context,
): AppDatabase =
    Room
        .databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME
        )
        .build()

private fun provideNoteDao(
    database: AppDatabase
): NoteDao = database.getNoteDao()
