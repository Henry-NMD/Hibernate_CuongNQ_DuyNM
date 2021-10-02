package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.List;

public interface Dao<T> {

    /**
     * get all object from DB
     *
     * @return
     */
    List<T> findAll();

    /**
     * create one row in DB
     *
     * @param entity
     * @return
     */
    T create(T entity);

    /**
     * update one row in DB
     *
     * @param entity
     * @return
     */
    void update(T entity);

    /**
     * delete one row in DB
     *
     * @param entity
     */
    void delete(T entity);


    /**
     *  save an object to db
     *
     * @param t
     * @return 1 if success , otherwise 0
     */
    default int save(T t) {
        int statusSaveObject = 0;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            statusSaveObject = (int) session.save(t);
            tx.commit();
        } catch (Exception e) {
            if (session != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return statusSaveObject;
    }
}
