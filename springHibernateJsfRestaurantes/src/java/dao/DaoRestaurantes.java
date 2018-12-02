package dao;

import hibernate.domain.Restaurantes;
import java.util.List;

public interface DaoRestaurantes {

    public List<Object[]> restaurantesQry();
    
    public String restaurantesIns(Restaurantes restaurantes);

    public String restaurantesDel(List<Integer> ids);

    public Restaurantes restaurantesGet(Integer idrestaurante);

    public String restaurantesUpd(Restaurantes restaurantes);

    public String getMessage();
}

