package dao;

import hibernate.domain.Distritos;
import java.util.List;

public interface DaoDistritos {

    public List<Distritos> distritosCbo();

    public Distritos distritosGet(Integer iddistrito);

    public String getMessage();
}

