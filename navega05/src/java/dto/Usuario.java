package dto;
//Clase que tiene todos los datos del formulario
public class Usuario {

    private String nombre;
    private String password;
    private String genero;
    private String pais;
    private String comentario;
    //Se define como una arreglo de String debido a que vamos a seleccionar varios en el formulario.
    private String[] comunidad;

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String[] getComunidad() {
        return comunidad;
    }

    public void setComunidad(String[] comunidad) {
        this.comunidad = comunidad;
    }
    
}
