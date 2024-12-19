package com.example.marcadorapp.room


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.marcadorapp.model.Equipo

@Dao
interface EquipoDao {
    @Insert
    suspend fun insertarEquipo(equipo: Equipo): Long

    @Query("SELECT * FROM equipos")
    suspend fun obtenerTodosLosEquipos(): List<Equipo>

    @Query("SELECT * FROM equipos WHERE id = :id")
    suspend fun obtenerEquipoPorId(id: Int): Equipo?

    @Query("DELETE FROM equipos WHERE id = :id")
    suspend fun eliminarEquipo(id: Int)
}
