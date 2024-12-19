package com.example.marcadorapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sets")
data class Set(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "partido_id")
    val partidoId: Int,
    @ColumnInfo(name = "numero_set")
    val numeroSet: Int,
    @ColumnInfo(name = "puntos_local")
    val puntosLocal: Int = 0,
    @ColumnInfo(name = "puntos_rival")
    val puntosRival: Int = 0
)
