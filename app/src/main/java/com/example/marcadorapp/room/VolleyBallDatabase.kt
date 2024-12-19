package com.example.marcadorapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.marcadorapp.convertidores.ConvertidorFechas
import com.example.marcadorapp.model.Equipo
import com.example.marcadorapp.model.Partido
import com.example.marcadorapp.model.Set
import com.example.marcadorapp.room.SetDao
import com.example.marcadorapp.room.PartidoDao
import com.example.marcadorapp.room.EquipoDao

@Database(
    entities = [Equipo::class, Partido::class, Set::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ConvertidorFechas::class)
abstract class VolleyballDatabase : RoomDatabase() {
    abstract fun equipoDao(): EquipoDao
    abstract fun partidoDao(): PartidoDao
    abstract fun setDao(): SetDao
}

