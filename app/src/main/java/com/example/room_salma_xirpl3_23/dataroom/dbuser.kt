package com.example.room_salma_xirpl3_23.dataroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext
import java.security.Key

//anotasi db dan pemanggilan tabel atau entity
@Database(entities = [user::class], version = 1)
abstract class dbuser : RoomDatabase() {
    abstract fun userdao() : userDAO

    companion object{
        @Volatile
        private var INSTANCE :dbuser?=null
        private var key = Any()
        operator fun invoke(context: Context) = INSTANCE ?: synchronized(key){
            INSTANCE ?: buildDatabase(context).also {
                INSTANCE= it
            }
        }
        //deklarasi nama database
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext, dbuser::class.java, "cobaxirpl3.db"
        ).fallbackToDestructiveMigration().build()
    }
}