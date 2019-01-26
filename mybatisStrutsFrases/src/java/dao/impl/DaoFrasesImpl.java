package dao.impl;

import dao.DaoFrases;
import dto.Frases;
import java.util.List;
import java.util.Map;
import mybatis.SessionFactory;
import mybatis.mapper.FrasesMapper;
import org.apache.ibatis.session.SqlSession;

public class DaoFrasesImpl implements DaoFrases {

    private final SqlSession session;
    private final FrasesMapper mapper;
    private String message;

    public DaoFrasesImpl() {
        session = SessionFactory.getSqlSessionFactory().openSession();
        mapper = session.getMapper(FrasesMapper.class);
    }

    @Override
    public List<Map<Object,Object>> frasesQry() {
        List<Map<Object,Object>> list = null;

        try {
            list = mapper.frasesQry();
            session.close();

        } catch (Exception e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public String frasesIns(Frases frases) {
        try {
            int ctos = mapper.frasesIns(frases);
            if (ctos == 0) {
                throw new Exception("0 filas afectadas");
            }
            session.commit();

        } catch (Exception e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public String frasesDel(String ids) {
        try {
            int ctos = mapper.frasesDel(ids);
            if (ctos == 0) {
                throw new Exception("0 filas afectadas");
            }
            session.commit();

        } catch (Exception e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public Frases frasesGet(Integer idfrase) {
        Frases frases = null;

        try {
            frases = mapper.frasesGet(idfrase);
            session.close();

            if (frases == null) {
                throw new Exception("ID: "
                        + idfrase + " no existe");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }

        return frases;
    }

    @Override
    public String frasesUpd(Frases frases) {
        try {
            int ctos = mapper.frasesUpd(frases);
            if (ctos == 0) {
                throw new Exception("0 filas afectadas");
            }
            session.commit();

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

