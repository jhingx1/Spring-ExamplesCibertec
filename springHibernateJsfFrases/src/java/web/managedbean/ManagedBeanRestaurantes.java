package web.managedbean;

import dao.DaoCategorias;
import dao.DaoDistritos;
import dao.DaoRestaurantes;
import hibernate.domain.Categorias;
import hibernate.domain.Distritos;
import hibernate.domain.Restaurantes;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import parainfo.convert.DeString;

@ManagedBean(name = "mbRestaurantes")
@RequestScoped
public class ManagedBeanRestaurantes {
    
    //private Restaurantes restaurantes = new Restaurantes(); reemplazo a todos los de abajo

    private Integer idrestaurante;
    private Integer idcategoria;
    private String restaurante;
    private String direccion;
    private Integer iddistrito;

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
    public List<Object[]> getRestaurantesQry() {
        List<Object[]> list = daoRestaurantes.restaurantesQry();

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

        if (list == null) {
            message = daoDistritos.getMessage();
        }

        return list;
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
        Categorias categorias = daoCategorias.categoriasGet(idcategoria);
        Distritos distritos = daoDistritos.distritosGet(iddistrito);

        Restaurantes restaurantes = new Restaurantes();
        restaurantes.setCategorias(categorias);
        restaurantes.setRestaurante(restaurante);
        restaurantes.setDireccion(direccion);
        restaurantes.setDistritos(distritos);
        
        message = daoRestaurantes.restaurantesIns(restaurantes);

        if (message == null) {
            //cuando se queda pegado(con datos en el momento de insertar) 
            //debemos debemos de crear un objeto nuevo
            restaurante = "";
            direccion = "";
            return "/index?faces-redirect=true";
        } else {            
            return "/restaurantesIns";
        }
    }

    public String restaurantesDel() {
        List<Integer> list_ids = DeString.ids(ids);

        if (list_ids != null) {
            message = daoRestaurantes.restaurantesDel(list_ids);
        } else {
            message = "IDs Incorrectos o no envíados";
        }

        return "/index";
    }

    public String restaurantesGet() {
        Restaurantes restaurantes = 
                daoRestaurantes.restaurantesGet(idrestaurante);
        
        if (restaurantes != null) {
            idrestaurante = restaurantes.getIdrestaurante();
            idcategoria = restaurantes.getCategorias().getIdcategoria();
            restaurante = restaurantes.getRestaurante();
            direccion = restaurantes.getDireccion();
            iddistrito = restaurantes.getDistritos().getIddistrito();
            
            return "/restaurantesUpd";
        } else {
            message = daoRestaurantes.getMessage();
            return "/index";
        }
    }

    public String restaurantesUpd() {
        Categorias categorias = daoCategorias.categoriasGet(idcategoria);
        Distritos distritos = daoDistritos.distritosGet(iddistrito);
        Restaurantes restaurantes = 
                daoRestaurantes.restaurantesGet(idrestaurante);
        
        restaurantes.setCategorias(categorias);
        restaurantes.setRestaurante(restaurante);
        restaurantes.setDireccion(direccion);
        restaurantes.setDistritos(distritos);

        message = daoRestaurantes.restaurantesUpd(restaurantes);

        if (message == null) {
            return "/index?faces-redirect=true";
        } else {
            return "/restaurantesUpd";
        }
    }
}

