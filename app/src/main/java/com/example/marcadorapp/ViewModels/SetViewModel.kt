package com.example.marcadorapp.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marcadorapp.model.Set
import com.example.marcadorapp.repository.SetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SetViewModel @Inject constructor(
    private val setRepository: SetRepository
) : ViewModel() {

    // LiveData para exponer la lista de sets
    private val _sets = MutableLiveData<List<Set>>()
    val sets: LiveData<List<Set>> get() = _sets

    // Método para cargar los sets de un partido
    fun cargarSetsPorPartido(partidoId: Int) {
        viewModelScope.launch {
            val lista = setRepository.obtenerSetsPorPartido(partidoId)
            _sets.postValue(lista)
        }
    }

    // Método para agregar un nuevo set
    fun agregarSet(set: Set) {
        viewModelScope.launch {
            setRepository.insertarSet(set)
            cargarSetsPorPartido(set.partidoId) // Recargar la lista
        }
    }

    // Método para eliminar un set por su ID
    fun eliminarSet(id: Int) {
        viewModelScope.launch {
            setRepository.eliminarSet(id)
        }
    }

    // Método para obtener un set por su ID
    fun obtenerSetPorId(id: Int): LiveData<Set?> {
        val setLiveData = MutableLiveData<Set?>()
        viewModelScope.launch {
            val set = setRepository.obtenerSetPorId(id)
            setLiveData.postValue(set)
        }
        return setLiveData
    }
}
