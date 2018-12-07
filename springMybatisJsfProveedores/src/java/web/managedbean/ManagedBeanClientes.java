package web.managedbean;

import dao.DaoClientes;
import dto.Clientes;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
 
@ManagedBean(name = "mbClientes")
@RequestScoped
public class ManagedBeanClientes {

    private Clientes clientes = new Clientes();

    private String ids;
    private String message;

    private DaoClientes daoClientes;

    public void setDaoClientes(DaoClientes daoClientes) {
        this.daoClientes = daoClientes;
    }

    public ManagedBeanClientes() {
    }

    public List<Clientes> getClientesQry() {
        List<Clientes> list = daoClientes.clientesQry();

        if (list == null) {
            message = daoClientes.getMessage();
        }

        return list;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
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

    public String clientesIns() {
        message = daoClientes.clientesIns(clientes);

        if (message == null) {
            clientes = new Clientes();
            return "/clientesQry?faces-redirect=true";
        } else {
            return "/clientesIns";
        }
    }

    public String clientesDel() {
        message = daoClientes.clientesDel(ids);

        if (message != null) {
            message = "IDs Incorrectos o no envíados";
        }

        return "/clientesQry";
    }

    public String clientesGet() {
        clientes = daoClientes.clientesGet(
                clientes.getIdcliente());

        if (clientes != null) {
            return "/clientesUpd";
        } else {
            message = daoClientes.getMessage();
            return "/clientesQry";
        }
    }

    public String clientesUpd() {
        message = daoClientes.clientesUpd(clientes);

        if (message == null) {
            clientes = new Clientes();
            return "/clientesQry?faces-redirect=true";
        } else {
            return "/clientesUpd";
        }
    }
}

