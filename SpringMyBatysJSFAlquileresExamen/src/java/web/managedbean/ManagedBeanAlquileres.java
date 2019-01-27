package web.managedbean;

import dto.Autos;
import dto.Alquileres;

import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import dao.DaoAutos;
import dao.DaoAlquileres;

@ManagedBean(name = "mbAlquileres")
@RequestScoped
public class ManagedBeanAlquileres {

    private Alquileres alquileres = new Alquileres();

    private String ids;
    private String message;

    private DaoAlquileres daoAlquileres;
    private DaoAutos daoAutos;

    public void setDaoAlquileres(DaoAlquileres daoAlquileres) {
        this.daoAlquileres = daoAlquileres;
    }

    public void setDaoAutos(DaoAutos daoAutos) {
        this.daoAutos = daoAutos;
    }

    public ManagedBeanAlquileres() {
    }

    // gettter y setter
    public List<Map<Object,Object>> getAlquileresQry() {
        List<Map<Object,Object>> list = 
        		daoAlquileres.alquileresQry();

        if (list == null) {
            message = daoAlquileres.getMessage();
        }

        return list;
    }

    public List<Autos> getAutosCbo() {
        List<Autos> list = daoAutos.autosQry();

        if (list == null) {
            message = daoAutos.getMessage();
        }

        return list;
    }


    public Alquileres getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(Alquileres alquileres) {
        this.alquileres = alquileres;
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
    public String alquileresIns() {
        message = daoAlquileres.alquileresIns(alquileres);

        if (message == null) {
            alquileres = new Alquileres();
            return "/index?faces-redirect=true";
        } else {
            return "/alquileresIns";
        }
    }

    public String alquileresDel() {
        message = daoAlquileres.alquileresDel(ids);

        if (message != null) {
            message = "IDs Incorrectos o no envíados";
        }

        return "/index";
    }

    public String alquileresGet() {
        //alquileres = daoAlquileres.alquileresGet(1);
        alquileres = daoAlquileres.alquileresGet(alquileres.getIdalquiler());
        if (alquileres != null) {
            return "/alquileresUpd";
        } else {
            message = daoAlquileres.getMessage();
            return "/index";
        }
    }

    public String alquileresUpd() {
        message = daoAlquileres.alquileresUpd(alquileres);

        if (message == null) {
            alquileres = new Alquileres();
            return "/index?faces-redirect=true";
        } else {
            return "/alquileresUpd";
        }
    }
}

