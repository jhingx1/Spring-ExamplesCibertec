package dao.impl;

import dto.Alquileres;
import java.util.List;
import java.util.Map;
import mybatis.AlquileresMapper;
import dao.DaoAlquileres;

public class DaoAlquileresImpl implements DaoAlquileres {

    private String message;
    private AlquileresMapper alquileresMapper;

    public void setAlquileresMapper(
            AlquileresMapper alquileresMapper) {
        this.alquileresMapper = alquileresMapper;
    }

    @Override
    public List<Map<Object,Object>> alquileresQry() {
        List<Map<Object,Object>> list = null;

        try {
            list = alquileresMapper.alquileresQry();

        } catch (Exception e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public String alquileresIns(Alquileres alquileres) {
        try {
            int ctos = 
                    alquileresMapper.alquileresIns(alquileres);

            if (ctos == 0) {
                throw new Exception("0 filas afectadas");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public String alquileresDel(String ids) {
        try {
            int ctos = alquileresMapper.alquileresDel(ids);

            if (ctos == 0) {
                throw new Exception("0 filas afectadas");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public Alquileres alquileresGet(Integer idalquiler) {
        Alquileres alquileres = null;
        
        try {
            alquileres = 
                    alquileresMapper.alquileresGet(idalquiler);

            if (alquileres == null) {
                throw new Exception("ID: " + idalquiler + " no existe");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }
        
        return alquileres;
    }

    @Override
    public String alquileresUpd(Alquileres alquileres) {
        try {
            int ctos = alquileresMapper.alquileresUpd(alquileres);
            
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

