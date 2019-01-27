package dao;
import dto.Autos;
import java.util.List;

public interface DaoAutos {

    public List<Autos> autosQry();

    public String autosIns(Autos autos);

    public String autosDel(String ids);

    public Autos autosGet(Integer idauto);

    public String autosUpd(Autos autos);

    public String getMessage();
}

