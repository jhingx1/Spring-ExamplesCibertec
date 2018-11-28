package web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Validateable;

import dao.DaoCategorias;
import hibernate.domain.Categorias;
import parainfo.convert.DeString;

public class ActionCategorias
        extends ActionSupport implements Validateable {

	private static final long serialVersionUID = 1L;
	
	private DaoCategorias daoCategorias;

    public void setDaoCategorias(DaoCategorias daoCategorias) {
        this.daoCategorias = daoCategorias;
    }

    public ActionCategorias() {
    }

    public List<Categorias> getList() {
        List<Categorias> list = daoCategorias.categoriasQry();

        if (list == null) {
            mensaje(daoCategorias.getMessage());
        }

        return list;
    }

    private Categorias categorias;

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    // gestion
    public String categoriasQry() {
        return SUCCESS;
    }

    public String categoriasIns() {
        categorias = new Categorias();
        return SUCCESS;
    }

    public String categoriasIns2() {
        String result = daoCategorias.categoriasIns(categorias);

        if (result == null) {
            return SUCCESS;
        } else {
            mensaje(result);
            return ERROR;
        }
    }

    public String categoriasDel() {
        HttpServletRequest request = 
                ServletActionContext.getRequest();
        String ids = request.getParameter("ids");

        List<Integer> list = DeString.ids(ids);
        String result = daoCategorias.categoriasDel(list);

        if (result != null) {
            mensaje(result);
        }

        return SUCCESS;
    }

    public String categoriasGet() {
        HttpServletRequest request = 
                ServletActionContext.getRequest();
        Integer idcategoria = 
                DeString.aInteger(
                        request.getParameter("idcategoria"));

        String result = null;
        if (idcategoria != null) {
            categorias = daoCategorias.categoriasGet(idcategoria);

            if (categorias == null) {
                result = daoCategorias.getMessage();
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

    public String categoriasUpd() {
        // por persistencia obtener objeto categorias
        Categorias c = daoCategorias.categoriasGet(
                categorias.getIdcategoria());
        c.setCategoria(categorias.getCategoria());

        String result = daoCategorias.categoriasUpd(c);

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
        if (categorias != null) {
            if ((categorias.getCategoria() == null)
                    || (categorias.getCategoria().trim().length() == 0)) {
                addFieldError("categorias.categoria", "Ingrese Categoria");
            }
        }
    }
}

