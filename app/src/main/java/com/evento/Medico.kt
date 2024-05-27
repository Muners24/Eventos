package com.evento

class Medico(correoi: String, contrasenai: String) : Usuario(correoi, contrasenai) {
    var asignado = false

    public fun setAsingFlag(flag: Boolean = false){
        asignado = flag
    }
}