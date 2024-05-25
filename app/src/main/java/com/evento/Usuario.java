package com.evento;

public class Usuario{
    String correo;
    String contraseña;
    int rol;
    boolean evento_asignado = false;
    //Evento eventos asigtnados;

    public Usuario(String correo,String contraseña){
        this.correo = correo;
        this.contraseña = contraseña;
        this.rol = -1;
    }

    public Usuario(){
        this.rol = -1;
    }

    public void crearCuenta(String correo,String contraseña){
        this.correo = correo;
        this.contraseña = contraseña;
    }
    
    public void recuperarContraseña(){
        //falta implementar
    }

    public String getCorreo(){
        return correo;
    }

    public String getContra(){
        return contraseña;
    }
}