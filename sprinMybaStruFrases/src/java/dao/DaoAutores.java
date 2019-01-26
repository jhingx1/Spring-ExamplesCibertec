package dao;

import dto.Autores;
import java.util.List;

public interface DaoAutores {

    public List<Autores> autoresQry();

    public String autoresIns(Autores autores);

    public String autoresDel(String ids);//integer.

    public Autores autoresGet(Integer idautor);

    public String autoresUpd(Autores autores);

    public String getMessage();//Usa String para saver porque no se pudo realizar la excepcion
    //normalmente se debuelve interger -> en lugar de String
}

