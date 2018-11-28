package dao.impl;

import dao.DaoAutores;
import hibernate.domain.Autores;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DaoAutoresImpl implements DaoAutores {

    private Session session;
    private String message;

    public void setSessionFactory(SessionFactory sessionFactory) {
       session = sessionFactory.openSession();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Autores> autoresQry() {
        List<Autores> list = null;

        String s = "from Autores";

        try {
            Query query = session.createQuery(s);
            list = query.list();

        } catch (HibernateException e) {
            message = e.getMessage();
            session.clear();
        }

        return list;
    }

    @Override
    public String autoresInsUpd(Autores autores) {
        String result = null;
        Transaction tx = session.beginTransaction();
        try {
            session.saveOrUpdate(autores);
            tx.commit();
        } catch (HibernateException e) {
            result = e.getMessage();
             session.clear();
        }

        return result;
    }

    @Override
    public String autoresDel(List<Integer> ids) {
        try {
            String hql = "delete Autores a where a.idautor = :id";
            Query query = session.createQuery(hql);
            Transaction tx = session.beginTransaction();

            for (Integer idautor : ids) {
                query.setInteger("id", idautor);
                int ctos = query.executeUpdate();
                tx.commit();
                if (ctos == 0) {
                    throw new HibernateException("0 filas afectadas.");
                }
            }

        } catch (HibernateException e) {
            message = e.getMessage();
             session.clear();
        }

        return message;
    }

    @Override
    public Autores autoresGet(Integer idautor) {
        Autores autores
                = (Autores) session.get(Autores.class, idautor);
        
        return autores;
    }

    @Override
    public String getMessage() {
        return message;
    }

}

