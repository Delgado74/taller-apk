package com.apklachy.app.ui

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.apklachy.app.ApklachyApp
import com.apklachy.app.data.Estadisticas
import com.apklachy.app.data.Reparacion
import com.apklachy.app.data.TipoTrabajo
import com.apklachy.app.util.Periodo
import com.apklachy.app.util.Rangos
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AppViewModel(aplicacion: ApklachyApp) : AndroidViewModel(aplicacion) {

    private val repositorio = aplicacion.repositorio

    val historial: StateFlow<List<Reparacion>> = repositorio.todos()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    private val _estadisticas = MutableStateFlow<Estadisticas?>(null)
    val estadisticas: StateFlow<Estadisticas?> = _estadisticas.asStateFlow()

    private val _cargando = MutableStateFlow(false)
    val cargando: StateFlow<Boolean> = _cargando.asStateFlow()

    fun guardar(marca: String, tipo: TipoTrabajo, precio: Double) {
        viewModelScope.launch {
            repositorio.guardar(marca, tipo, precio)
        }
    }

    fun actualizar(reparacion: Reparacion) {
        viewModelScope.launch {
            repositorio.actualizar(reparacion)
        }
    }

    fun eliminar(id: Long) {
        viewModelScope.launch {
            repositorio.eliminar(id)
        }
    }

    fun cargarEstadisticas(periodo: Periodo, desplazamiento: Int) {
        viewModelScope.launch {
            _cargando.value = true
            val rango = Rangos.de(periodo, desplazamiento)
            _estadisticas.value = repositorio.estadisticas(rango.desde, rango.hasta)
            _cargando.value = false
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                AppViewModel(this[APPLICATION_KEY] as ApklachyApp)
            }
        }
    }
}
