package web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Validateable;
import dao.DaoAutores;
import dao.DaoFrases;
import hibernate.domain.Autores;
import hibernate.domain.Frases;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import parainfo.convert.DeString;

public class FrasesAction
        extends ActionSupport implements Validateable {

    private static final long serialVersionUID = 1L;
    private Integer idfrases;
    private String frase;
    private Integer idautor;
    
    
    

    public FrasesAction() {
    }

    private DaoAutores daoAutores;
    private DaoFrases daoFrases;

    public void setDaoAutores(DaoAutores daoAutores) {
        this.daoAutores = daoAutores;
    }

    public void setDaoFrases(DaoFrases daoFrases) {
        this.daoFrases = daoFrases;
    }

    

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public Integer getIdfrases() {
        return idfrases;
    }

    public void setIdfrases(Integer idfrases) {
        this.idfrases = idfrases;
    }

    public Integer getIdautor() {
        return idautor;
    }

    public void setIdautor(Integer idautor) {
        this.idautor = idautor;
    }

    
    
    

    public List<Object[]> getList() {
        List<Object[]> list = daoFrases.frasesQry();

        if (list == null) {
            String msg = daoFrases.getMessage();

            HttpServletRequest request
                    = ServletActionContext.getRequest();
            request.setAttribute("msg", msg);
        }

        return list;
    }

    public List<Autores> getCboAutores() {

        List<Autores> list = daoAutores.autoresQry();
        if (list == null) {
            String msg = daoAutores.getMessage();

            HttpServletRequest request
                    = ServletActionContext.getRequest();
            request.setAttribute("msg", msg);
        }

        return list;
    }

    // gestiona CRUD
    public String frasesQry() {
        return SUCCESS;
    }

    public String frasesIns() {
        Frases frases= new Frases();
        Autores autor= daoAutores.autoresGet(idautor);
        frases.setAutores(autor);
        frases.setFrase(frase);
        
        String result = daoFrases.frasesInsUpd(frases);

        if (result == null) {
            return SUCCESS;
        } else {
            HttpServletRequest request
                    = ServletActionContext.getRequest();
            request.setAttribute("msg", result);
            return ERROR;
        }
    }

    public String frasesDel() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String ids = request.getParameter("ids");
        List<Integer> Listids= new ArrayList();
        Listids=DeString.ids(ids);
        String result = daoFrases.frasesDel(Listids);

        if (result == null) {
            request.getSession().removeAttribute("msg");
            return SUCCESS;
        } else {
            request.getSession().setAttribute("msg", result);
            return ERROR;
        }
    }

    public String frasesGet() {
        HttpServletRequest request = ServletActionContext.getRequest();
        Integer idfrase
                = DeString.aInteger(request.getParameter("idfrase"));

        String result = null;
        if (idfrase != null) {
            Frases frases = daoFrases.frasesGet(idfrase);
            idfrases=frases.getIdfrase();
            frase=frases.getFrase();
            idautor=frases.getAutores().getIdautor();
            if (frases == null) {
                result = daoFrases.getMessage();
            }

        } else {
            result = "ID incorrecto";
        }

        if (result == null) {
            request.getSession().removeAttribute("msg");
            return SUCCESS;
        } else {
            request.getSession().setAttribute("msg", result);
            return ERROR;
        }
    }

    public String frasesUpd() {
        Frases frases=daoFrases.frasesGet(idfrases);
        Autores autor= daoAutores.autoresGet(idautor);
        frases.setAutores(autor);
        frases.setFrase(frase);
        String result = daoFrases.frasesInsUpd(frases);

        if (result == null) {
            return SUCCESS;
        } else {
            HttpServletRequest request
                    = ServletActionContext.getRequest();
            request.setAttribute("msg", result);
            return ERROR;
        }
    }

    // validaciones
    @Override
    public void validate() {
        if (idfrases != null) {
            if (idautor == null) {
                addFieldError("frases.idautor",
                        "Seleccione Autor");
            }

            if (frase== null
                    || frase.trim().length() == 0) {
                addFieldError("frases.frase",
                        "ingrese Frase Célebre");
            }
        }
    }
}

