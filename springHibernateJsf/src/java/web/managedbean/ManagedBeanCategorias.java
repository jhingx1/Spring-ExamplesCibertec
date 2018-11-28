package web.managedbean;

import dao.DaoCategorias;
import hibernate.domain.Categorias;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import parainfo.convert.DeString;

@ManagedBean(name = "mbCategorias")
@RequestScoped
public class ManagedBeanCategorias {

    private Integer idcategoria;
    private String categoria;

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

    public Integer getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
        Categorias categorias = new Categorias();
        categorias.setCategoria(categoria);

        message = daoCategorias.categoriasIns(categorias);

        if (message == null) {
            return "/categoriasQry?faces-redirect=true";
        } else {
            return "/categoriasIns";
        }
    }

    public String categoriasDel() {
        List<Integer> list_ids = DeString.ids(ids);

        if (list_ids != null) {
            message = daoCategorias.categoriasDel(list_ids);
        } else {
            message = "IDs Incorrectos o no envíados";
        }

        return "/categoriasQry";
    }

    public String categoriasGet() {
        Categorias categorias
                = daoCategorias.categoriasGet(idcategoria);

        if (categorias != null) {
            idcategoria = categorias.getIdcategoria();
            categoria = categorias.getCategoria();

            return "/categoriasUpd";
        } else {
            message = daoCategorias.getMessage();
            return "/categoriasQry";
        }
    }

    public String categoriasUpd() {
        Categorias categorias = daoCategorias.categoriasGet(idcategoria);
        categorias.setCategoria(categoria);

        message = daoCategorias.categoriasUpd(categorias);

        if (message == null) {
            return "/categoriasQry?faces-redirect=true";
        } else {
            return "/categoriasUpd";
        }
    }
}

