package com.dnieln7.javaapi.data.dao;

import java.util.List;

/**
 *
 * @author dnieln7
 */
public interface IDao<T, V>
{
    public boolean insert(T entity);
    public boolean update(T entity);
    public boolean delete(V id);
    public T find(V id);
    public List<T> findAll();
}
