package com.apklachy.app.data

import kotlinx.coroutines.flow.Flow

data class Estadisticas(
    val total: Double,
    val cantidad: Int,
    val marcas: List<Conteo>,
    val tipos: List<Conteo>
) {
    val promedio: Double
        get() = if (cantidad > 0) total / cantidad else 0.0
}

class Repositorio(private val dao: ReparacionDao) {

    fun todos(): Flow<List<Reparacion>> = dao.todos()

    suspend fun guardar(marca: String, modelo: String, tipo: String, precio: Double): Long {
        val reparacion = Reparacion(
            marca = listOf(marca.trim(), modelo.trim())
                .filter { it.isNotEmpty() }
                .joinToString(" "),
            tipo = TipoTrabajo.normalizar(tipo),
            precio = precio,
            fecha = System.currentTimeMillis()
        )
        return dao.insertar(reparacion)
    }

    suspend fun actualizar(reparacion: Reparacion) = dao.actualizar(reparacion)

    suspend fun eliminar(id: Long) = dao.eliminarPorId(id)

    suspend fun estadisticas(desde: Long, hasta: Long): Estadisticas {
        val total = dao.totalEnPeriodo(desde, hasta)
        return Estadisticas(
            total = total.total,
            cantidad = total.cantidad,
            marcas = dao.marcasEnPeriodo(desde, hasta),
            tipos = dao.tiposEnPeriodo(desde, hasta)
        )
    }
}
