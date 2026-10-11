package com.apklachy.app.data

enum class TipoTrabajo(val etiqueta: String) {
    MODULO("Módulo"),
    BOTON("Botón"),
    BATERIA("Batería"),
    BMS("BMS"),
    PEGAR_PANTALLA("Pegar pantalla"),
    REGIMEN("Régimen"),
    PLACA("Placa"),
    BROCHE("Broche");

    companion object {
        val etiquetas: List<String> = entries.map { it.etiqueta }

        private fun conocer(valor: String): TipoTrabajo? {
            val limpio = valor.trim()
            return entries.firstOrNull {
                it.name.equals(limpio, ignoreCase = true) ||
                    it.etiqueta.equals(limpio, ignoreCase = true)
            }
        }

        fun normalizar(valor: String): String =
            conocer(valor)?.name ?: valor.trim()

        fun etiquetaDe(valor: String): String =
            conocer(valor)?.etiqueta ?: valor.trim()
    }
}
