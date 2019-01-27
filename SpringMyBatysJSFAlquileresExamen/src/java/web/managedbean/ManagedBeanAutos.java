package web.managedbean;

import dto.Autos;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import dao.DaoAutos;
 
@ManagedBean(name = "mbAutos")
@RequestScoped
public class ManagedBeanAutos {

    private Autos autos = new Autos();

    private String ids;
    private String message;

    private DaoAutos daoAutos;

    public void setDaoAutos(DaoAutos daoAutos) {
        this.daoAutos = daoAutos;
    }

    public ManagedBeanAutos() {
    }

    public List<Autos> getAutosQry() {
        List<Autos> list = daoAutos.autosQry();

        if (list == null) {
            message = daoAutos.getMessage();
        }

        return list;
    }

    public Autos getAutos() {
        return autos;
    }

    public void setAutos(Autos autos) {
        this.autos = autos;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getMessage() {
        return message;
    }

    public String autosIns() {
        message = daoAutos.autosIns(autos);

        if (message == null) {
            autos = new Autos();
            return "/autosQry?faces-redirect=true";
        } else {
            return "/autosIns";
        }
    }

    public String autosDel() {
        message = daoAutos.autosDel(ids);

        if (message != null) {
            message = "IDs Incorrectos o no envíados";
        }

        return "/autosQry";
    }

    public String autosGet() {
        autos = daoAutos.autosGet(
                autos.getIdauto());

        if (autos != null) {
            return "/autosUpd";
        } else {
            message = daoAutos.getMessage();
            return "/autosQry";
        }
    }

    public String autosUpd() {
        message = daoAutos.autosUpd(autos);

        if (message == null) {
            autos = new Autos();
            return "/autosQry?faces-redirect=true";
        } else {

            return "/autosUpd";
        }
    }
}

