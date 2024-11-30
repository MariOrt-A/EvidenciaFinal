package Metodos;

import entidades.Citas;
import entidades.Doctor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CitasCRUD {
    private static final String FILE_PATH = "C:\\Users\\almar\\Desktop\\Escuela\\Java\\BDProyectoFinal\\citasBD.dat";
    private List<Citas> citas = new ArrayList<Citas>();

    public int adCita(String fechaC, String horaC, String observacionC) {
        // Validar que los campos no estén vacíos
        if (fechaC == null || horaC == null) {
            System.out.println("Todos los campos deben ser completados.");
            return 0;
        }

        int fIdCita;
        // Leer doctores existentes
        try (FileInputStream readCita = new FileInputStream(FILE_PATH);
             ObjectInputStream streamCita = new ObjectInputStream(readCita)) {
            citas = (List<Citas>) streamCita.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Si hay un error, inicializa la lista
            citas = new ArrayList<Citas>();
        }

        // Obtener ID para el nuevo Doctor
        fIdCita = citas.isEmpty() ? 1 : citas.get(citas.size() - 1).getIdCita() + 1;

        // Agregar nuevo administrador
        Citas nCita = new Citas(fIdCita, fechaC, horaC, observacionC);
        citas.add(nCita);

        // Escribir la lista actualizada de administradores en el archivo
        try (FileOutputStream writeD = new FileOutputStream(FILE_PATH);
             ObjectOutputStream myStreamD = new ObjectOutputStream(writeD)) {
            myStreamD.writeObject(citas);
            return 1; // Retornar true si se agrega correctamente
        } catch (IOException e) {
            System.out.println("Error al guardar el administrador: " + e.getMessage());
            return 2; // Retornar false en caso de error
        }
    }
}
