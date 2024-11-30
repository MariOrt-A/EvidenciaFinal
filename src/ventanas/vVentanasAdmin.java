package ventanas;

import Metodos.AdminCRUD;
import Metodos.DoctorCRUD;
import Metodos.PacienteCRUD;
import entidades.Administrador;
import entidades.Doctor;
import entidades.Paciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vVentanasAdmin extends JFrame {
    private JPanel JPprincipal;
    private JTabbedPane tabbedPane1;
    private JPanel jAddAdmin;
    private JTextField txtUsuarioAD;
    private JTextField txtRangoAD;
    private JTextField txtPasswordAD;
    private JTextField txtNombreAD;
    private JTextField txtPAdm;
    private JTextField txtMAdm;
    private JTextField txtIdAdm;
    private JButton btBuscarAD;
    private JButton btAgregarAD;
    private JPanel jAddDoc;
    private JTextField txtUserD;
    private JTextField txtPasswordD;
    private JTextField txtNameD;
    private JTextField txtAPD;
    private JTextField txtAMD;
    private JTextField txtEspecialidad;
    private JTextField txtRangoD;
    private JPanel JPBtns;
    private JButton btAgregarD;
    private JButton btBuscarD;
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
    private JPanel vVENTANAS;
    private JButton btBUSCARP;
    private JButton btDeleteAD;
    private JButton btGuardarAD;
    private JButton btDeleteD;
    private JButton btGuardarD;
    private JTextField txtIdDoc;
    private JButton btDeleteP;
    private JButton btGuardarP;
    private JTextField txtIdP;

    public vVentanasAdmin() {
        //AGREGAR ADMINISTRADOR
        btAgregarAD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String userAD = txtUsuarioAD.getText();
                    String passwordAD = txtPasswordAD.getText();
                    String nameAD = txtNombreAD.getText();
                    String pAd = txtPAdm.getText();
                    String mAd = txtMAdm.getText();
                    String rangeAD = txtRangoAD.getText();


                    AdminCRUD adCr = new AdminCRUD();
                    int isAdd = adCr.adAdmin (userAD, passwordAD, nameAD, pAd,mAd,rangeAD);
                    if (isAdd == 1) {
                        JOptionPane.showMessageDialog(jAddAdmin,"El usuario y contraseña agregados correctamente");

                    } else if (isAdd == 0){
                        JOptionPane.showMessageDialog(jAddAdmin,"El usuario y contraseña no se pudieron agregar");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        //AGREGAR DOCTOR
        btAgregarD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String userD = txtUserD.getText();
                    String passwordD = txtPasswordD.getText();
                    String nameD = txtNameD.getText();
                    String pDc = txtAPD.getText();
                    String mDc = txtAMD.getText();
                    String especialidad = txtEspecialidad.getText();
                    String rangoD = txtRangoD.getText();

                    DoctorCRUD dcCr = new DoctorCRUD();
                    //##### CAMBIAR BOOLEAN POR INT Y AGREGAR UN SWITCH CASE
                    int isAdd = dcCr.adDoc (userD, passwordD, nameD, pDc,mDc,especialidad,rangoD);
                    if (isAdd == 1) {
                        JOptionPane.showMessageDialog(jAddDoc,"El usuario y contraseña agregados correctamente");

                    } else if (isAdd == 0){
                        JOptionPane.showMessageDialog(jAddDoc,"NO PUEDE HABER CAMPOS VACIOS");
                    }
                    else if (isAdd == 2){
                        JOptionPane.showMessageDialog(jAddDoc, "El usuario y contraseña no se pudieron agregar");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        //AGREGAR PACIENTE
        btAddPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String userP = txtUserP.getText();
                    String passwordP = txtPasswordP.getText();
                    String nameP = txtNameP.getText();
                    String pPc = txtAPp.getText();
                    String mPc = txtAMp.getText();
                    Integer edad = Integer.parseInt(txtEdadP.getText());
                    String direccion = txtDireccionP.getText();
                    String telefono = txtTelefonoP.getText();

                    PacienteCRUD pcCr = new PacienteCRUD();

                    int isAdd = pcCr.adPC (userP, passwordP, nameP, pPc,mPc, edad, direccion, telefono);
                    if (isAdd == 1) {
                        JOptionPane.showMessageDialog(jAddPac,"El usuario y contraseña agregados correctamente");

                    } else if (isAdd == 0){
                        JOptionPane.showMessageDialog(jAddPac,"NO DEJES ESPACIOS EN BLANCO");
                    } else if (isAdd == 2){
                        JOptionPane.showMessageDialog(jAddDoc, "El usuario y contraseña no se pudieron agregar");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        //BUSQUEDA DE ADMIN
        btBuscarAD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminCRUD Adcrud = new AdminCRUD();
                int idAD = Integer.parseInt(txtIdAdm.getText());
                Administrador a = Adcrud.buscarAdmin(idAD);

                if (a == null){
                    int answ = JOptionPane.showConfirmDialog(JPprincipal,("No existe ese Administrador" + "¿Desea ingresarlo?" ), "Administardor",JOptionPane.YES_OPTION);
                    if (answ == 0){
                        //DAR de ALTA
                        btAgregarAD.setEnabled(true);
                        btDeleteD.setEnabled(false);
                        btGuardarAD.setEnabled(false);
                    } else if (answ == 1) {
                        //No DAR de ALTA

                    }else{
                        btDeleteAD.setEnabled(false);
                        btGuardarAD.setEnabled(false);
                        btAgregarAD.setEnabled(false);
                    }

                }else{
                    txtNombreAD.setText(a.getNombreAdm());
                    txtUsuarioAD.setText(a.getUserAdm());
                    txtRangoAD.setText(a.getRangoAdm());
                    txtMAdm.setText(a.getApellidoMAdm());
                    txtPAdm.setText(a.getApellidoPAdm());

                    btGuardarAD.setEnabled(true);
                    btDeleteAD.setEnabled(true);
                }
            }
        });
        //BUSCAR DOCTORES
        btBuscarD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoctorCRUD Doccrud = new DoctorCRUD();
                int idDoc = Integer.parseInt(txtIdDoc.getText());
                Doctor a = Doccrud.buscarDoc(idDoc);

                if (a == null){
                    int answ = JOptionPane.showConfirmDialog(JPprincipal,("No existe ese Doctor" + "¿Desea ingresarlo?" ), "Administardor",JOptionPane.YES_OPTION);
                    if (answ == 0){
                        //DAR de ALTA
                        btAgregarD.setEnabled(true);
                        btDeleteD.setEnabled(false);
                        btGuardarD.setEnabled(false);
                    } else if (answ == 1) {
                        //No DAR de ALTA

                    }else{
                        btDeleteD.setEnabled(false);
                        btGuardarD.setEnabled(false);
                        btAgregarD.setEnabled(false);
                    }

                }else{
                    txtNameD.setText(a.getNombreD());
                    txtUserD.setText(a.getUserD());
                    txtRangoD.setText(a.getRangoD());
                    txtAMD.setText(a.getApellidoMD());
                    txtAPD.setText(a.getApellidPD());
                    txtEspecialidad.setText(a.getEspecialidadD());

                    btGuardarD.setEnabled(true);
                    btDeleteD.setEnabled(true);
                }
            }
        });

        //BUSCAR PACIENTES POR ID
        btBUSCARP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PacienteCRUD Paccrud = new PacienteCRUD();
                int idPac = Integer.parseInt(txtIdP.getText());
                Paciente a = Paccrud.buscarPaciente(idPac);

                if (a == null){
                    int answ = JOptionPane.showConfirmDialog(JPprincipal,("No existe ese Paciente" + "¿Desea ingresarlo?" ), "Administardor",JOptionPane.YES_OPTION);
                    if (answ == 0){
                        //DAR de ALTA
                        txtIdP.setText("");
                        btAddPaciente.setEnabled(true);
                        btDeleteP.setEnabled(false);
                        btGuardarP.setEnabled(false);

                        txtNameP.setText("");
                        txtUserP.setText("");
                        txtDireccionP.setText("");
                        txtAMp.setText("");
                        txtAPp.setText("");
                        txtEdadP.setText("");
                        txtTelefonoP.setText("");
                    } else if (answ == 1) {
                        //No DAR de ALTA

                    }else{
                        btDeleteP.setEnabled(false);
                        btGuardarP.setEnabled(false);
                        btAddPaciente.setEnabled(false);
                    }

                }else{
                    txtNameP.setText(a.getNombreP());
                    txtUserP.setText(a.getUsuarioP());
                    txtDireccionP.setText(a.getDireccionP());
                    txtAMp.setText(a.getApellidoMP());
                    txtAPp.setText(a.getApellidoPP());
                    txtEdadP.setText(String.valueOf(a.getEdadP()));
                    txtTelefonoP.setText(a.getTelefonoP());

                    btGuardarP.setEnabled(true);
                    btDeleteP.setEnabled(true);
                }
            }
        });

        //ELIMINAR ADMINS
    }

    public static void main(String[] args) {
        vVentanasAdmin vAd = new vVentanasAdmin();
        vAd.setContentPane(vAd.vVENTANAS);
        vAd.setSize(500, 500);
        vAd.setVisible(true);
        vAd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
