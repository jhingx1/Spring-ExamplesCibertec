package dao.impl;

import dao.DaoAutores;
import dto.Autores;
import java.util.List;
import mybatis.AutoresMapper;

public class DaoAutoresImpl implements DaoAutores {

    private String message;
    //inyeccion
    private AutoresMapper autoresMapper;

    public void setAutoresMapper(AutoresMapper autoresMapper) {
        this.autoresMapper = autoresMapper;
    }
    //fin inyeccion
    @Override
    public List<Autores> autoresQry() {
        List<Autores> list = null;

        try {
            list = autoresMapper.autoresQry();

        } catch (Exception e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public String autoresIns(Autores autores) {
        try {
            int ctos = autoresMapper.autoresIns(autores);

            if (ctos == 0) {
                throw new Exception("0 filas afectadas");
            }
            
        } catch (Exception e) {
            
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public String autoresDel(String ids) {
        try {
            int ctos = autoresMapper.autoresDel(ids);

            if (ctos == 0) {
                throw new Exception("0 filas afectadas");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public Autores autoresGet(Integer idcategoria) {
        Autores autores = null;
        
        try {
            autores = autoresMapper.autoresGet(idcategoria);

            if (autores == null) {
                throw new Exception("ID: " + idcategoria + " no existe");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }
        
        return autores;
    }

    @Override
    public String autoresUpd(Autores autores) {
        try {
            int ctos = autoresMapper.autoresUpd(autores);
            
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

