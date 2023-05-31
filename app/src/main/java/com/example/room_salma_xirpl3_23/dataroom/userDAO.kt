package com.example.room_salma_xirpl3_23.dataroom

import androidx.room.*

@Dao

interface userDAO {

    //menampilkan data
    @Query("SELECT * FROM tbuser")
    fun getAll():List<user>

    //memasukkan data
    @Insert
    fun insertData(user: user)

    //menghapus data
    @Delete
    fun deleteData(user: user)

    //mengubah data
    @Update
    fun updateData(user: user)
}