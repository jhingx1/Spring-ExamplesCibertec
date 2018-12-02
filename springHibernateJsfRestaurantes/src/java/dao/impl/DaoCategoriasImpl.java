package dao.impl;

import dao.DaoCategorias;
import hibernate.domain.Categorias;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DaoCategoriasImpl implements DaoCategorias {

    private Session session;
    private String message;

    public void setSessionFactory(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
    }

    public DaoCategoriasImpl() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Categorias> categoriasQry() {
        List<Categorias> list = null;

        String s = "from Categorias c order by c.categoria";

        try {
            Query query = session.createQuery(s);
            list = query.list();

        } catch (HibernateException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public String categoriasIns(Categorias categorias) {
        Transaction tx = session.beginTransaction();

        try {
            session.save(categorias);
            tx.commit();

        } catch (HibernateException e) {
            message = e.getMessage();
            tx.rollback();
            session.clear();
        }

        return message;
    }

    @Override
    public String categoriasDel(List<Integer> ids) {
        Transaction tx = session.beginTransaction();

        try {
            String hql = "delete Categorias c where c.idcategoria = :id";
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
    public Categorias categoriasGet(Integer idcategoria) {
        Categorias categorias
                = (Categorias) session.get(Categorias.class, idcategoria);

        return categorias;
    }

    @Override
    public String categoriasUpd(Categorias categorias) {
        Transaction tx = session.beginTransaction();

        try {
            session.update(categorias);
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

