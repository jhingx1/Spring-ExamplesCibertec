package hibernate.domain;

import java.util.HashSet;
import java.util.Set;

public class Distritos implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

    private Integer iddistrito;
    private String distrito;
    private Set<Restaurantes> restauranteses = new HashSet<Restaurantes>();

    public Distritos() {
    }

    public Distritos(String distrito) {
        this.distrito = distrito;
    }

    public Distritos(String distrito, Set<Restaurantes> restauranteses) {
        this.distrito = distrito;
        this.restauranteses = restauranteses;
    }

    public Integer getIddistrito() {
        return this.iddistrito;
    }

    public void setIddistrito(Integer iddistrito) {
        this.iddistrito = iddistrito;
    }

    public String getDistrito() {
        return this.distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Set<Restaurantes> getRestauranteses() {
        return this.restauranteses;
    }

    public void setRestauranteses(Set<Restaurantes> restauranteses) {
        this.restauranteses = restauranteses;
    }
}


