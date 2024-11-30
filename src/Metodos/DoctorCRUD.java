package Metodos;

import entidades.Administrador;
import entidades.Doctor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorCRUD {
    private static final String FILE_PATH = "C:\\Users\\almar\\Desktop\\Escuela\\Java\\BDProyectoFinal\\doctoresBD.dat";
    private List<Doctor> usersDoc = new ArrayList<Doctor>();

    public int adDoc(String user, String password, String name, String pDc, String mDc, String especialidad, String rango) {
        // Validar que los campos no estén vacíos
        if (user == null || password == null || name == null || pDc == null || mDc == null || rango == null ||
                user.isEmpty() || password.isEmpty() || name.isEmpty() || pDc.isEmpty() || mDc.isEmpty() || rango.isEmpty()) {
            System.out.println("Todos los campos deben ser completados.");
            return 0;
        }

        int fIdDoc;
        // Leer doctores existentes
        try (FileInputStream readDc = new FileInputStream(FILE_PATH);
             ObjectInputStream streamDc = new ObjectInputStream(readDc)) {
            usersDoc = (List<Doctor>) streamDc.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Si hay un error, inicializa la lista
            usersDoc = new ArrayList<Doctor>();
        }

        // Obtener ID para el nuevo Doctor
        fIdDoc = usersDoc.isEmpty() ? 1 : usersDoc.get(usersDoc.size() - 1).getIdDoctor() + 1;

        // Agregar nuevo administrador
        Doctor nDoc = new Doctor(fIdDoc, user, password, name, pDc, mDc, especialidad,rango);
        usersDoc.add(nDoc);

        // Escribir la lista actualizada de administradores en el archivo
        try (FileOutputStream writeD = new FileOutputStream(FILE_PATH);
             ObjectOutputStream myStreamD = new ObjectOutputStream(writeD)) {
            myStreamD.writeObject(usersDoc);
            return 1; // Retornar true si se agrega correctamente
        } catch (IOException e) {
            System.out.println("Error al guardar el administrador: " + e.getMessage());
            return 2; // Retornar false en caso de error
        }
    }

    public Doctor buscarDoc(int idAdm) {
        try (FileInputStream read1 = new FileInputStream(FILE_PATH);
             ObjectInputStream stream1 = new ObjectInputStream(read1)) {
            List<Doctor> listaDocs = (List<Doctor>) stream1.readObject();
            Doctor k;

            for (int i = 0; i < listaDocs.size(); i++) {
                k = listaDocs.get(i);
                if (idAdm == listaDocs.get(i).getIdDoctor()){
                    return k;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer los administradores: " + e.getMessage());
            return null; // Retornar false en caso de error
        }
        return null;
    }
}
