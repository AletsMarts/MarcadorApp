package com.example.marcadorapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.marcadorapp.model.Set

@Dao
interface SetDao {
    @Insert
    suspend fun insertarSet(set: Set): Long

    @Query("SELECT * FROM sets WHERE partido_id = :partidoId")
    suspend fun obtenerSetsPorPartido(partidoId: Int): List<Set>

    @Query("SELECT * FROM sets WHERE id = :id")
    suspend fun obtenerSetPorId(id: Int): Set?

    @Query("DELETE FROM sets WHERE id = :id")
    suspend fun eliminarSet(id: Int)
}
