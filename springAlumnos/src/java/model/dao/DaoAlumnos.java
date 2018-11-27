package model.dao;

import dto.Alumnos;
import java.util.List;

public interface DaoAlumnos {

    public List<Alumnos> alumnosQry();

    public String alumnosIns(Alumnos alumnos);

    public String alumnosDel(List<Object[]> ids);

    public Alumnos alumnosGet(Integer idalumno);

    public String alumnosUpd(Alumnos alumnos);
}

