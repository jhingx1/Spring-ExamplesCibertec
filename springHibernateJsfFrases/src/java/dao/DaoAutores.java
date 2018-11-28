package dao;

import hibernate.domain.Autores;
import java.util.List;

public interface DaoAutores {

    public List<Autores> autoresQry();

    public String autoresIns(Autores autores);

    public String autoresDel(List<Integer> ids);

    public Autores autoresGet(Integer idautor);

    public String autoresUpd(Autores autores);

    public String getMessage();
}

