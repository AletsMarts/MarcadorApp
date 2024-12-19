package com.example.marcadorapp.repository

import com.example.marcadorapp.model.Equipo
import com.example.marcadorapp.model.Partido
import com.example.marcadorapp.model.Set
import com.example.marcadorapp.room.EquipoDao
import com.example.marcadorapp.room.PartidoDao
import com.example.marcadorapp.room.SetDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.conflate
import javax.inject.Inject

class VolleyBallRepository @Inject constructor(
    private val equipoDao: EquipoDao,
    private val partidoDao: PartidoDao,
    private val setDao: SetDao
) {
    // Métodos para EquipoDao
    suspend fun insertarEquipo(equipo: Equipo): Long = equipoDao.insertarEquipo(equipo)
    suspend fun obtenerTodosLosEquipos(): List<Equipo> = equipoDao.obtenerTodosLosEquipos()
    suspend fun obtenerEquipoPorId(id: Int): Equipo? = equipoDao.obtenerEquipoPorId(id)
    suspend fun eliminarEquipo(id: Int) = equipoDao.eliminarEquipo(id)

    // Métodos para PartidoDao
    suspend fun insertarPartido(partido: Partido): Long = partidoDao.insertarPartido(partido)
    suspend fun obtenerPartidoPorId(id: Int): Partido? = partidoDao.obtenerPartidoPorId(id)
    suspend fun obtenerPartidosPorEquipo(equipoId: Int): List<Partido> =
        partidoDao.obtenerPartidosPorEquipo(equipoId)
    suspend fun eliminarPartido(id: Int) = partidoDao.eliminarPartido(id)

    // Métodos para SetDao
    suspend fun insertarSet(set: Set): Long = setDao.insertarSet(set)
    suspend fun obtenerSetsPorPartido(partidoId: Int): List<Set> =
        setDao.obtenerSetsPorPartido(partidoId)
    suspend fun obtenerSetPorId(id: Int): Set? = setDao.obtenerSetPorId(id)
    suspend fun eliminarSet(id: Int) = setDao.eliminarSet(id)
}
