package com.example.marcadorapp.repository

import com.example.marcadorapp.model.Equipo
import com.example.marcadorapp.room.EquipoDao
import javax.inject.Inject

class EquipoRepository @Inject constructor(
    private val equipoDao: EquipoDao
) {
    suspend fun insertarEquipo(equipo: Equipo): Long = equipoDao.insertarEquipo(equipo)
    suspend fun obtenerTodosLosEquipos(): List<Equipo> = equipoDao.obtenerTodosLosEquipos()
    suspend fun obtenerEquipoPorId(id: Int): Equipo? = equipoDao.obtenerEquipoPorId(id)
    suspend fun eliminarEquipo(id: Int) = equipoDao.eliminarEquipo(id)
}
