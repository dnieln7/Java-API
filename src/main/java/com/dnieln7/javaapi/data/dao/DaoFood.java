package com.dnieln7.javaapi.data.dao;

import com.dnieln7.javaapi.data.HibernateUtil;
import com.dnieln7.javaapi.data.dto.Food;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author dnieln7
 */
public class DaoFood implements IDao<Food, Integer> {

    private final SessionFactory factory;

    public DaoFood() {
        factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean insert(Food entity) {
        return CrudOperations.insert(factory, entity);
    }

    @Override
    public boolean update(Food entity) {
        return CrudOperations.update(factory, entity);
    }

    @Override
    public boolean delete(Integer id) {
        return CrudOperations.delete(factory, new Food(id));
    }

    @Override
    public Food find(Integer id) {
        return CrudOperations.find(factory, Food.class, id);
    }

    @Override
    public List<Food> findAll() {
        return CrudOperations.findAll(factory, "SELECT f FROM Food f");
    }
}
