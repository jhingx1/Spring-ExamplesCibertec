package dao;

import dto.Proveedores;
import java.util.List;
import java.util.Map;

public interface DaoProveedores {

    public List<Map<Object,Object>> proveedoresQry();
    
    public String proveedoresIns(Proveedores proveedores);

    public String proveedoresDel(String ids);

    public Proveedores proveedoresGet(Integer idproveedor);

    public String proveedoresUpd(Proveedores proveedores);

    public String getMessage();
}

