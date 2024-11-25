package com.example.dbinkotlin

import androidx.room.Entity
import androidx.room.PrimeryKey

@Entity(tableName = "student")

data class Student(
    @PrimaryKey(autoGenerate = true) val id: int=0,
    val name: String,
    val studentClass: string,
    val classPosition : int,
    val picture: Int

)
