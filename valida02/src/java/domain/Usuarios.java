package domain;

public class Usuarios {

    private String nombre;
    private String genero;//es un combo debido a que solo se va a elegir uno.
    private String pais;
    private String acerca;
    private String[] comunidad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAcerca() {
        return acerca;
    }

    public void setAcerca(String acerca) {
        this.acerca = acerca;
    }

    public String[] getComunidad() {
        return comunidad;
    }

    public void setComunidad(String[] comunidad) {
        this.comunidad = comunidad;
    }
    
}
