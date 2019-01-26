package web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Validateable;

import dao.DaoAutores;
import dto.Autores;
import parainfo.convert.DeString;

public class ActionAutores
        extends ActionSupport implements Validateable {

    private static final long serialVersionUID = 1L;

    private DaoAutores daoAutores;

    public void setDaoAutores(DaoAutores daoAutores) {
        this.daoAutores = daoAutores;
    }

    public ActionAutores() {
    }

    public List<Autores> getList() {
        List<Autores> list = daoAutores.autoresQry();

        if (list == null) {
            mensaje(daoAutores.getMessage());
        }

        return list;
    }

    private Autores autores;

    public Autores getAutores() {
        return autores;
    }

    public void setAutores(Autores autores) {
        this.autores = autores;
    }

    // gestion
    public String autoresQry() {
        return SUCCESS;
    }

    public String autoresIns() {
        autores = new Autores();
        return SUCCESS;
    }

    public String autoresIns2() {
        String result = daoAutores.autoresIns(autores);

        if (result == null) {
            return SUCCESS;

        } else {
            mensaje(result);
            return ERROR;
        }
    }

    public String autoresDel() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String ids = request.getParameter("ids");

        String result = daoAutores.autoresDel(ids);

        if (result != null) {
            mensaje(result);
        }

        return SUCCESS;
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
            result = "ID Incorrecto";
        }

        if (result == null) {
            return SUCCESS;
        } else {
            mensaje(result);
            return ERROR;
        }
    }

    public String autoresUpd() {
        // por persistencia obtener objeto autores
        Autores c = daoAutores.autoresGet(
                autores.getIdautor());
        c.setAutor(autores.getAutor());

        String result = daoAutores.autoresUpd(c);

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
        if (autores != null) {
            if ((autores.getAutor() == null)
                    || (autores.getAutor().trim().length() == 0)) {
                addFieldError("autores.autor", "Ingrese Categoría");
            }
        }
    }
}
