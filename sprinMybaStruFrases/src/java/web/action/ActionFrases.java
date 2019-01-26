package web.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Validateable;

import dao.DaoAutores;
import dao.DaoDistritos;
import dao.DaoFrases;
import dto.Autores;
import dto.Distritos;
import dto.Frases;
import parainfo.convert.DeString;

public class ActionFrases
        extends ActionSupport implements Validateable {

    private static final long serialVersionUID = 1L;

    private DaoFrases daoFrases;
    private DaoAutores daoAutores;

    public void setDaoFrases(DaoFrases daoFrases) {
        this.daoFrases = daoFrases;
    }

    public void setDaoAutores(DaoAutores daoAutores) {
        this.daoAutores = daoAutores;
    }

    public ActionFrases() {
    }

    public List<Map<Object, Object>> getList() {
        List<Map<Object, Object>> list = daoFrases.frasesQry();

        if (list == null) {
            mensaje(daoFrases.getMessage());
        }

        return list;
    }

    public List<Autores> getAutores() {
        List<Autores> list = daoAutores.autoresQry();
        return list;
    }

    private Frases frases;

    public Frases getFrases() {
        return frases;
    }

    public void setFrases(Frases frases) {
        this.frases = frases;
    }

    // gestion
    public String frasesQry() {
        return SUCCESS;
    }

    public String frasesIns() {
        frases = new Frases();
        return SUCCESS;
    }

    public String frasesIns2() {
        String result = daoFrases.frasesIns(frases);

        if (result == null) {
            return SUCCESS;

        } else {
            mensaje(result);
            return ERROR;
        }
    }

    public String frasesDel() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String ids = request.getParameter("ids");

        String result = daoFrases.frasesDel(ids);

        if (result != null) {
            mensaje(result);
        }

        return SUCCESS;
    }

    public String frasesGet() {
        HttpServletRequest request = ServletActionContext.getRequest();
        Integer idfrase
                = DeString.aInteger(request.getParameter("idfrase"));

        String result = null;
        if (idfrase != null) {
            frases = daoFrases.frasesGet(idfrase);

            if (frases == null) {
                result = daoFrases.getMessage();
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

    public String frasesUpd() {
        // por persistencia obtener objeto frases
        Frases r = daoFrases.frasesGet(
                frases.getIdfrase());
        
        r.setIdfrase(frases.getIdfrase());
        r.setIdautor(frases.getIdautor());
        r.setFrase(frases.getFrase());        
        
        String result = daoFrases.frasesUpd(r);

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
        if (frases != null) {

            if ((frases.getIdautor() == null)) {
                addFieldError("frases.idautor",
                        "Seleccione Categoría");
            }

            if ((frases.getFrase() == null)
                    || (frases.getFrase().trim().length() == 0)) {
                addFieldError("frases.frase",
                        "Ingrese Frase");
            }            
        }
    }
}
