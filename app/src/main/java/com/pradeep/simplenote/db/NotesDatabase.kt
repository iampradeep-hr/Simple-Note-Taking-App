package com.pradeep.simplenote.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pradeep.simplenote.models.Notes

@Database(
    entities = [Notes::class],
    version = 1
)
abstract class NotesDatabase:RoomDatabase(){
    abstract fun getNotesDao():NotesDAO

    companion object{
        @Volatile
        private var INSTANCE:NotesDatabase?=null
        fun getNotesDatabase(context: Context):NotesDatabase{
            if (INSTANCE==null){
                synchronized(this){
                    INSTANCE=Room.databaseBuilder(
                        context.applicationContext,
                        NotesDatabase::class.java,
                        "notesdb"
                    ).build()
                }
            }


            return INSTANCE!!
        }

    }


}