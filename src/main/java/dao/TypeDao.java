package dao;

import entities.Type;

import java.util.List;

public class TypeDao implements Dao<Type>{
    @Override
    public List<Type> findAll() {
        return null;
    }

    @Override
    public Type create(Type entity) {
        return null;
    }

    @Override
    public void update(Type entity) {

    }

    @Override
    public void delete(Type entity) {

    }

    @Override
    public int save(Type type) {
        return Dao.super.save(type);
    }
}
