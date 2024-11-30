package Metodos;

import entidades.Administrador;
import entidades.Doctor;
import entidades.Paciente;

import java.io.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Objects;

public class Metodos {
    private static final String FILE_PATHAD = "C:\\Users\\almar\\Desktop\\Escuela\\Java\\BDProyectoFinal\\adminBD.dat";
    private static final String FILE_PATHDC = "C:\\Users\\almar\\Desktop\\Escuela\\Java\\BDProyectoFinal\\doctoresBD.dat";
    private static final String FILE_PATHPC = "C:\\Users\\almar\\Desktop\\Escuela\\Java\\BDProyectoFinal\\pacientesBD.dat";

    File fileAD = new File(FILE_PATHAD);
    File fileDC = new File(FILE_PATHDC);
    File filePC = new File(FILE_PATHPC);


    // METODO QUE VERIFICA AL USUARIO (SI ES ADMIN, DOCTOR, PACIENTE)
    public int ishere(String user, String password) {
        if (!fileAD.exists() || !fileDC.exists() || !filePC.exists()) {
            System.out.println("Uno o más archivos no existen.");
            return 0; // O maneja el error de otra manera
        }

        try (
                ObjectInputStream streamAD = new ObjectInputStream(new FileInputStream(FILE_PATHAD));
                ObjectInputStream streamDC = new ObjectInputStream(new FileInputStream(FILE_PATHDC));
                ObjectInputStream streamPC = new ObjectInputStream(new FileInputStream(FILE_PATHPC))
        ) {
            // Leer los objetos desde los flujos
            ArrayList<Administrador> ListaLAD = (ArrayList<Administrador>) streamAD.readObject();
            ArrayList<Doctor> ListaLDC = (ArrayList<Doctor>) streamDC.readObject();
            ArrayList<Paciente> ListaLPC = (ArrayList<Paciente>) streamPC.readObject();

            // Comparar con la base de datos de Administradores
            for (Administrador entry : ListaLAD) {
                System.out.println("Comparando: " + entry.getUserAdm() + " con " + user);
                System.out.println("El id de est es" + entry.getIdAdmin());
                if (Objects.equals(entry.getUserAdm().trim().toLowerCase(), user.trim().toLowerCase()) &&
                        Objects.equals(entry.getPasswordAdm().trim(), password.trim())) {
                    System.out.println(user + " es un administrador.");
                    return 1;
                }
            }

            // Comparar con la base de datos de Doctores
            for (Doctor entry : ListaLDC) {
                System.out.println("Comparando: " + entry.getUserD() + " con " + user);
                System.out.println("El id de est es" + entry.getIdDoctor());
                if (Objects.equals(entry.getUserD().trim().toLowerCase(), user.trim().toLowerCase()) &&
                        Objects.equals(entry.getPasswordD().trim(), password.trim())) {
                    System.out.println(user + " es un doctor.");
                    return 2;
                }
            }

            // Comparar con la base de datos de Pacientes
            for (Paciente entry : ListaLPC) {
                System.out.println("Comparando: " + entry.getUsuarioP() + " con " + user);
                if (Objects.equals(entry.getUsuarioP().trim().toLowerCase(), user.trim().toLowerCase()) &&
                        Objects.equals(entry.getPasswordP().trim(), password.trim())) {
                    System.out.println(user + " es un paciente.");
                    return 3;
                }
            }

            System.out.println(user + " no se encontró en ninguna base de datos.");
        } catch (EOFException e) {
            System.out.println("El archivo está vacío o se ha alcanzado el final del archivo inesperadamente.");
        } catch (IOException e) {
            e.printStackTrace(); // Esto imprimirá la pila de la excepción
            System.out.println("Fallo en la lectura de archivos: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Fallo al encontrar la clase: " + e.getMessage());
        }

        return 0;
    }
}