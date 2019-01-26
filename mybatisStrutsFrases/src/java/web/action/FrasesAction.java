package web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Validateable;
import dao.DaoAutores;
import dao.DaoFrases;
import dao.impl.DaoAutoresImpl;
import dao.impl.DaoFrasesImpl;
import dto.Autores;
import dto.Frases;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import parainfo.convert.DeString;

public class FrasesAction
        extends ActionSupport implements Validateable {

    private static final long serialVersionUID = 1L;
    
	private Frases frases;

    public FrasesAction() {
    }

    // getter y setter
    public Frases getFrases() {
        return frases;
    }

    public void setFrases(Frases frases) {
        this.frases = frases;
    }

    public List<Map<Object,Object>> getList() {
        DaoFrases daoFrases = new DaoFrasesImpl();
        List<Map<Object,Object>> list = daoFrases.frasesQry();

        if (list == null) {
            String msg = daoFrases.getMessage();

            HttpServletRequest request
                    = ServletActionContext.getRequest();
            request.setAttribute("msg", msg);
        }

        return list;
    }

    public List<Autores> getCboAutores() {
        DaoAutores daoAutores = new DaoAutoresImpl();

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
        DaoFrases daoFrases = new DaoFrasesImpl();
        String result = daoFrases.frasesIns(frases);

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

        DaoFrases daoFrases = new DaoFrasesImpl();
        String result = daoFrases.frasesDel(ids);

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
            DaoFrases daoFrases = new DaoFrasesImpl();
            frases = daoFrases.frasesGet(idfrase);

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
        DaoFrases daoFrases = new DaoFrasesImpl();
        String result = daoFrases.frasesUpd(frases);

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
        if (frases != null) {
            if ((frases.getIdautor() == null)) {
                addFieldError("frases.idautor",
                        "Seleccione Autor");
            }

            if ((frases.getFrase() == null)
                    || (frases.getFrase().trim().length() == 0)) {
                addFieldError("frases.frase",
                        "ingrese Frase Célebre");
            }
        }
    }
}

