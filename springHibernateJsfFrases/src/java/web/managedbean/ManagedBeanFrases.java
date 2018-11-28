package web.managedbean;

import dao.DaoAutores;
import dao.DaoDistritos;
import dao.DaoFrases;
import hibernate.domain.Autores;
import hibernate.domain.Distritos;
import hibernate.domain.Frases;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import parainfo.convert.DeString;

@ManagedBean(name = "mbFrases")
@RequestScoped
public class ManagedBeanFrases {
    
    //private Frases frases = new Frases(); reemplazo a todos los de abajo

    private Integer idfrase;
    private Integer idautor;
    private String frase;    

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
    public List<Object[]> getFrasesQry() {
        List<Object[]> list = daoFrases.frasesQry();

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

    public Integer getIdfrase() {
        return idfrase;
    }

    public void setIdfrase(Integer idfrase) {
        this.idfrase = idfrase;
    }

    public Integer getIdautor() {
        return idautor;
    }

    public void setIdautor(Integer idautor) {
        this.idautor = idautor;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
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
        Autores autores = daoAutores.autoresGet(idautor);        

        Frases frases = new Frases();
        frases.setAutores(autores);
        frases.setFrase(frase);        
        
        message = daoFrases.frasesIns(frases);

        if (message == null) {
            //cuando se queda pegado(con datos en el momento de insertar) 
            //debemos debemos de crear un objeto nuevo
            frase = "";            
            return "/index?faces-redirect=true";
        } else {            
            return "/frasesIns";
        }
    }

    public String frasesDel() {
        List<Integer> list_ids = DeString.ids(ids);

        if (list_ids != null) {
            message = daoFrases.frasesDel(list_ids);
        } else {
            message = "IDs Incorrectos o no envíados";
        }

        return "/index";
    }

    public String frasesGet() {
        Frases frases = 
                daoFrases.frasesGet(idfrase);
        
        if (frases != null) {
            idfrase = frases.getIdfrase();
            idautor = frases.getAutores().getIdautor();
            frase = frases.getFrase();            
            
            return "/frasesUpd";
        } else {
            message = daoFrases.getMessage();
            return "/index";
        }
    }

    public String frasesUpd() {
        Autores autores = daoAutores.autoresGet(idautor);        
        Frases frases = 
                daoFrases.frasesGet(idfrase);
        
        frases.setAutores(autores);
        frases.setFrase(frase);       

        message = daoFrases.frasesUpd(frases);

        if (message == null) {
            return "/index?faces-redirect=true";
        } else {
            return "/frasesUpd";
        }
    }
}

