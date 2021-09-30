package dao;

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
     * @param entity
     * @return
     */
    T create(T entity);

    /**
     * update one row in DB
     * @param entity
     * @return
     */
    void update(T entity);

    /**
     * delete one row in DB
     * @param entity
     */
    void delete(T entity);
}
