package dao;

import entities.Movie;
import entities.MovieType;
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

public class MovieTypeDao implements Dao<MovieType>{

    /**
     * override save method super class
     *
     * @param movieType
     * @return
     */
    @Override
    public int save(MovieType movieType) {
        return Dao.super.save(movieType);
    }

    /**
     * Find all from movie_type_table
     *
     * @return entity
     */
    public List<MovieType> findAll(String status) {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        List<MovieType> entity = new ArrayList<MovieType>();
        Predicate predicate = null;
        try {
            tx = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<MovieType> query = criteriaBuilder.createQuery(MovieType.class);
            Root<MovieType> root = query.from(MovieType.class);
            if ("getAll".equals(status)) {
                predicate = criteriaBuilder.equal(root.get("isActive"), "Y");
                query.select(root).where(predicate);
            } else {
                query.select(root);
            }
            TypedQuery<MovieType> typedQuery = session.createQuery(query);
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

    @Override
    public MovieType create(MovieType entity) {
        return null;
    }

    @Override
    public void update(MovieType entity) {

    }

    @Override
    public void delete(MovieType entity) {

    }

    /**
     * Save movie_type_table
     *
     * @param entity
     * @return entity
     */
    public int add(MovieType entity) {
        int status = 0;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(entity);
            tx.commit();
        }catch (HibernateException e){
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
        return status;
    }

}
