package com.evento


open class Usuario(correoi: String = "", contrasenai: String = "") {

    private var correo: String = correoi
    private var contrasena: String = contrasenai

    fun getCorreo(): String {
        return correo
    }

    //fun recuperarContrasena() {
        // falta implementar
    //}
}