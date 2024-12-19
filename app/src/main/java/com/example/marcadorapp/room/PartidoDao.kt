package com.example.marcadorapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.marcadorapp.model.Partido

@Dao
interface PartidoDao {
    @Insert
    suspend fun insertarPartido(partido: Partido): Long

    @Query("SELECT * FROM partidos WHERE id = :id")
    suspend fun obtenerPartidoPorId(id: Int): Partido?

    @Query("""
        SELECT * FROM partidos
        WHERE equipo_local_id = :equipoId OR equipo_rival_id = :equipoId
    """)
    suspend fun obtenerPartidosPorEquipo(equipoId: Int): List<Partido>

    @Query("DELETE FROM partidos WHERE id = :id")
    suspend fun eliminarPartido(id: Int)
}
