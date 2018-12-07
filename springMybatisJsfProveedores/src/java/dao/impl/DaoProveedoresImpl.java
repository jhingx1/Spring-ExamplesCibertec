package dao.impl;

import dao.DaoProveedores;
import dto.Proveedores;
import java.util.List;
import java.util.Map;
import mybatis.ProveedoresMapper;

public class DaoProveedoresImpl implements DaoProveedores {

    private String message;
    private ProveedoresMapper proveedoresMapper;

    public void setProveedoresMapper(
            ProveedoresMapper proveedoresMapper) {
        this.proveedoresMapper = proveedoresMapper;
    }

    @Override
    public List<Map<Object,Object>> proveedoresQry() {
        List<Map<Object,Object>> list = null;

        try {
            list = proveedoresMapper.proveedoresQry();

        } catch (Exception e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public String proveedoresIns(Proveedores proveedores) {
        try {
            int ctos = 
                    proveedoresMapper.proveedoresIns(proveedores);

            if (ctos == 0) {
                throw new Exception("0 filas afectadas");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public String proveedoresDel(String ids) {
        try {
            int ctos = proveedoresMapper.proveedoresDel(ids);

            if (ctos == 0) {
                throw new Exception("0 filas afectadas");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public Proveedores proveedoresGet(Integer idproveedor) {
        Proveedores proveedores = null;
        
        try {
            proveedores = 
                    proveedoresMapper.proveedoresGet(idproveedor);

            if (proveedores == null) {
                throw new Exception("ID: " + idproveedor + " no existe");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }
        
        return proveedores;
    }

    @Override
    public String proveedoresUpd(Proveedores proveedores) {
        try {
            int ctos = proveedoresMapper.proveedoresUpd(proveedores);
            
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

