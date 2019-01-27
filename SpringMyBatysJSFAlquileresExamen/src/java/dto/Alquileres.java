package dto;
import java.util.Date;

public class Alquileres {

    private Integer idalquiler;

    private Integer idauto;

    private Date alquiler_ini;

    private Date alquiler_fin;

    private String cliente;

    private String dni;

    public Alquileres() {
    }
    
    
    

    public Integer getIdalquiler() {
        return idalquiler;
    }

    public void setIdalquiler(Integer idalquiler) {
        this.idalquiler = idalquiler;
    }

    public Integer getIdauto() {
        return idauto;
    }

    public void setIdauto(Integer idauto) {
        this.idauto = idauto;
    }

    public Date getAlquiler_ini() {
        return alquiler_ini;
    }

    public void setAlquiler_ini(Date alquiler_ini) {
        this.alquiler_ini = alquiler_ini;
    }

    public Date getAlquiler_fin() {
        return alquiler_fin;
    }

    public void setAlquiler_fin(Date alquiler_fin) {
        this.alquiler_fin = alquiler_fin;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
