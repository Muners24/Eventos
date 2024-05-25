package com.evento;
import java.util.List;

public class Accidente{
    String descripcion;
    String ubicacion;
    //pendiente, en espera, en camino, en atención, finalizado
    int estado;
    List<Participante> involucrados;

    public Accidente(String descripcion,String ubicacion,List<Participante> involucrados){
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.involucrados = involucrados;
        estado = 0;
    }

    public void consultarAccidente(){
        System.out.println(descripcion);
        if(estado == 0){
            System.out.println("Pendiente");
        }else if(estado == 1){
            System.out.println("En espera");
        }else if(estado == 2){
            System.out.println("En camino");
        }else if(estado == 3){
            System.out.println("En atencion");
        }else if(estado == 4){
            System.out.println("Finalizado");
        }
        System.out.println(ubicacion);
        printLista(involucrados,"Involucrados");
    }

    public void printLista(List<Participante> lista,String titulo){
        System.out.println(titulo);
        for (Participante elemento : lista)
        {
            elemento.consultarDatosMedicos();
        }
    }

}