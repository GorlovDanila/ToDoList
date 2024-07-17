package com.example.feature.note.impl.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.example.feature.note.impl.data.db.entity.NoteEntityDb

@Dao
interface NoteDao {

    @Insert(onConflict = REPLACE)
    fun save(note: NoteEntityDb)

    @Query("SELECT * FROM Note")
    fun getAll(): List<NoteEntityDb>
}
