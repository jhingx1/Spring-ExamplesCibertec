package hibernate.domain;

public class Restaurantes implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

    private Integer idrestaurante;
    private Categorias categorias;
    private Distritos distritos;
    private String restaurante;
    private String direccion;

    public Restaurantes() {
    }

    public Restaurantes(Categorias categorias, Distritos distritos, 
    		String restaurante, String direccion) {
        this.categorias = categorias;
        this.distritos = distritos;
        this.restaurante = restaurante;
        this.direccion = direccion;
    }

    public Integer getIdrestaurante() {
        return this.idrestaurante;
    }

    public void setIdrestaurante(Integer idrestaurante) {
        this.idrestaurante = idrestaurante;
    }

    public Categorias getCategorias() {
        return this.categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    public Distritos getDistritos() {
        return this.distritos;
    }

    public void setDistritos(Distritos distritos) {
        this.distritos = distritos;
    }

    public String getRestaurante() {
        return this.restaurante;
    }

    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

