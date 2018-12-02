package hibernate.domain;

import java.util.HashSet;
import java.util.Set;

public class Categorias implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idcategoria;
    private String categoria;
    private Set<Restaurantes> restauranteses = new HashSet<Restaurantes>();  //el enlace con la tabla principal

    public Categorias() {
    }

    public Categorias(String categoria) {
        this.categoria = categoria;
    }

    public Categorias(String categoria, Set<Restaurantes> restauranteses) {
        this.categoria = categoria;
        this.restauranteses = restauranteses;
    }

    public Integer getIdcategoria() {
        return this.idcategoria;
    }

    public void setIdcategoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Set<Restaurantes> getRestauranteses() {
        return this.restauranteses;
    }

    public void setRestauranteses(Set<Restaurantes> restauranteses) {
        this.restauranteses = restauranteses;
    }
}
