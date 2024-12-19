package com.example.marcadorapp.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marcadorapp.model.Partido
import com.example.marcadorapp.repository.PartidoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PartidoViewModel @Inject constructor(
    private val partidoRepository: PartidoRepository
) : ViewModel() {

    // LiveData para exponer la lista de partidos
    private val _partidos = MutableLiveData<List<Partido>>()
    val partidos: LiveData<List<Partido>> get() = _partidos

    // Método para cargar los partidos de un equipo
    fun cargarPartidosPorEquipo(equipoId: Int) {
        viewModelScope.launch {
            val lista = partidoRepository.obtenerPartidosPorEquipo(equipoId)
            _partidos.postValue(lista)
        }
    }

    // Método para agregar un nuevo partido
    fun agregarPartido(partido: Partido) {
        viewModelScope.launch {
            partidoRepository.insertarPartido(partido)
            cargarPartidosPorEquipo(partido.equipoLocalId) // Recargar la lista (usando equipo local como ejemplo)
        }
    }

    // Método para eliminar un partido por su ID
    fun eliminarPartido(id: Int) {
        viewModelScope.launch {
            partidoRepository.eliminarPartido(id)
        }
    }

    // Método para obtener un partido por su ID
    fun obtenerPartidoPorId(id: Int): LiveData<Partido?> {
        val partidoLiveData = MutableLiveData<Partido?>()
        viewModelScope.launch {
            val partido = partidoRepository.obtenerPartidoPorId(id)
            partidoLiveData.postValue(partido)
        }
        return partidoLiveData
    }
}
