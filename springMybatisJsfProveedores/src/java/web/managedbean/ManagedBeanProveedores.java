package web.managedbean;

import dao.DaoClientes;
import dao.DaoDepartamentos;
import dao.DaoDistritos;
import dao.DaoProveedores;
import dto.Clientes;
import dto.Departamentos;
import dto.Distritos;
import dto.Proveedores;

import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "mbProveedores")
@RequestScoped
public class ManagedBeanProveedores {

    private Proveedores proveedores = new Proveedores();

    private String ids;
    private String message;

    private DaoProveedores daoProveedores;
    private DaoClientes daoClientes;
    private DaoDistritos daoDistritos;
    private DaoDepartamentos daoDepartamentos;

    public void setDaoProveedores(DaoProveedores daoProveedores) {
        this.daoProveedores = daoProveedores;
    }

    public void setDaoClientes(DaoClientes daoClientes) {
        this.daoClientes = daoClientes;
    }

    public void setDaoDistritos(DaoDistritos daoDistritos) {
        this.daoDistritos = daoDistritos;
    }
    
    public void setDaoDepartamentos(DaoDepartamentos daoDepartamentos) {
        this.daoDepartamentos = daoDepartamentos;
    }

    public ManagedBeanProveedores() {
    }

    // gettter y setter
    public List<Map<Object, Object>> getProveedoresQry() {
        List<Map<Object, Object>> list
                = daoProveedores.proveedoresQry();

        if (list == null) {
            message = daoProveedores.getMessage();
        }

        return list;
    }

    public List<Clientes> getClientesCbo() {
        List<Clientes> list = daoClientes.clientesQry();

        if (list == null) {
            message = daoClientes.getMessage();
        }

        return list;
    }

    public List<Distritos> getDistritosCbo() {
        List<Distritos> list = daoDistritos.distritosCbo();
        return list;
    }
    
    public List<Departamentos> getDepartamentosCbo() {
        List<Departamentos> list = daoDepartamentos.departamentosCbo();
        return list;
    }

    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
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
    public String proveedoresIns() {
        message = daoProveedores.proveedoresIns(proveedores);

        if (message == null) {
            return "/index?faces-redirect=true";
        } else {
            proveedores = new Proveedores();
            return "/proveedoresIns";
        }
    }

    // gestionando    
    public String proveedoresDel() {
        message = daoProveedores.proveedoresDel(ids);

        if (message != null) {
            message = "IDs Incorrectos o no envíados";
        }

        return "/index";
    }

    public String proveedoresGet() {
        proveedores = daoProveedores.proveedoresGet(
                proveedores.getIdproveedor());

        if (proveedores != null) {
            return "/proveedoresUpd";
        } else {
            message = daoProveedores.getMessage();
            return "/index";
        }
    }

    public String proveedoresUpd() {
        message = daoProveedores.proveedoresUpd(proveedores);

        if (message == null) {
            proveedores = new Proveedores();
            return "/index?faces-redirect=true";
        } else {
            return "/proveedoresUpd";
        }
    }
}
