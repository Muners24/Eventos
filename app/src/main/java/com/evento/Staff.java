package com.evento;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Staff extends Usuario{


    public Staff(Usuario usuario) {
        super(usuario.getCorreo(), usuario.getContra());
        this.evento_asignado = false;
        this.rol = 1;
    }

    public Staff(String correo,String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
        this.evento_asignado = false;
        this.rol = 1;
    }

    public Accidente registrarAccidente(List<Participante> todos_participantes){
        List<Participante> p_invol = new ArrayList<>();
        String descripcion;
        String ubicacion;
        int involucrados;

        Scanner scan = new Scanner(System.in);
        System.out.println("Registrar accidente\n\nParticipantes\n");
        System.out.print("\tIngresa el numero de participantes involucrados: ");
        involucrados = scan.nextInt();
        scan.nextLine();
        System.out.println();

        for(int i = 1; i<=involucrados;i++)
        {
            boolean find = false;
            System.out.print("\tIngresa el numero de corredor o nombre del participante " + i + ": ");
            String id = scan.nextLine();
            for(Participante elemento : todos_participantes)
            {
                if(elemento.numero_participante.equals(id) || elemento.nombre.equals(id))
                {
                    find = true;
                    System.out.println();
                    elemento.consultarDatosGenerales();
                    System.out.println();

                    p_invol.add(elemento);
                }
            }
            if(!find)
            {
                System.out.println("\nNo existe ese participante\n");
                i--;
            }
        }

        System.out.print("Descripcion\n\n\tIngresa una descripcion: ");
        descripcion = scan.nextLine();
        
        //asignar ubicacion
        ubicacion = "\tDireccion\nCoordendas";
        scan.close();
        return (new Accidente(descripcion,ubicacion,p_invol));
    }

    public void registrarParticipante(){
        
    }

}