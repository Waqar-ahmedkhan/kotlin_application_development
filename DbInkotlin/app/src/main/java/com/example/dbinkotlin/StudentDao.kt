package com.example.dbinkotlin

import  androidx.room.Dao
import  androidx.room.Insert
import  androidx.room.Query

@Dao
 interface  StudentDao {
     @insert
     suspend fun  InsetStudent( student: Student)

     @Query("SELECT * FROM students")
     suspend fun getallStudent(); List<S
    tudent>
 }

