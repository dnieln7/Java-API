package com.dnieln7.javaapi.data.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Basic CRUD operations
 *
 * @author dnieln7
 */
public class CrudOperations {

    private CrudOperations() {
    }

    /**
     * Inserts a new entity in the database
     *
     * @param factory {@link SessionFactory} instance to perform transactions.
     * @param entity  Entity instance to be inserted.
     * @param <T>     Entity type.
     * @return True if success; false otherwise
     */
    public static <T> boolean insert(SessionFactory factory, T entity) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();

            return true;
        } catch (HibernateException e) {
            Logger.getLogger(CrudOperations.class.getName()).log(Level.SEVERE, null, e);

            return false;
        }
    }

    /**
     * Updates an entity in the database
     *
     * @param factory {@link SessionFactory} instance to perform transactions.
     * @param entity  Entity instance to be updated.
     * @param <T>     Entity type.
     * @return True if success; false otherwise
     */
    public static <T> boolean update(SessionFactory factory, T entity) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();

            return true;
        } catch (HibernateException e) {
            Logger.getLogger(CrudOperations.class.getName()).log(Level.SEVERE, null, e);

            return false;
        }
    }

    /**
     * Deletes an entity from the database
     *
     * @param factory {@link SessionFactory} instance to perform transactions.
     * @param entity  Entity instance to be deleted.
     * @param <T>     Entity type.
     * @return True if success; false otherwise
     */
    public static <T> boolean delete(SessionFactory factory, T entity) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();

            return true;
        } catch (HibernateException e) {
            Logger.getLogger(CrudOperations.class.getName()).log(Level.SEVERE, null, e);

            return false;
        }
    }

    /**
     * Search an entity in the database
     *
     * @param factory {@link SessionFactory} instance to perform transactions.
     * @param clazz   Class type of the desired entity.
     * @param id      Identifier of the desired entity.
     * @param <T>     Entity type.
     * @param <V>     Identifier type.
     * @return The desired entity; null if none found.
     */
    public static <T, V> T find(SessionFactory factory, Class<T> clazz, V id) {
        try (Session session = factory.openSession()) {

            return session.find(clazz, id);
        } catch (HibernateException e) {
            Logger.getLogger(CrudOperations.class.getName()).log(Level.SEVERE, null, e);

            return null;
        }
    }

    /**
     * Search for all entities in the database
     * @param factory {@link SessionFactory} instance to perform transactions.
     * @param query Java Persistence query, e.g, {@code SELECT p FROM Person p}.
     * @param <T> Entity type.
     * @return All entities in an {@link List}; or a empty one if none found.
     */
    public static <T> List<T> findAll(SessionFactory factory, String query) {
        try (Session session = factory.openSession()) {

            return session.createQuery(query).list();
        } catch (HibernateException e) {
            Logger.getLogger(CrudOperations.class.getName()).log(Level.SEVERE, null, e);

            return new ArrayList<>();
        }
    }
}
