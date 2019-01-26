package dao;

import dto.Restaurantes;
import java.util.List;
import java.util.Map;

public interface DaoRestaurantes {

    public List<Map<Object,Object>> restaurantesQry();
    
    public String restaurantesIns(Restaurantes restaurantes);

    public String restaurantesDel(String ids);

    public Restaurantes restaurantesGet(Integer idrestaurante);

    public String restaurantesUpd(Restaurantes restaurantes);

    public String getMessage();
}
