package com.example.marcadorapp.repository

import com.example.marcadorapp.model.Set
import com.example.marcadorapp.room.PartidoDao
import com.example.marcadorapp.room.SetDao
import javax.inject.Inject

class SetRepository @Inject constructor(
    private val setDao: SetDao
) {
    // Métodos para SetDao
    suspend fun insertarSet(set: Set): Long = setDao.insertarSet(set)
    suspend fun obtenerSetsPorPartido(partidoId: Int): List<Set> =
        setDao.obtenerSetsPorPartido(partidoId)
    suspend fun obtenerSetPorId(id: Int): Set? = setDao.obtenerSetPorId(id)
    suspend fun eliminarSet(id: Int) = setDao.eliminarSet(id)
}