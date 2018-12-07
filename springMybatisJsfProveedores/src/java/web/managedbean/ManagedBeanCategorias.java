package web.managedbean;

import dao.DaoCategorias;
import dto.Categorias;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
 
@ManagedBean(name = "mbCategorias")
@RequestScoped
public class ManagedBeanCategorias {

    private Categorias categorias = new Categorias();

    private String ids;
    private String message;

    private DaoCategorias daoCategorias;

    public void setDaoCategorias(DaoCategorias daoCategorias) {
        this.daoCategorias = daoCategorias;
    }

    public ManagedBeanCategorias() {
    }

    public List<Categorias> getCategoriasQry() {
        List<Categorias> list = daoCategorias.categoriasQry();

        if (list == null) {
            message = daoCategorias.getMessage();
        }

        return list;
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
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

    public String categoriasIns() {
        message = daoCategorias.categoriasIns(categorias);

        if (message == null) {
            categorias = new Categorias();
            return "/categoriasQry?faces-redirect=true";
        } else {
            return "/categoriasIns";
        }
    }

    public String categoriasDel() {
        message = daoCategorias.categoriasDel(ids);

        if (message != null) {
            message = "IDs Incorrectos o no envíados";
        }

        return "/categoriasQry";
    }

    public String categoriasGet() {
        categorias = daoCategorias.categoriasGet(
                categorias.getIdcategoria());

        if (categorias != null) {
            return "/categoriasUpd";
        } else {
            message = daoCategorias.getMessage();
            return "/categoriasQry";
        }
    }

    public String categoriasUpd() {
        message = daoCategorias.categoriasUpd(categorias);

        if (message == null) {
            categorias = new Categorias();
            return "/categoriasQry?faces-redirect=true";
        } else {
            return "/categoriasUpd";
        }
    }
}

