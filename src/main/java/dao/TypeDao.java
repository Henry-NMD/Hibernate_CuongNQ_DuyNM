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
     * @return entity
     */
    @Override
    public List<Type> findAll() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        List<Type> entity =new ArrayList<Type>();

        try {
            tx = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Type> query = builder.createQuery(Type.class);
            Root<Type> entityRoot = query.from(Type.class);
            query.select(entityRoot);
            entity =session.createQuery(query).getResultList();
            return entity;

        }catch (HibernateException e){
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
        return entity;
    }

    /**
     * create one row in DB
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
        }catch (HibernateException e){
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
        return entity;
    }

    /**
     * update one row in DB
     * @param entity
     */
    @Override
    public void update(Type entity) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            // entity = (Movie)session.get(Movie.class);
        }catch (HibernateException e){
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    /**
     * delete one row in DB
     * @param entity
     */
    @Override
    public void delete(Type entity) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(entity);
        }catch (HibernateException e){
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    /**
     * Find with ID
     * @param id
     * @return entity
     * @throws NotFoundException
     */
    public Type findOne(long id) throws NotFoundException {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        Type entity = null;
        try {
            tx = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Type> query = builder.createQuery(Type.class);
            Root<Type> entityRoot = query.from(Type.class);
            Predicate cond = builder.equal(entityRoot.get("type_id"), id);
            query.select(entityRoot).where(cond);
            TypedQuery<Type> typedQuery = session.createQuery(query);
            List<Type> entities = typedQuery.getResultList();
            entity = entities.get(0);
            return entity;
        }catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
        return entity;
    }
}
