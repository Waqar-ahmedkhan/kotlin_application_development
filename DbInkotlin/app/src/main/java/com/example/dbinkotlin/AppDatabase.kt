package com.example.dbinkotlin

import androidx.room.Database
import  androidx.room.Room
import  androidx.room.RoomDatabase

 abstract  class AppDatabase: RoomDatabase() {
     abstract fun  studentDao(): StudentDao
     companion object {
         @Volatile
         private var Instance
     }

}