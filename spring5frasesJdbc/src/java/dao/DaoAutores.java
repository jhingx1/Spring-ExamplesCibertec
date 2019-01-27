package dao;

import domain.Autores;
import java.util.List;

public interface DaoAutores {
    
    public List<Autores> autoresQry();

    public String autoresIns(Autores autores);

    public String autoresDel(Integer[] id);

    public Autores autoresGet(Integer idautor);

    public String autoresUpd(Autores autores);

    public List<Object[]> autoresCbo();
}
