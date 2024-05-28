package com.evento

import android.text.BoringLayout


open class Usuario(correoi: String = "", contrasenai: String = "") {

    private var correo: String = correoi
    private var contrasena: String = contrasenai
    private var asignado: Boolean = false
    fun getCorreo(): String {
        return correo
    }

    fun setAsingFlag(flag: Boolean) {
        asignado = flag
    }

    fun getAsignado():Boolean{
        return asignado
    }
}