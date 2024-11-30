package Metodos;

import entidades.Doctor;
import entidades.Paciente;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteCRUD {
    private static final String FILE_PATH = "C:\\Users\\almar\\Desktop\\Escuela\\Java\\BDProyectoFinal\\pacientesBD.dat";
    private List<Paciente> usersPc = new ArrayList<Paciente>();
    String rango = "Paciente";

    public int adPC(String user, String password, String name, String pPc, String mPc, Integer edad, String direccion, String telefono) {
        // Validar que los campos no estén vacíos
        if (user == null || password == null || name == null || pPc == null || mPc == null || edad == null || direccion == null|| telefono == null||
                user.isEmpty() || password.isEmpty() || name.isEmpty() || pPc.isEmpty() || mPc.isEmpty() || direccion.isEmpty()||telefono.isEmpty()) {
            System.out.println("Todos los campos deben ser completados.");
            return 0;
        }

        int fIdPc;
        // Leer pacientes existentes
        try (FileInputStream readPc = new FileInputStream(FILE_PATH);
             ObjectInputStream streamPc = new ObjectInputStream(readPc)) {
            usersPc = (List<Paciente>) streamPc.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Si hay un error, inicializa la lista
            usersPc = new ArrayList<Paciente>();
        }

        // Obtener ID para el nuevo Doctor
        fIdPc = usersPc.isEmpty() ? 1 : usersPc.get(usersPc.size() - 1).getIdPaciente() + 1;

        // Agregar nuevo administrador
        Paciente nPc = new Paciente(fIdPc, edad, user,password, name, pPc, mPc, direccion, telefono,rango);
        usersPc.add(nPc);

        // Escribir la lista actualizada de administradores en el archivo
        try (FileOutputStream writeP = new FileOutputStream(FILE_PATH);
             ObjectOutputStream myStreamP = new ObjectOutputStream(writeP)) {
            myStreamP.writeObject(usersPc);
            return 1; // Retornar true si se agrega correctamente
        } catch (IOException e) {
            System.out.println("Error al guardar el paciente: " + e.getMessage());
            return 2; // Retornar false en caso de error
        }
    }

    public Paciente buscarPaciente(int idPac) {
        try (FileInputStream read1 = new FileInputStream(FILE_PATH);
             ObjectInputStream stream1 = new ObjectInputStream(read1)) {
            List<Paciente> listaPacientes = (List<Paciente>) stream1.readObject();
            Paciente k;

            for (int i = 0; i < listaPacientes.size(); i++) {
                k = listaPacientes.get(i);
                if (idPac == listaPacientes.get(i).getIdPaciente()){
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
