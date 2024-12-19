package com.example.marcadorapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "partidos")
data class Partido(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "equipo_local_id")
    val equipoLocalId: Int,
    @ColumnInfo(name = "equipo_rival_id")
    val equipoRivalId: Int,
    @ColumnInfo(name = "set_actual")
    val setActual: Int = 1,
    /*
    @ColumnInfo(name = "fecha")
    val fecha: String // Utilizar un formato estándar de fecha como ISO 8601 (e.g., "2023-12-31T23:59:59")
     */
    @ColumnInfo(name = "fecha")
    val fecha: Date // Ahora es de tipo Date
)
