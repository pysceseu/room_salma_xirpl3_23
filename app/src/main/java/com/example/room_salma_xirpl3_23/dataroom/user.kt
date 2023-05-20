package com.example.room_salma_xirpl3_23.dataroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("tbuser")
data class user(
    @PrimaryKey
    @ColumnInfo("ID_USER")
    val iduser: String,

    @ColumnInfo("NAMA_USER")
    val namauser: String,

    @ColumnInfo("JENISKELAMIN_USER")
    val jekeluser: String

)
