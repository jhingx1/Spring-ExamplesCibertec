package services;

import java.util.List;
import model.Autores;

public interface ServicesAutores {

    public List<Autores> autoresCbo();

    public List<Autores> autoresQry();
    
    public String autoresInsUpd(Autores autores);
    
    public String autoresDel(List<Integer> ids);
    
    public Autores autoresGet(Integer idautor);
}
