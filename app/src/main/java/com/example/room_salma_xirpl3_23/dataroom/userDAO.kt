package com.example.room_salma_xirpl3_23.dataroom

import androidx.room.*

@Dao

interface userDAO {
    @Query("SELECT * FROM tbuser")
    fun getAll():List<user>

    @Insert
    fun insertData(user: user)

    @Delete
    fun deleteData(user: user)

    @Update
    fun updateData(user: user)
}