package entidades;

import java.io.Serializable;

public class Administrador implements Serializable {
    private static final long serialVersionUID = 1L; // Para no tener problemas si se actualiza el IntelliJ

    private String userAdm, passwordAdm, nombreAdm, apellidoPAdm, apellidoMAdm, rangoAdm;
    private int idAdmin;

    public Administrador(int idAdmin, String userAdm, String passwordAdm, String nombreAdm, String apellidoPAdm, String apellidoMAdm, String rangoAdm) {
        this.idAdmin = idAdmin;
        this.userAdm = userAdm;
        this.passwordAdm = passwordAdm;
        this.nombreAdm = nombreAdm;
        this.apellidoPAdm = apellidoPAdm;
        this.apellidoMAdm = apellidoMAdm;
        this.rangoAdm = rangoAdm;
    }

    public String getNombreAdm() {
        return nombreAdm;
    }

    public void setNombreAdm(String nombreAdm) {
        this.nombreAdm = nombreAdm;
    }

    public String getApellidoPAdm() {
        return apellidoPAdm;
    }

    public void setApellidoPAdm(String apellidoPAdm) {
        this.apellidoPAdm = apellidoPAdm;
    }

    public String getApellidoMAdm() {
        return apellidoMAdm;
    }

    public void setApellidoMAdm(String apellidoMAdm) {
        this.apellidoMAdm = apellidoMAdm;
    }

    public String getRangoAdm() {
        return rangoAdm;
    }

    public void setRangoAdm(String rangoAdm) {
        this.rangoAdm = rangoAdm;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getPasswordAdm() {
        return passwordAdm;
    }

    public void setPasswordAdm(String passwordAdm) {
        this.passwordAdm = passwordAdm;
    }

    public String getUserAdm() {
        return userAdm;
    }

    public void setUserAdm(String userAdm) {
        this.userAdm = userAdm;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "idAdmin=" + idAdmin +
                ", userAdm='" + userAdm + '\'' +
                ", passwordAdm='" + passwordAdm + '\'' +
                ", nombreAdm='" + nombreAdm + '\'' +
                ", apellidoPAdm='" + apellidoPAdm + '\'' +
                ", apellidoMAdm='" + apellidoMAdm + '\'' +
                ", rangoAdm='" + rangoAdm + '\'' +
                '}';
    }
}