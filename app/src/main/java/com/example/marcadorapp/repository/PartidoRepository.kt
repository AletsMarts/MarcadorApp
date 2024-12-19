package com.example.marcadorapp.repository

import com.example.marcadorapp.model.Partido
import com.example.marcadorapp.room.PartidoDao
import javax.inject.Inject

class PartidoRepository @Inject constructor(
    private val partidoDao: PartidoDao
) {
    // Métodos para PartidoDao
    suspend fun insertarPartido(partido: Partido): Long = partidoDao.insertarPartido(partido)
    suspend fun obtenerPartidoPorId(id: Int): Partido? = partidoDao.obtenerPartidoPorId(id)
    suspend fun obtenerPartidosPorEquipo(equipoId: Int): List<Partido> =
        partidoDao.obtenerPartidosPorEquipo(equipoId)

    suspend fun eliminarPartido(id: Int) = partidoDao.eliminarPartido(id)
}