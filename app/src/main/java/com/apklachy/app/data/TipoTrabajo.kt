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
        fun desdeEtiqueta(texto: String): TipoTrabajo =
            entries.firstOrNull { it.etiqueta.equals(texto, ignoreCase = true) } ?: MODULO

        fun desdeNombre(nombre: String): TipoTrabajo =
            entries.firstOrNull { it.name == nombre } ?: MODULO
    }
}
