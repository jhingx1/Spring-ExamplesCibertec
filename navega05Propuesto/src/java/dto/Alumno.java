package dto;

public class Alumno {
    
    private String nombreAlumno;
    private String curso;
    private String turno;
    private String local;
    private String[] formaPago;
    private Integer totalPago;

    public Alumno() {
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String[] getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String[] formaPago) {
        this.formaPago = formaPago;
    }

    public Integer getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(Integer totalPago) {
        this.totalPago = totalPago;
    }
        
}
