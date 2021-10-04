package dao;

import entities.Movie;
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

public class MovieDao implements Dao<Movie> {

    @Override
    public int save(Movie movie) {
        return Dao.super.save(movie);
    }

    /**
     * Find all from movie_table
     * @return movie
     */
    @Override
    public List<Movie> findAll(String status) {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        List<Movie> movie =new ArrayList<Movie>();

        try {
            tx = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Movie> query = builder.createQuery(Movie.class);
            Root<Movie> movieRoot = query.from(Movie.class);
            query.select(movieRoot);
            movie =session.createQuery(query).getResultList();
            return movie;

        }catch (HibernateException e){
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
        return movie;
    }

    /**
     * create one row in DB
     * @param entity
     * @return
     */
    @Override
    public Movie create(Movie entity) {

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
        return entity;
    }

    /**
     * update one row in DB
     * @param entity
     */
    @Override
    public void update(Movie entity) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
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
    public void delete(Movie entity) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
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
     * @return
     * @throws NotFoundException
     */
    public Movie findOne(long id) throws NotFoundException {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        Movie entity = null;
        try {
            tx = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Movie> query = builder.createQuery(Movie.class);
            Root<Movie> entityRoot = query.from(Movie.class);
            Predicate cond = builder.equal(entityRoot.get("movie_id"), id);
            query.select(entityRoot).where(cond);
            TypedQuery<Movie> typedQuery = session.createQuery(query);
            List<Movie> entities = typedQuery.getResultList();
            if (entities == null || entities.isEmpty()) {
                throw new NotFoundException("Entity not found");
            }
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

    public int add(Movie entity) {
        int status = 0;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
           status = (int) session.save(entity);
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
