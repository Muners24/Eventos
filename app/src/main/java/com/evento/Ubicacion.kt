package com.evento

import androidx.compose.runtime.Composable

class Ubicacion(ubicacioni: String,latitudi: Float,longitudi: Float){
    private val ubicacion = ubicacioni
    private val latitud = latitudi
    private val longitud = longitudi

    public fun getUbicacion(): String{
        val lugar = "$ubicacion\nLatitud: $latitud\nLongitud: ${longitud}"
        return lugar
    }
}

