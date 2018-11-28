package dao;

import hibernate.domain.Categorias;
import java.util.List;

public interface DaoCategorias {

    public List<Categorias> categoriasQry();

    public String categoriasIns(Categorias categorias);

    public String categoriasDel(List<Integer> ids);

    public Categorias categoriasGet(Integer idcategoria);

    public String categoriasUpd(Categorias categorias);

    public String getMessage();
}

