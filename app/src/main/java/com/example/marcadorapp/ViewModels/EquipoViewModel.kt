package com.example.marcadorapp.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marcadorapp.model.Equipo
import com.example.marcadorapp.repository.EquipoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EquipoViewModel @Inject constructor(
    private val equipoRepository: EquipoRepository
) : ViewModel() {

    // LiveData para exponer la lista de equipos
    private val _equipos = MutableLiveData<List<Equipo>>()
    val equipos: LiveData<List<Equipo>> get() = _equipos

    // Método para cargar todos los equipos
    fun cargarEquipos() {
        viewModelScope.launch {
            val lista = equipoRepository.obtenerTodosLosEquipos()
            _equipos.postValue(lista)
        }
    }

    // Método para agregar un nuevo equipo
    fun agregarEquipo(equipo: Equipo) {
        viewModelScope.launch {
            equipoRepository.insertarEquipo(equipo)
            cargarEquipos() // Recargar la lista
        }
    }

    // Método para eliminar un equipo por su ID
    fun eliminarEquipo(id: Int) {
        viewModelScope.launch {
            equipoRepository.eliminarEquipo(id)
            cargarEquipos() // Recargar la lista
        }
    }

    // Método para obtener un equipo por su ID
    fun obtenerEquipoPorId(id: Int): LiveData<Equipo?> {
        val equipoLiveData = MutableLiveData<Equipo?>()
        viewModelScope.launch {
            val equipo = equipoRepository.obtenerEquipoPorId(id)
            equipoLiveData.postValue(equipo)
        }
        return equipoLiveData
    }
}
