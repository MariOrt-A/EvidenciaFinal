package entidades;

import java.io.Serializable;

public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L; // Para no tener problemas si se actualiza el IntelliJ

    private String usuarioP,passwordP, nombreP, apellidoPP, apellidoMP, direccionP, telefonoP, rangoP;
    private int idPaciente, edadP;

    public Paciente(int idPaciente, int edadP,String usuarioP, String passwordP, String nombreP, String apellidoPP, String apellidoMP, String direccionP, String telefonoP, String rangoP) {
        this.idPaciente = idPaciente;
        this.usuarioP = usuarioP;
        this.passwordP = passwordP;
        this.nombreP = nombreP;
        this.apellidoPP = apellidoPP;
        this.apellidoMP = apellidoMP;
        this.edadP = edadP;
        this.direccionP = direccionP;
        this.telefonoP = telefonoP;
        this.rangoP = rangoP;
    }

    public String getPasswordP() {
        return passwordP;
    }

    public void setPasswordP(String passwordP) {
        this.passwordP = passwordP;
    }

    public String getUsuarioP() {
        return usuarioP;
    }

    public void setUsuarioP(String usuarioP) {
        this.usuarioP = usuarioP;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getApellidoPP() {
        return apellidoPP;
    }

    public void setApellidoPP(String apellidoPP) {
        this.apellidoPP = apellidoPP;
    }

    public String getApellidoMP() {
        return apellidoMP;
    }

    public void setApellidoMP(String apellidoMP) {
        this.apellidoMP = apellidoMP;
    }

    public String getDireccionP() {
        return direccionP;
    }

    public void setDireccionP(String direccionP) {
        this.direccionP = direccionP;
    }

    public String getTelefonoP() {
        return telefonoP;
    }

    public void setTelefonoP(String telefonoP) {
        this.telefonoP = telefonoP;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getRangoP() {
        return rangoP;
    }

    public void setRangoP(String rangoP) {
        this.rangoP = rangoP;
    }

    public int getEdadP() {
        return edadP;
    }

    public void setEdadP(int edadP) {
        this.edadP = edadP;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "idPaciente=" + idPaciente +
                ", usuarioP='" + usuarioP + '\'' +
                ", passwordP='" + passwordP + '\'' +
                ", nombreP='" + nombreP + '\'' +
                ", apellidoPP='" + apellidoPP+ '\'' +
                ", apellidoMP='" + apellidoMP + '\'' +
                ", edad='" + edadP + '\'' +
                ", direccionP='" + direccionP + '\'' +
                ", telefonoP='" + telefonoP + '\'' +
                ", rangoP='" + rangoP + '\'' +
                '}';
    }

}
