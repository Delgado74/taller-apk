package com.apklachy.app.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

data class TotalPeriodo(
    val total: Double,
    val cantidad: Int
)

data class Conteo(
    val valor: String,
    val cantidad: Int
)

@Dao
interface ReparacionDao {

    @Insert
    suspend fun insertar(reparacion: Reparacion): Long

    @Update
    suspend fun actualizar(reparacion: Reparacion)

    @Query("DELETE FROM reparaciones WHERE id = :id")
    suspend fun eliminarPorId(id: Long)

    @Query("SELECT * FROM reparaciones ORDER BY fecha DESC, id DESC")
    fun todos(): Flow<List<Reparacion>>

    @Query(
        """
        SELECT COALESCE(SUM(precio), 0.0) AS total, COUNT(*) AS cantidad
        FROM reparaciones
        WHERE fecha >= :desde AND fecha <= :hasta
        """
    )
    suspend fun totalEnPeriodo(desde: Long, hasta: Long): TotalPeriodo

    @Query(
        """
        SELECT marca AS valor, COUNT(*) AS cantidad
        FROM reparaciones
        WHERE fecha >= :desde AND fecha <= :hasta
        GROUP BY marca
        ORDER BY cantidad DESC, valor ASC
        """
    )
    suspend fun marcasEnPeriodo(desde: Long, hasta: Long): List<Conteo>

    @Query(
        """
        SELECT tipo AS valor, COUNT(*) AS cantidad
        FROM reparaciones
        WHERE fecha >= :desde AND fecha <= :hasta
        GROUP BY tipo
        ORDER BY cantidad DESC, valor ASC
        """
    )
    suspend fun tiposEnPeriodo(desde: Long, hasta: Long): List<Conteo>
}
