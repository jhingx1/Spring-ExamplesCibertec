package dao.impl;

import dao.DaoRestaurantes;
import hibernate.domain.Restaurantes;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DaoRestaurantesImpl implements DaoRestaurantes {

    private Session session;
    private String message;

    public void setSessionFactory(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
    }

    public DaoRestaurantesImpl() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Object[]> restaurantesQry() {
        List<Object[]> list = null;

        String s = "select r.idrestaurante,r.restaurante,"
                + "c.categoria,d.distrito,r.direccion "
                + "from Categorias c inner join c.restauranteses r "
                + "inner join r.distritos d";

        try {
            Query query = session.createQuery(s);
            list = query.list();

        } catch (HibernateException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public String restaurantesIns(Restaurantes restaurantes) {
        Transaction tx = session.beginTransaction();
        
        try {
            session.persist(restaurantes);
            tx.commit();

        } catch (HibernateException e) {
            message = e.getMessage();
            tx.rollback();
            session.clear();
        }

        return message;
    }

    @Override
    public String restaurantesDel(List<Integer> ids) {
        Transaction tx = session.beginTransaction();
        
        try {
            String hql = "delete Restaurantes r "
                    + "where r.idrestaurante = :id";
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
    public Restaurantes restaurantesGet(Integer idrestaurante) {
        Restaurantes restaurantes
                = (Restaurantes) session.get(
                        Restaurantes.class, idrestaurante);
        
        return restaurantes;
    }

    @Override
    public String restaurantesUpd(Restaurantes restaurantes) {
        Transaction tx = session.beginTransaction();
        
        try {
            session.update(restaurantes);
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


