package com.apklachy.app.util

import java.util.Calendar

enum class Periodo(val etiqueta: String) {
    DIA("Día"),
    SEMANA("Semana"),
    MES("Mes")
}

data class Rango(val desde: Long, val hasta: Long)

object Rangos {

    /**
     * @param desplazamiento 0 = período actual, -1 = anterior, 1 = siguiente, ...
     */
    fun de(periodo: Periodo, desplazamiento: Int): Rango {
        val calendario = Calendar.getInstance()
        limpiar(calendario)

        when (periodo) {
            Periodo.DIA -> {
                calendario.add(Calendar.DAY_OF_MONTH, desplazamiento)
                val desde = calendario.timeInMillis
                calendario.add(Calendar.DAY_OF_MONTH, 1)
                return Rango(desde, calendario.timeInMillis - 1)
            }

            Periodo.SEMANA -> {
                val diaSemana = calendario.get(Calendar.DAY_OF_WEEK)
                val desdeLunes = (diaSemana - Calendar.MONDAY + 7) % 7
                calendario.add(Calendar.DAY_OF_MONTH, -desdeLunes + desplazamiento * 7)
                val desde = calendario.timeInMillis
                calendario.add(Calendar.DAY_OF_MONTH, 7)
                return Rango(desde, calendario.timeInMillis - 1)
            }

            Periodo.MES -> {
                calendario.set(Calendar.DAY_OF_MONTH, 1)
                calendario.add(Calendar.MONTH, desplazamiento)
                val desde = calendario.timeInMillis
                calendario.add(Calendar.MONTH, 1)
                return Rango(desde, calendario.timeInMillis - 1)
            }
        }
    }

    /** Etiqueta legible del período, por ejemplo: "08/10/2026", "05 – 11 oct 2026", "octubre 2026". */
    fun etiqueta(periodo: Periodo, desplazamiento: Int, formateador: (Long) -> String): String {
        val rango = de(periodo, desplazamiento)
        return when (periodo) {
            Periodo.DIA -> formateador(rango.desde)
            Periodo.SEMANA -> {
                val fin = java.util.Calendar.getInstance().apply { timeInMillis = rango.hasta }
                "${formateador(rango.desde)} – ${formateador(fin.timeInMillis)}"
            }
            Periodo.MES -> {
                val c = java.util.Calendar.getInstance().apply { timeInMillis = rango.desde }
                val meses = arrayOf(
                    "enero", "febrero", "marzo", "abril", "mayo", "junio",
                    "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"
                )
                "${meses[c.get(Calendar.MONTH)]} ${c.get(Calendar.YEAR)}"
            }
        }
    }

    private fun limpiar(calendario: Calendar) {
        calendario.set(Calendar.HOUR_OF_DAY, 0)
        calendario.set(Calendar.MINUTE, 0)
        calendario.set(Calendar.SECOND, 0)
        calendario.set(Calendar.MILLISECOND, 0)
    }
}
