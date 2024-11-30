package ventanas;

import entidades.Doctor;
import entidades.Paciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class vCrearCitas extends JFrame{
    private JPanel JPcreate;
    private JComboBox cBPaciente;
    private JComboBox cBDoctor;
    private JTextField txtFechaCita;
    private JTextArea txtAObservacion;
    private JButton btIngresarCita;
    private JButton btSalirCita;


    public vCrearCitas(){
        try {
            FileInputStream readP = new FileInputStream("C:\\Users\\almar\\Desktop\\Escuela\\Java\\BDProyectoFinal\\pacientesBD.dat");
            ObjectInputStream writeP = new ObjectInputStream(readP);
            Object p = writeP.readObject();
            ArrayList<Paciente> listaPacientes = (ArrayList<Paciente>) p;

            for (Paciente a: listaPacientes)
            {
                cBPaciente.addItem(a.getNombreP());
            }
            readP.close();
            writeP.close();

            FileInputStream readD = new FileInputStream("C:\\Users\\almar\\Desktop\\Escuela\\Java\\BDProyectoFinal\\doctoresBD.dat");
            ObjectInputStream writeD = new ObjectInputStream(readD);
            Object d = writeD.readObject();
            ArrayList<Doctor> listaDoctores = (ArrayList<Doctor>) d;

            for (Doctor b: listaDoctores)
            {
                cBDoctor.addItem(b.getNombreD());
            }
            readD.close();
            writeD.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        btIngresarCita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String observaciones = txtAObservacion.getText();
                String Npaciente = cBPaciente.getName();
            }
        });
    }
    public static void main(String[] args){
        vCrearCitas vCitas = new vCrearCitas();
        vCitas.setContentPane(vCitas.JPcreate);
        vCitas.setSize(500,500);
        vCitas.setTitle("CITAS");
        vCitas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vCitas.setVisible(true);
    }
}
