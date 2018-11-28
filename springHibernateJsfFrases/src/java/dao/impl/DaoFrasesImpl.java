package dao.impl;

import dao.DaoFrases;
import hibernate.domain.Frases;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DaoFrasesImpl implements DaoFrases {

    private Session session;
    private String message;

    public void setSessionFactory(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
    }

    public DaoFrasesImpl() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Object[]> frasesQry() {
        List<Object[]> list = null;

        String s = "select f.idfrase,a.autor,f.frase "
                + "from Frases f inner join f.autores a";
        
        try {
            Query query = session.createQuery(s);
            list = query.list();

        } catch (HibernateException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public String frasesIns(Frases frases) {
        Transaction tx = session.beginTransaction();
        
        try {
            session.persist(frases);
            tx.commit();

        } catch (HibernateException e) {
            message = e.getMessage();
            tx.rollback();
            session.clear();
        }

        return message;
    }

    @Override
    public String frasesDel(List<Integer> ids) {
        Transaction tx = session.beginTransaction();
        
        try {
            String hql = "delete Frases r "
                    + "where r.idfrase = :id";
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
    public Frases frasesGet(Integer idfrase) {
        Frases frases
                = (Frases) session.get(
                        Frases.class, idfrase);
        
        return frases;
    }

    @Override
    public String frasesUpd(Frases frases) {
        Transaction tx = session.beginTransaction();
        
        try {
            session.update(frases);
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


