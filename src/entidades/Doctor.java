package entidades;

import java.io.Serializable;

public class Doctor implements Serializable{
    private static final long serialVersionUID = 1L; // Para no tener problemas si se actualiza el IntelliJ

    private String userD,passwordD, nombreD,apellidoMD, apellidoPD, especialidadD, rangoD;
    private int idDoctor;

    public Doctor(int idDoctor, String userD, String passwordD, String nombreD, String apellidoPD, String apellidoMD, String especialidadD, String rangoD) {
        this.idDoctor = idDoctor;
        this.userD = userD;
        this.passwordD = passwordD;
        this.nombreD = nombreD;
        this.apellidoPD = apellidoPD;
        this.apellidoMD = apellidoMD;
        this.especialidadD = especialidadD;
        this.rangoD = rangoD;
    }
    public String getNombreD() {
        return nombreD;
    }

    public void setNombreD(String nombreD) {
        this.nombreD = nombreD;
    }

    public String getApellidoMD() {
        return apellidoMD;
    }

    public void setApellidoMD(String apellidoMD) {
        this.apellidoMD = apellidoMD;
    }

    public String getApellidPD() {
        return apellidoPD;
    }

    public void setApellidPD(String apellidPD) {
        this.apellidoPD = apellidPD;
    }

    public String getEspecialidadD() {
        return especialidadD;
    }

    public void setEspecialidadD(String especialidadD) {
        this.especialidadD = especialidadD;
    }

    public String getRangoD() {
        return rangoD;
    }

    public void setRangoD(String rangoD) {
        this.rangoD = rangoD;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getPasswordD() {
        return passwordD;
    }

    public void setPasswordD(String passwordD) {
        this.passwordD = passwordD;
    }

    public String getUserD() {
        return userD;
    }

    public void setUserD(String userD) {
        this.userD = userD;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "idDoctor=" + idDoctor +
                ", userD='" + userD + '\'' +
                ", passwordD='" + passwordD + '\'' +
                ", nombreD='" + nombreD + '\'' +
                ", apellidoPD='" + apellidoPD+ '\'' +
                ", apellidoMD='" + apellidoMD + '\'' +
                ", especialidadD='" + especialidadD + '\'' +
                ", rangoD='" + rangoD + '\'' +
                '}';
    }

}
