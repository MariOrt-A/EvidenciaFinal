package Metodos;

import entidades.Administrador;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AdminCRUD {
    private static final String FILE_PATH = "C:\\Users\\almar\\Desktop\\Escuela\\Java\\BDProyectoFinal\\adminBD.dat";
    private List<Administrador> usersAdmin = new ArrayList<>();

    public int adAdmin(String user, String password, String name, String pAdm, String mAdm, String range) {
        // Validar que los campos no estén vacíos
        if (user == null || password == null || name == null || pAdm == null || mAdm == null || range == null ||
                user.isEmpty() || password.isEmpty() || name.isEmpty() || pAdm.isEmpty() || mAdm.isEmpty() || range.isEmpty()) {
            System.out.println("Todos los campos deben ser completados.");
            return 0;
        }

        int fIdAdmin;
        // Leer administradores existentes
        try (FileInputStream readAd = new FileInputStream(FILE_PATH);
             ObjectInputStream streamAd = new ObjectInputStream(readAd)) {
            usersAdmin = (List<Administrador>) streamAd.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Si hay un error, inicializa la lista
            usersAdmin = new ArrayList<>();
        }

        // Obtener ID para el nuevo administrador
        fIdAdmin = usersAdmin.isEmpty() ? 1 : usersAdmin.get(usersAdmin.size() - 1).getIdAdmin() + 1;

        // Agregar nuevo administrador
        Administrador nAdmin = new Administrador(fIdAdmin, user, password, name, pAdm, mAdm, range);
        usersAdmin.add(nAdmin);

        // Escribir la lista actualizada de administradores en el archivo
        try (FileOutputStream write = new FileOutputStream(FILE_PATH);
             ObjectOutputStream myStream = new ObjectOutputStream(write)) {
            myStream.writeObject(usersAdmin);
            return 1; // Retornar true si se agrega correctamente
        } catch (IOException e) {
            System.out.println("Error al guardar el administrador: " + e.getMessage());
            return 0; // Retornar false en caso de error
        }
    }

    public Administrador buscarAdmin(int idAdm) {
        try (FileInputStream read1 = new FileInputStream(FILE_PATH);
             ObjectInputStream stream1 = new ObjectInputStream(read1)) {
            List<Administrador> listaAdmins = (List<Administrador>) stream1.readObject();
            Administrador k;

            for (int i = 0; i < listaAdmins.size(); i++) {
                k = listaAdmins.get(i);
                if (idAdm == listaAdmins.get(i).getIdAdmin()){
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