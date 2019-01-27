package web.managedbean;

import dao.DaoAutores;
import dao.DaoDistritos;
import dao.DaoFrases;
import dto.Autores;
import dto.Distritos;
import dto.Frases;

import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "mbFrases")
@RequestScoped
public class ManagedBeanFrases {

    private Frases frases = new Frases();

    private String ids;
    private String message;

    private DaoFrases daoFrases;
    private DaoAutores daoAutores;

    public void setDaoFrases(DaoFrases daoFrases) {
        this.daoFrases = daoFrases;
    }

    public void setDaoAutores(DaoAutores daoAutores) {
        this.daoAutores = daoAutores;
    }  

    public ManagedBeanFrases() {
    }

    // gettter y setter
    public List<Map<Object,Object>> getFrasesQry() {
        List<Map<Object,Object>> list = 
        		daoFrases.frasesQry();

        if (list == null) {
            message = daoFrases.getMessage();
        }

        return list;
    }

    public List<Autores> getAutoresCbo() {
        List<Autores> list = daoAutores.autoresQry();

        if (list == null) {
            message = daoAutores.getMessage();
        }

        return list;
    }
    
    public Frases getFrases() {
        return frases;
    }

    public void setFrases(Frases frases) {
        this.frases = frases;
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
    public String frasesIns() {
        message = daoFrases.frasesIns(frases);

        if (message == null) {
            frases = new Frases();
            return "/index?faces-redirect=true";
        } else {
            return "/frasesIns";
        }
    }

    public String frasesDel() {
        message = daoFrases.frasesDel(ids);

        if (message != null) {
            message = "IDs Incorrectos o no envíados";
        }

        return "/index";
    }

    public String frasesGet() {
        frases = daoFrases.frasesGet(
                frases.getIdfrase());

        if (frases != null) {
            return "/frasesUpd";
        } else {
            message = daoFrases.getMessage();
            return "/index";
        }
    }

    public String frasesUpd() {
        message = daoFrases.frasesUpd(frases);

        if (message == null) {
            frases = new Frases();
            return "/index?faces-redirect=true";
        } else {
            return "/frasesUpd";
        }
    }
}

