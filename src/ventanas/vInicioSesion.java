package ventanas;

import Metodos.Metodos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class vInicioSesion extends JFrame{
    private JPanel miventana;
    private JPanel InicioSesion;
    private JTextField txtIniciosesion;
    private JTextField txtContrasena;
    private JButton inicioSesBT;
    private JButton cerrarV;
    private JButton btNPaciente;
    private JButton addBt;


    public vInicioSesion() {
        inicioSesBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String user = txtIniciosesion.getText();
                    String password = txtContrasena.getText();

                    Metodos metodo = new Metodos();

                    int isthere = metodo.ishere (user, password);
                    if (isthere == 0) {
                        JOptionPane.showMessageDialog(InicioSesion,"Valio y nose donde");

                    } else if (isthere == 1){
                        dispose();
                        String [] tipousuario = {"admin"};
                        vVentanasAdmin.main(tipousuario);
                    } else if (isthere == 2) {
                        dispose();
                        String [] tipousuario = {"doctor"};
                        //vVentanasAdmin.main(tipousuario);
                    } else if (isthere == 3) {
                        dispose();
                        String [] tipousuario = {"paciente"};
                        vCrearCitas.main(tipousuario);
                    }
                } catch (Exception ex) {
                    System.out.println("Fallo 3 en " + ex);
                }
            }
        });
        btNPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                String [] tipousuario = {"AgregarPaciente"};
                vAgregarPaciente.main(tipousuario);
            }
        });
        cerrarV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        vInicioSesion v = new vInicioSesion();
        v.setContentPane(v.miventana);
        v.setSize(500, 500);
        v.setVisible(true);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}

//C:\Users\almar\Desktop\Escuela\Java\BDProyectoFinal  Direccion de las bases de datos



