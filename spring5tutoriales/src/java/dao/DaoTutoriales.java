package dao;

import dto.Tutoriales;
import java.util.List;

public interface DaoTutoriales {

    public List<Tutoriales> tutorialesQry();

    public String tutorialesIns(Tutoriales tutoriales);

    public String tutorialesDel(Integer[]  id);

    public Tutoriales tutorialesGet(Integer idtutorial);

    public String tutorialesUpd(Tutoriales tutoriales);
}

