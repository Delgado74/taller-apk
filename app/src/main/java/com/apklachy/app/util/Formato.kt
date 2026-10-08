package com.apklachy.app.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Formato {

    fun dinero(valor: Double): String =
        String.format(Locale.getDefault(), "%,.2f", valor) + " CUP"

    fun fecha(epochMillis: Long): String =
        SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date(epochMillis))

    fun fechaHora(epochMillis: Long): String =
        SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(Date(epochMillis))
}
