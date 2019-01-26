package dao;

import dto.Autores;
import java.util.List;

public interface DaoAutores {

    public List<Autores> autoresQry();

    public String autoresIns(Autores autores);

    public String autoresDel(String ids);

    public Autores autoresGet(Integer idautor);

    public String autoresUpd(Autores autores);

    public String getMessage();
}

