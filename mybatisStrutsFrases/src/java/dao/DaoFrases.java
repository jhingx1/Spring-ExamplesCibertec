package dao;

import dto.Frases;
import java.util.List;
import java.util.Map;

public interface DaoFrases {
    
    public List<Map<Object,Object>> frasesQry();
    
    public String frasesIns(Frases frases);

    public String frasesDel(String ids);

    public Frases frasesGet(Integer idfrase);

    public String frasesUpd(Frases frases);
    
    public String getMessage();
}

