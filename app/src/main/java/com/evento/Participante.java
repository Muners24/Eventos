package com.evento;
import java.util.ArrayList;
import java.util.List;

public class Participante{

    public String nombre;
    public String numero_participante;
    private String fecha_nacimiento;
    private String sexo;
    private String correo;
    private String telefono;
    
    private String contacto_emergencia;
    private int num_seguro;
    private float peso;
    private float altura;
    private String tipo_sangre;
    //listas
    private List<String> medicamento_actual;
    private List<String> alergias;
    private List<String> enfermedades;
    private List<String> lesiones;
    private List<String> vacunas;

    public Participante(String nombre,
    String fecha_nacimiento,
    String sexo,
    String numero_participante,
    String correo,
    String telefono,
    String contacto_emergencia,

    int num_seguro,
    float peso,
    float altura,
    String tipo_sangre,
    //listas
    List<String> medicamento_actual,
    List<String> alergias,
    List<String> enfermedades,
    List<String> lesiones,
    List<String> vacunas){
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.sexo = sexo;
        this.numero_participante = numero_participante;
        this.correo = correo;
        this.telefono = telefono;
        this.contacto_emergencia = contacto_emergencia;

        this.num_seguro = num_seguro;
        this.peso = peso;
        this.altura = altura;
        this.tipo_sangre = tipo_sangre;
        //listas
        this.medicamento_actual = medicamento_actual;
        this.alergias = alergias;
        this.enfermedades = enfermedades;
        this.lesiones = lesiones;
        this.vacunas = vacunas;
    }

    public void consultarDatosGenerales(){
        System.out.println("\tNombre: " + nombre);
        System.out.println("\tNúmero de corredor: " + numero_participante);
        //System.out.println("Fecha de nacimiento: " + fecha_nacimiento);
        //System.out.println("Sexo: " + sexo);
        //System.out.println("Correo: " + correo);
        //System.out.println("Telefono: " + telefono);
    }
    
    public void consultarDatosMedicos(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Número de corredor: " + numero_participante);
        System.out.println("Contacto de emergencia: " + contacto_emergencia);
        System.out.println("Numero de seguro: " + num_seguro);
        System.out.println("Peso: " + peso);
        System.out.println("Altura: " + altura);
        System.out.println("Tipo de sangre: " + tipo_sangre + "\n");
        printLista(medicamento_actual,"Medicamentos");
        printLista(alergias,"Alergias");
        printLista(enfermedades,"Enfermedades");
        printLista(lesiones,"Lesiones");
        printLista(vacunas,"Vacunas");
    }

    public void printLista(List<String> lista,String titulo){
        int i = 1;
        System.out.println("\t" + titulo);
        for (String elemento : lista)
        {
            System.out.println("\t" +i + ". " + elemento);
            i ++;
        }
        System.out.println();
    }
}