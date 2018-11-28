package web.managedbean;

import dao.DaoAutores;
import hibernate.domain.Autores;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import parainfo.convert.DeString;

@ManagedBean(name = "mbAutores")
@RequestScoped
public class ManagedBeanAutor {

    private Integer idautor;
    private String autor;

    private String ids;
    private String message;

    private DaoAutores daoAutores;

    public void setDaoAutores(DaoAutores daoAutores) {
        this.daoAutores = daoAutores;
    }

    public ManagedBeanAutor() {
    }

    public List<Autores> getAutoresQry() {
        List<Autores> list = daoAutores.autoresQry();

        if (list == null) {
            message = daoAutores.getMessage();
        }

        return list;
    }

    public Integer getIdautor() {
        return idautor;
    }

    public void setIdautor(Integer idautor) {
        this.idautor = idautor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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
        Autores autores = new Autores();
        autores.setAutor(autor);

        message = daoAutores.autoresIns(autores);

        if (message == null) {
            return "/autoresQry?faces-redirect=true";
        } else {
            return "/autoresIns";
        }
    }

    public String autoresDel() {
        List<Integer> list_ids = DeString.ids(ids);

        if (list_ids != null) {
            message = daoAutores.autoresDel(list_ids);
        } else {
            message = "IDs Incorrectos o no envíados";
        }

        return "/autoresQry";
    }

    public String autoresGet() {
        Autores autores
                = daoAutores.autoresGet(idautor);

        if (autores != null) {
            idautor = autores.getIdautor();
            autor = autores.getAutor();

            return "/autoresUpd";
        } else {
            message = daoAutores.getMessage();
            return "/autoresQry";
        }
    }

    public String autoresUpd() {
        Autores autores = daoAutores.autoresGet(idautor);
        autores.setAutor(autor);

        message = daoAutores.autoresUpd(autores);

        if (message == null) {
            return "/autoresQry?faces-redirect=true";
        } else {
            return "/autoresUpd";
        }
    }
}

