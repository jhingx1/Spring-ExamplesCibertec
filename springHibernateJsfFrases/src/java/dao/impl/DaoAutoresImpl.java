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

    public DaoAutoresImpl() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Autores> autoresQry() {
        List<Autores> list = null;

        String s = "from Autores c order by c.autor";

        try {
            Query query = session.createQuery(s);
            list = query.list();

        } catch (HibernateException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public String autoresIns(Autores autores) {
        Transaction tx = session.beginTransaction();

        try {
            session.save(autores);
            tx.commit();

        } catch (HibernateException e) {
            message = e.getMessage();
            tx.rollback();
            session.clear();
        }

        return message;
    }

    @Override
    public String autoresDel(List<Integer> ids) {
        Transaction tx = session.beginTransaction();

        try {
            String hql = "delete Autores c where c.idautor = :id";
            Query query = session.createQuery(hql);

            for (Integer x : ids) {
                query.setInteger("id", x);
                int ctos = query.executeUpdate();

                if (ctos == 0) {
                    throw new HibernateException("0 filas afectadas.");
                }
            }
            tx.commit();

        } catch (HibernateException e) {
            message = e.getMessage();
            tx.rollback();
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
    public String autoresUpd(Autores autores) {
        Transaction tx = session.beginTransaction();

        try {
            session.update(autores);
            tx.commit();

        } catch (HibernateException | NullPointerException e) {
            message = e.getMessage();
            tx.rollback();
        }

        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

