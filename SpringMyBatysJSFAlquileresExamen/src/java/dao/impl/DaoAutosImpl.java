package dao.impl;

import dto.Autos;
import java.util.List;
import mybatis.AutosMapper;
import dao.DaoAutos;


public class DaoAutosImpl implements DaoAutos {

    private String message;
    private AutosMapper autosMapper;

    public void setAutosMapper(AutosMapper autosMapper) {
        this.autosMapper = autosMapper;
    }

    @Override
    public List<Autos> autosQry() {
        List<Autos> list = null;

        try {
            list = autosMapper.autosQry();

        } catch (Exception e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public String autosIns(Autos autos) {
        try {
            int ctos = autosMapper.autosIns(autos);

            if (ctos == 0) {
                throw new Exception("0 filas afectadas");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public String autosDel(String ids) {
        try {
            int ctos = autosMapper.autosDel(ids);

            if (ctos == 0) {
                throw new Exception("0 filas afectadas");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public Autos autosGet(Integer idcategoria) {
        Autos autos = null;
        
        try {
            autos = autosMapper.autosGet(idcategoria);

            if (autos == null) {
                throw new Exception("ID: " + idcategoria + " no existe");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }
        
        return autos;
    }

    @Override
    public String autosUpd(Autos autos) {
        try {
            int ctos = autosMapper.autosUpd(autos);
            
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

