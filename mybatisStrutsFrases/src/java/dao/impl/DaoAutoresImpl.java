package dao.impl;

import dto.Autores;
import java.util.List;
import mybatis.SessionFactory;
import mybatis.mapper.AutoresMapper;
import org.apache.ibatis.session.SqlSession;
import dao.DaoAutores;

public class DaoAutoresImpl implements DaoAutores {

    private final SqlSession session;
    private final AutoresMapper mapper;
    private String message;

    public DaoAutoresImpl() {
        session = SessionFactory.getSqlSessionFactory().openSession();
        mapper = session.getMapper(AutoresMapper.class);
    }

    @Override
    public List<Autores> autoresQry() {
        List<Autores> list = null;

        try {
            list = mapper.autoresQry();
            session.close();

        } catch (Exception e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public String autoresIns(Autores autores) {
        try {
            int ctos = mapper.autoresIns(autores);
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
    public String autoresDel(String ids) {
        try {
            int ctos = mapper.autoresDel(ids);
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
    public Autores autoresGet(Integer idautor) {
        Autores autores = null;

        try {
            autores = mapper.autoresGet(idautor);
            session.close();

            if (autores == null) {
                throw new Exception("ID: "
                        + idautor + " no existe");
            }

        } catch (Exception e) {
            message = e.getMessage();
        }

        return autores;
    }

    @Override
    public String autoresUpd(Autores autores) {
        try {
            int ctos = mapper.autoresUpd(autores);
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

