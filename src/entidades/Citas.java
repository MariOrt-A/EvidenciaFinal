package entidades;

public class Citas {
    private String fechaC, horaC, observacionC;
    private int idCita;

    public String getObservacionC() {
        return observacionC;
    }

    public void setObservacionC(String observacionC) {
        this.observacionC = observacionC;
    }

    public String getFechaC() {
        return fechaC;
    }

    public void setFechaC(String fechaC) {
        this.fechaC = fechaC;
    }

    public String getHoraC() {
        return horaC;
    }

    public void setHoraC(String horaC) {
        this.horaC = horaC;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Citas(int idCita, String fechaC, String horaC, String observacionC) {
        this.idCita = idCita;
        this.fechaC = fechaC;
        this.horaC = horaC;
    }

}
