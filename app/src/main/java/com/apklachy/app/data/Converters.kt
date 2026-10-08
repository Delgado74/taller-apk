package com.apklachy.app.data

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun deTipoATexto(valor: TipoTrabajo): String = valor.name

    @TypeConverter
    fun deTextoATipo(valor: String): TipoTrabajo = TipoTrabajo.desdeNombre(valor)
}
