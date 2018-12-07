package dao.impl;

import dao.DaoClientes;
import dto.Clientes;
import java.util.List;
import mybatis.ClientesMapper;

public class DaoClientesImpl implements DaoClientes {

    private String message;
    //inyeccion
    private ClientesMapper clientesMapper;

    public void setClientesMapper(ClientesMapper clientesMapper) {
        this.clientesMapper = clientesMapper;
    }
    //fin inyeccion
    @Override
    public List<Clientes> clientesQry() {
        List<Clientes> list = null;

        try {
            list = clientesMapper.clientesQry();

        } catch (Exception e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public String clientesIns(Clientes clientes) {
        try {
            int ctos = clientesMapper.clientesIns(clientes);

            if (ctos == 0) {
                throw new Exception("0 filas afectadas");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public String clientesDel(String ids) {
        try {
            int ctos = clientesMapper.clientesDel(ids);

            if (ctos == 0) {
                throw new Exception("0 filas afectadas");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public Clientes clientesGet(Integer idcliente) {
        Clientes clientes = null;
        
        try {
            clientes = clientesMapper.clientesGet(idcliente);

            if (clientes == null) {
                throw new Exception("ID: " + idcliente + " no existe");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }
        
        return clientes;
    }

    @Override
    public String clientesUpd(Clientes clientes) {
        try {
            int ctos = clientesMapper.clientesUpd(clientes);
            
            if (ctos == 0) {
                throw new Exception("0 filas afectadas");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

