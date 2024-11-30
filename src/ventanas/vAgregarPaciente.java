package ventanas;

import Metodos.PacienteCRUD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vAgregarPaciente extends JFrame{
    private JPanel panelAP;
    private JPanel jAddPac;
    private JTextField txtUserP;
    private JTextField txtPasswordP;
    private JTextField txtNameP;
    private JTextField txtAPp;
    private JTextField txtAMp;
    private JTextField txtEdadP;
    private JTextField txtDireccionP;
    private JTextField txtTelefonoP;
    private JButton btAddPaciente;
    private JButton btRegresar;

    public vAgregarPaciente() {
        btAddPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String user = txtUserP.getText();
                    String password = txtPasswordP.getText();
                    String name = txtNameP.getText();
                    String pPc = txtAPp.getText();
                    String mPc = txtAMp.getText();
                    Integer edad = Integer.parseInt(txtEdadP.getText());
                    String direccion = txtDireccionP.getText();
                    String telefono = txtTelefonoP.getText();

                    PacienteCRUD pcCr = new PacienteCRUD();

                    int isAdd = pcCr.adPC (user, password, name, pPc,mPc, edad, direccion, telefono);
                    if (isAdd == 1) {
                        JOptionPane.showMessageDialog(jAddPac,"El usuario y contraseña agregados correctamente");

                    }  else if (isAdd == 0){
                        JOptionPane.showMessageDialog(jAddPac,"NO DEJES ESPACIOS EN BLANCO");
                    } else if (isAdd == 2){
                        JOptionPane.showMessageDialog(jAddPac, "El usuario y contraseña no se pudieron agregar");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int answ = JOptionPane.showConfirmDialog(jAddPac,("¿Desea regresar al Inicio de Sesion?" ), "",JOptionPane.YES_OPTION);

                if (answ == 0){
                    dispose();
                    String [] tipousuario = {"inicio"};
                    vInicioSesion.main(tipousuario);
                }
            }
        });
    }

    public static void main(String[] args) {
        vAgregarPaciente vAP = new vAgregarPaciente();
        vAP.setContentPane(vAP.panelAP);
        vAP.setSize(500, 500);
        vAP.setVisible(true);
        vAP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
