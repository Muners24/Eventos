package com.evento;

import java.util.*;

public class Main {
    static int rol = 1;
    static int op = 0;
    static List<Participante> participantes = new ArrayList<>();
    static List<Accidente> accidentes = new ArrayList<>();

    public static void main(String[] args) {

        // instancias de participantes
        participantes.add(new Participante(
                "Maria",
                "1985-05-15",
                "Femenino",
                "98765",
                "maria@example.com",
                "0987654321",
                "Juan",
                987654321,
                65.2f,
                160f,
                "B-",
                // Listas con algunos datos
                Arrays.asList("Aspirina", "Ibuprofeno"),
                Arrays.asList("Polen", "Ácaros"),
                Arrays.asList("Hipertensión", "Diabetes"),
                Arrays.asList("Fractura de pierna", "Esguince de tobillo"),
                Arrays.asList("Influenza", "Hepatitis B")));
        participantes.add(new Participante(
                "Juan",
                "1990-01-01",
                "Masculino",
                "12345",
                "juan@example.com",
                "1234567890",
                "María",
                123456789,
                70.5f,
                170f,
                "A+",
                Arrays.asList("Paracetamol", "Amoxicilina"),
                Arrays.asList("Nueces", "Mariscos"),
                Arrays.asList("Asma", "Hipotiroidismo"),
                Arrays.asList("Fractura de brazo", "Contusión en la cabeza"),
                Arrays.asList("Tétanos", "Varicela")));
        participantes.add(new Participante(
                "Ana",
                "1988-07-10",
                "Femenino",
                "54321",
                "ana@example.com",
                "0987654321",
                "Pedro",
                987654321,
                55.2f,
                165f,
                "AB-",
                Arrays.asList("Ibuprofeno", "Omeprazol"),
                Arrays.asList("Polen", "Leche"),
                Arrays.asList("Diabetes", "Artritis"),
                Arrays.asList("Esguince de tobillo", "Lumbalgia"),
                Arrays.asList("Sarampión", "Gripe")));
        participantes.add(new Participante(
                "Carlos",
                "1983-12-25",
                "Masculino",
                "67890",
                "carlos@example.com",
                "9876543210",
                "Luisa",
                123456789,
                80.2f,
                175f,
                "O+",
                Arrays.asList("Loratadina", "Metformina"),
                Arrays.asList("Polen", "Frutas cítricas"),
                Arrays.asList("Hipertensión", "Gastritis"),
                Arrays.asList("Fractura de pierna", "Luxación de hombro"),
                Arrays.asList("Hepatitis A", "Influenza")));
        participantes.add(new Participante(
                "Elena",
                "1975-03-18",
                "Femenino",
                "13579",
                "elena@example.com",
                "0123456789",
                "Pedro",
                987654321,
                70.0f,
                160f,
                "A-",
                Arrays.asList("Aspirina", "Ciprofloxacino"),
                Arrays.asList("Polvo", "Chocolate"),
                Arrays.asList("Hipertensión", "Osteoporosis"),
                Arrays.asList("Esguince de rodilla", "Fractura de muñeca"),
                Arrays.asList("Tétanos", "Hepatitis B")));
        participantes.add(new Participante(
                "Javier",
                "1980-09-03",
                "Masculino",
                "24680",
                "javier@example.com",
                "1357924680",
                "Sandra",
                987654321,
                90.5f,
                180f,
                "AB+",
                Arrays.asList("Diclofenaco", "Insulina"),
                Arrays.asList("Polvo", "Mariscos"),
                Arrays.asList("Asma", "Hipotiroidismo"),
                Arrays.asList("Fractura de pierna", "Luxación de hombro"),
                Arrays.asList("Hepatitis A", "Varicela")));
        participantes.add(new Participante(
                "Lucia",
                "1992-11-30",
                "Femenino",
                "97531",
                "lucia@example.com",
                "9876543210",
                "Diego",
                123456789,
                60.8f,
                165f,
                "O-",
                Arrays.asList("Paracetamol", "Omeprazol"),
                Arrays.asList("Polen", "Frutas secas"),
                Arrays.asList("Diabetes", "Artritis"),
                Arrays.asList("Esguince de tobillo", "Lumbalgia"),
                Arrays.asList("Gripe", "Resfriado")));

        Staff staff = new Staff("ramon.mejia@uabc.edu.mx", "staff");
        staff.evento_asignado = true;
        Medico medico = new Medico("ramon_chunqui@outlook.com", "medico");
        medico.evento_asignado = true;



    }



}
