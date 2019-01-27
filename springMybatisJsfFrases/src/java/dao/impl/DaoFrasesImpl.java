package dao.impl;

import dao.DaoFrases;
import dto.Frases;
import java.util.List;
import java.util.Map;
import mybatis.FrasesMapper;

public class DaoFrasesImpl implements DaoFrases {

    private String message;
    private FrasesMapper frasesMapper;

    public void setFrasesMapper(
            FrasesMapper frasesMapper) {
        this.frasesMapper = frasesMapper;
    }

    @Override
    public List<Map<Object,Object>> frasesQry() {
        List<Map<Object,Object>> list = null;

        try {
            list = frasesMapper.frasesQry();

        } catch (Exception e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public String frasesIns(Frases frases) {
        try {
            int ctos = 
                    frasesMapper.frasesIns(frases);

            if (ctos == 0) {
                throw new Exception("0 filas afectadas");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public String frasesDel(String ids) {
        try {
            int ctos = frasesMapper.frasesDel(ids);

            if (ctos == 0) {
                throw new Exception("0 filas afectadas");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public Frases frasesGet(Integer idrestaurante) {
        Frases frases = null;
        
        try {
            frases = 
                    frasesMapper.frasesGet(idrestaurante);

            if (frases == null) {
                throw new Exception("ID: " + idrestaurante + " no existe");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }
        
        return frases;
    }

    @Override
    public String frasesUpd(Frases frases) {
        try {
            int ctos = frasesMapper.frasesUpd(frases);
            
            if (ctos == 0) {
                throw new Exception("0 filas afectadas");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

