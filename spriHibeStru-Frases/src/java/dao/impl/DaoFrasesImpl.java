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
            session.clear();
        }

        return list;
    }

    @Override
    public String frasesInsUpd(Frases frases) {
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
            String hql = "delete Frases f where f.idfrase = :id";
            Query query = session.createQuery(hql);
            
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
            tx.rollback();
            session.clear();
        }

        return message;
    }

    @Override
    public Frases frasesGet(Integer idfrase) {
        Frases frases
                = (Frases) session.get(Frases.class, idfrase);
        
        return frases;
    }

    @Override
    public String getMessage() {
        return message;
    }

}

