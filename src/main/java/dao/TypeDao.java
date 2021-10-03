package dao;

import entities.Type;
import javassist.NotFoundException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TypeDao implements Dao<Type> {

    /**
     * Find all from type_table
     *
     * @return entity
     */
    @Override
    public List<Type> findAll(String status) {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        List<Type> entity = new ArrayList<Type>();
        Predicate predicate = null;
        try {
            tx = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Type> query = criteriaBuilder.createQuery(Type.class);
            Root<Type> root = query.from(Type.class);
            if ("getAll".equals(status)) {
                predicate = criteriaBuilder.equal(root.get("isActive"), "Y");
                query.select(root).where(predicate);
            } else {
                query.select(root);
            }
            TypedQuery<Type> typedQuery = session.createQuery(query);
            entity = typedQuery.getResultList();
            return entity;

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return entity;
    }

    /**
     * create one row in DB
     *
     * @param entity
     * @return entity
     */
    @Override
    public Type create(Type entity) {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(entity);
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return entity;
    }

    /**
     * update one row in DB
     *
     * @param type
     */
    @Override
    public void update(Type type) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(type);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * delete one row in DB
     *
     * @param entity
     */
    @Override
    public void delete(Type entity) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Find with ID
     *
     * @param id
     * @return entity
     * @throws NotFoundException
     */
    public Type findOne(int id) throws NotFoundException {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        Type entity = null;
        try {
            tx = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Type> query = criteriaBuilder.createQuery(Type.class);
            Root<Type> root = query.from(Type.class);
            Predicate predicate = criteriaBuilder.equal(root.get("roomId"), id);
            query.select(root).where(predicate);
            TypedQuery<Type> typedQuery = session.createQuery(query);
            entity = typedQuery.getSingleResult();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return entity;
    }
}
