package services;

import java.util.List;
import model.Frases;

public interface ServicesFrases {

    public List<Frases> frasesQry();
    
    public String frasesInsUpd(Frases frases);
    
    public String frasesDel(List<Integer> ids);
    
    public Frases frasesGet(Integer idfrase);
}
