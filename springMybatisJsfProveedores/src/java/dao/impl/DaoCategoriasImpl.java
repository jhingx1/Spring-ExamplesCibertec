package dao.impl;

import dao.DaoCategorias;
import dto.Categorias;
import java.util.List;
import mybatis.CategoriasMapper;

public class DaoCategoriasImpl implements DaoCategorias {

    private String message;
    //inyeccion
    private CategoriasMapper categoriasMapper;

    public void setCategoriasMapper(CategoriasMapper categoriasMapper) {
        this.categoriasMapper = categoriasMapper;
    }
    //fin inyeccion
    @Override
    public List<Categorias> categoriasQry() {
        List<Categorias> list = null;

        try {
            list = categoriasMapper.categoriasQry();

        } catch (Exception e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public String categoriasIns(Categorias categorias) {
        try {
            int ctos = categoriasMapper.categoriasIns(categorias);

            if (ctos == 0) {
                throw new Exception("0 filas afectadas");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public String categoriasDel(String ids) {
        try {
            int ctos = categoriasMapper.categoriasDel(ids);

            if (ctos == 0) {
                throw new Exception("0 filas afectadas");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public Categorias categoriasGet(Integer idcategoria) {
        Categorias categorias = null;
        
        try {
            categorias = categoriasMapper.categoriasGet(idcategoria);

            if (categorias == null) {
                throw new Exception("ID: " + idcategoria + " no existe");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }
        
        return categorias;
    }

    @Override
    public String categoriasUpd(Categorias categorias) {
        try {
            int ctos = categoriasMapper.categoriasUpd(categorias);
            
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

