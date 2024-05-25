package com.evento;

public class Medico extends Usuario {

    boolean evento_asignado;
    Accidente asignado;
    boolean accidente_asignado_b;


    public Medico(Usuario usuario) {
        super(usuario.getCorreo(), usuario.getContra());
        this.rol = 2;
        this.accidente_asignado_b = false;
    }

    public Medico(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
        this.rol = 2;
    }

    public void verAccidente() {
        if (accidente_asignado_b) {
            asignado.consultarAccidente();
        }
    }

    public void informarDisponiblidad() {
        if (asignado.estado == 4) {
            accidente_asignado_b = false;
        }
    }

    public void asignarAccidente(Accidente accidente) {
        this.asignado = accidente;
    }

}