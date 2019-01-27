package dto;

public class Restaurantes {

    private Integer idrestaurante;
    private Integer idcategoria;
    private String restaurante;
    private String direccion;
    private Integer iddistrito;

    public Restaurantes() {
    }

    public Integer getIdrestaurante() {
        return idrestaurante;
    }

    public void setIdrestaurante(Integer idrestaurante) {
        this.idrestaurante = idrestaurante;
    }

    public Integer getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getIddistrito() {
        return iddistrito;
    }

    public void setIddistrito(Integer iddistrito) {
        this.iddistrito = iddistrito;
    }
}

