package com.pradeep.simplenote.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "notes_db")
data class Notes(
    @PrimaryKey(autoGenerate = true)
    var id:Long?=null,
    val priority:Int,
    val title:String?,
    val description:String?
)