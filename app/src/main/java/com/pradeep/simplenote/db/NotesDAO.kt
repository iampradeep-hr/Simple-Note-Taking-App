package com.pradeep.simplenote.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pradeep.simplenote.models.Notes

@Dao
interface NotesDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNotes(notes: Notes)

    @Delete
    suspend fun deleteNotes(notes: Notes)

    @Query("SELECT * FROM notes_db")
    fun getAllNotes():LiveData<List<Notes>>

    @Update
    suspend fun updateNotes(notes: Notes)

}