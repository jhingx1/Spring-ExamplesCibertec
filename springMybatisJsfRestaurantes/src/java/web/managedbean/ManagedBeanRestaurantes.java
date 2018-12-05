package web.managedbean;

import dao.DaoCategorias;
import dao.DaoDistritos;
import dao.DaoRestaurantes;
import dto.Categorias;
import dto.Distritos;
import dto.Restaurantes;

import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "mbRestaurantes")
@RequestScoped
public class ManagedBeanRestaurantes {

    private Restaurantes restaurantes = new Restaurantes();

    private String ids;
    private String message;

    private DaoRestaurantes daoRestaurantes;
    private DaoCategorias daoCategorias;
    private DaoDistritos daoDistritos;

    public void setDaoRestaurantes(DaoRestaurantes daoRestaurantes) {
        this.daoRestaurantes = daoRestaurantes;
    }

    public void setDaoCategorias(DaoCategorias daoCategorias) {
        this.daoCategorias = daoCategorias;
    }

    public void setDaoDistritos(DaoDistritos daoDistritos) {
        this.daoDistritos = daoDistritos;
    }

    public ManagedBeanRestaurantes() {
    }

    // gettter y setter
    public List<Map<Object, Object>> getRestaurantesQry() {
        List<Map<Object, Object>> list
                = daoRestaurantes.restaurantesQry();

        if (list == null) {
            message = daoRestaurantes.getMessage();
        }

        return list;
    }

    public List<Categorias> getCategoriasCbo() {
        List<Categorias> list = daoCategorias.categoriasQry();

        if (list == null) {
            message = daoCategorias.getMessage();
        }

        return list;
    }

    public List<Distritos> getDistritosCbo() {
        List<Distritos> list = daoDistritos.distritosCbo();
        return list;
    }

    public Restaurantes getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(Restaurantes restaurantes) {
        this.restaurantes = restaurantes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    // gestionando
    public String restaurantesIns() {
        message = daoRestaurantes.restaurantesIns(restaurantes);

        if (message == null) {
            return "/index?faces-redirect=true";
        } else {
            restaurantes = new Restaurantes();
            return "/restaurantesIns";
        }
    }

    // gestionando    
    public String restaurantesDel() {
        message = daoRestaurantes.restaurantesDel(ids);

        if (message != null) {
            message = "IDs Incorrectos o no envíados";
        }

        return "/index";
    }

    public String restaurantesGet() {
        restaurantes = daoRestaurantes.restaurantesGet(
                restaurantes.getIdrestaurante());

        if (restaurantes != null) {
            return "/restaurantesUpd";
        } else {
            message = daoRestaurantes.getMessage();
            return "/index";
        }
    }

    public String restaurantesUpd() {
        message = daoRestaurantes.restaurantesUpd(restaurantes);

        if (message == null) {
            restaurantes = new Restaurantes();
            return "/index?faces-redirect=true";
        } else {
            return "/restaurantesUpd";
        }
    }
}
