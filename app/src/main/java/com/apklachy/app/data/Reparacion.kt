package com.apklachy.app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reparaciones")
data class Reparacion(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val marca: String,
    val tipo: String,
    val precio: Double,
    val fecha: Long
)
