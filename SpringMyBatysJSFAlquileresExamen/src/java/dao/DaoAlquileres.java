package dao;

import dto.Alquileres;
import java.util.List;
import java.util.Map;

public interface DaoAlquileres {

    public List<Map<Object,Object>> alquileresQry();
    
    public String alquileresIns(Alquileres alquileres);

    public String alquileresDel(String ids);

    public Alquileres alquileresGet(Integer idalquiler);

    public String alquileresUpd(Alquileres alquileres);

    public String getMessage();
}

