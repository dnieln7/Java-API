package com.dnieln7.javaapi.data.dao;

import com.dnieln7.javaapi.data.HibernateUtil;
import com.dnieln7.javaapi.data.dto.Store;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author dnieln7
 */
public class DaoStore implements IDao<Store, Integer> {
    
    private final SessionFactory factory;

    public DaoStore() {
        factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean insert(Store entity) {
        return CrudOperations.insert(factory, entity);
    }

    @Override
    public boolean update(Store entity) {
        return CrudOperations.update(factory, entity);
    }

    @Override
    public boolean delete(Integer id) {
        return CrudOperations.delete(factory, new Store(id));
    }

    @Override
    public Store find(Integer id) {
        return CrudOperations.find(factory, Store.class, id);
    }

    @Override
    public List<Store> findAll() {
        return CrudOperations.findAll(factory, "SELECT s FROM Store s");
    }
}
