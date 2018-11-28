package dao.impl;

import dao.DaoDistritos;
import hibernate.domain.Distritos;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DaoDistritosImpl implements DaoDistritos {

    private Session session;
    private String message;

    public void setSessionFactory(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
    }

    public DaoDistritosImpl() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Distritos> distritosCbo() {
        List<Distritos> list = null;

        String s = "from Distritos d order by d.distrito";

        try {
            Query query = session.createQuery(s);
            list = query.list();

        } catch (HibernateException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public Distritos distritosGet(Integer iddistrito) {
        Distritos distritos
                = (Distritos) session.get(Distritos.class, iddistrito);
        
        return distritos;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

