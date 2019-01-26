package dao.impl;

import dao.DaoRestaurantes;
import dto.Restaurantes;
import java.util.List;
import java.util.Map;
import mybatis.RestaurantesMapper;

public class DaoRestaurantesImpl implements DaoRestaurantes {

    private String message;
    private RestaurantesMapper restaurantesMapper;

    public void setRestaurantesMapper(RestaurantesMapper restaurantesMapper) {
        this.restaurantesMapper = restaurantesMapper;
    }

    @Override
    public List<Map<Object,Object>> restaurantesQry() {
        List<Map<Object,Object>> list = null;

        try {
            list = restaurantesMapper.restaurantesQry();

        } catch (Exception e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public String restaurantesIns(Restaurantes restaurantes) {
        try {
            int ctos = restaurantesMapper.restaurantesIns(restaurantes);

            if (ctos == 0) {
                throw new Exception("0 filas afectadas");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public String restaurantesDel(String ids) {
        try {
            int ctos = restaurantesMapper.restaurantesDel(ids);

            if (ctos == 0) {
                throw new Exception("0 filas afectadas");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public Restaurantes restaurantesGet(Integer idrestaurante) {
        Restaurantes restaurantes = null;
        
        try {
            restaurantes = restaurantesMapper.restaurantesGet(idrestaurante);

            if (restaurantes == null) {
                throw new Exception("ID: " + idrestaurante + " no existe");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }
        
        return restaurantes;
    }

    @Override
    public String restaurantesUpd(Restaurantes restaurantes) {
        try {
            int ctos = restaurantesMapper.restaurantesUpd(restaurantes);
            
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
