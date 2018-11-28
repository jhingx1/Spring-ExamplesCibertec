package web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Validateable;
import dao.DaoAutores;
import dao.impl.DaoAutoresImpl;
import hibernate.domain.Autores;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import parainfo.convert.DeString;

public class AutoresAction
        extends ActionSupport implements Validateable {

    private static final long serialVersionUID = 1L;

    private Autores autores;
    
    private DaoAutores daoAutores;

    public void setDaoAutores(DaoAutores daoAutores) {
        this.daoAutores = daoAutores;
    }
    
    

    public AutoresAction() {
    }

    // getter y setter
    public Autores getAutores() {
        return autores;
    }

    public void setAutores(Autores autores) {
        this.autores = autores;
    }

    public List<Autores> getList() {

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
    public String autoresQry() {
        return SUCCESS;
    }

    public String autoresIns() {
        String result = daoAutores.autoresInsUpd(autores);

        if (result == null) {
            return SUCCESS;
        } else {
            HttpServletRequest request
                    = ServletActionContext.getRequest();
            request.setAttribute("msg", result);
            return ERROR;
        }
    }

    public String autoresDel() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String ids = request.getParameter("ids");
        List<Integer> Listids= new ArrayList();
        Listids=DeString.ids(ids);
        String result= daoAutores.autoresDel(Listids);
        if (result == null) {
            request.getSession().removeAttribute("msg");
            return SUCCESS;
        } else {
            request.getSession().setAttribute("msg", result);
            return ERROR;
        }
    }

    public String autoresGet() {
        HttpServletRequest request = ServletActionContext.getRequest();
        Integer idautor
                = DeString.aInteger(request.getParameter("idautor"));

        String result = null;
        if (idautor != null) {
            autores = daoAutores.autoresGet(idautor);

            if (autores == null) {
                result = daoAutores.getMessage();
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

    public String autoresUpd() {

        String result = daoAutores.autoresInsUpd(autores);

        if (result != null) {
            HttpServletRequest request
                    = ServletActionContext.getRequest();
            request.setAttribute("msg", result);
            return ERROR;
        } else {
            return SUCCESS;
        }
    }

    // validaciones
    @Override
    public void validate() {
        if (autores != null) {
            if ((autores.getAutor() == null)
                    || (autores.getAutor().trim().length() == 0)) {
                addFieldError("autores.autor",
                        "Ingrese nombre de Autor");
            }
        }
    }
}

