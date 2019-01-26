package web.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Validateable;

import dao.DaoCategorias;
import dao.DaoDistritos;
import dao.DaoRestaurantes;
import dto.Categorias;
import dto.Distritos;
import dto.Restaurantes;
import parainfo.convert.DeString;

public class ActionRestaurantes
        extends ActionSupport implements Validateable {

 	private static final long serialVersionUID = 1L;
 	
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

    public ActionRestaurantes() {
    }

    public List<Map<Object,Object>> getList() {
        List<Map<Object,Object>> list = daoRestaurantes.restaurantesQry();

        if (list == null) {
            mensaje(daoRestaurantes.getMessage());
        }

        return list;
    }

    public List<Categorias> getCategorias() {
        List<Categorias> list = daoCategorias.categoriasQry();
        return list;
    }

    public List<Distritos> getDistritos() {
        List<Distritos> list = daoDistritos.distritosCbo();
        return list;
    }

    private Restaurantes restaurantes;

    public Restaurantes getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(Restaurantes restaurantes) {
        this.restaurantes = restaurantes;
    }

    // gestion
    public String restaurantesQry() {
        return SUCCESS;
    }

    public String restaurantesIns() {
        restaurantes = new Restaurantes();
        return SUCCESS;
    }

    public String restaurantesIns2() {
        String result = daoRestaurantes.restaurantesIns(restaurantes);

        if (result == null) {
            return SUCCESS;

        } else {
            mensaje(result);
            return ERROR;
        }
    }

    public String restaurantesDel() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String ids = request.getParameter("ids");

        String result = daoRestaurantes.restaurantesDel(ids);

        if (result != null) {
            mensaje(result);
        }

        return SUCCESS;
    }

    public String restaurantesGet() {
        HttpServletRequest request = ServletActionContext.getRequest();
        Integer idrestaurante = 
                DeString.aInteger(request.getParameter("idrestaurante"));

        String result = null;
        if (idrestaurante != null) {
            restaurantes = daoRestaurantes.restaurantesGet(idrestaurante);

            if (restaurantes == null) {
                result = daoRestaurantes.getMessage();
            }
        } else {
            result = "ID Incorrecto";
        }

        if (result == null) {
            return SUCCESS;
        } else {
            mensaje(result);
            return ERROR;
        }
    }

    public String restaurantesUpd() {
        // por persistencia obtener objeto restaurantes
        Restaurantes r = daoRestaurantes.restaurantesGet(
                restaurantes.getIdrestaurante());

        r.setIdcategoria(restaurantes.getIdcategoria());
        r.setRestaurante(restaurantes.getRestaurante());
        r.setDireccion(restaurantes.getDireccion());
        r.setIddistrito(restaurantes.getIddistrito());

        String result = daoRestaurantes.restaurantesUpd(r);

        if (result == null) {
            return SUCCESS;

        } else {
            mensaje(result);
            return ERROR;
        }
    }

    // apoyo
    public void mensaje(String msg) {
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("msg", msg);
    }

    // validaciones
    @Override
    public void validate() {
        if (restaurantes != null) {
            
            if ((restaurantes.getIdcategoria() == null)) {
                addFieldError("restaurantes.idcategoria",
                        "Seleccione Categoría");
            }

            if ((restaurantes.getRestaurante() == null)
                    || (restaurantes.getRestaurante().trim().length() == 0)) {
                addFieldError("restaurantes.restaurante",
                        "Ingrese Restaurante");
            }

            if ((restaurantes.getDireccion()== null)
                    || (restaurantes.getDireccion().trim().length() == 0)) {
                addFieldError("restaurantes.direccion",
                        "Ingrese Dirección de Restaurante");
            }

            if ((restaurantes.getIddistrito() == null)) {
                addFieldError("restaurantes.iddistrito",
                        "Seleccione Distrito");
            }
        }
    }
}

