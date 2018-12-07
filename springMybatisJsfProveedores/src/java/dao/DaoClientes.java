package dao;

import dto.Clientes;
import java.util.List;

public interface DaoClientes {

    public List<Clientes> clientesQry();

    public String clientesIns(Clientes clientes);

    public String clientesDel(String ids);

    public Clientes clientesGet(Integer idcliente);

    public String clientesUpd(Clientes clientes);

    public String getMessage();
}

