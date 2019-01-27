package web.managedbean;

import dao.DaoAutores;
import dto.Autores;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
 
@ManagedBean(name = "mbAutores")
@RequestScoped
public class ManagedBeanAutores {

    private Autores autores = new Autores();

    private String ids;
    private String message;

    private DaoAutores daoAutores;

    public void setDaoAutores(DaoAutores daoAutores) {
        this.daoAutores = daoAutores;
    }

    public ManagedBeanAutores() {
    }

    public List<Autores> getAutoresQry() {
        List<Autores> list = daoAutores.autoresQry();

        if (list == null) {
            message = daoAutores.getMessage();
        }

        return list;
    }

    public Autores getAutores() {
        return autores;
    }

    public void setAutores(Autores autores) {
        this.autores = autores;
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

    public String autoresIns() {
        //Autores autores = new Autores();
        //autores.setAutor(autores.getAutor());
        message = daoAutores.autoresIns(autores);

        if (message == null) {
            autores = new Autores();
            return "/autoresQry?faces-redirect=true";
        } else {
            return "/autoresIns";
        }
    }

    public String autoresDel() {
        message = daoAutores.autoresDel(ids);

        if (message != null) {
            message = "IDs Incorrectos o no envíados";
        }

        return "/autoresQry";
    }

    public String autoresGet() {
        autores = daoAutores.autoresGet(
                autores.getIdautor());

        if (autores != null) {
            return "/autoresUpd";
        } else {
            message = daoAutores.getMessage();
            return "/autoresQry";
        }
    }

    public String autoresUpd() {
        message = daoAutores.autoresUpd(autores);

        if (message == null) {
            autores = new Autores();
            return "/autoresQry?faces-redirect=true";
        } else {
            return "/autoresUpd";
        }
    }
}

