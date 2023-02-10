package com.bitrock.springdataproject.services;

import com.bitrock.springdataproject.entities.Employee;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Class that can be extended to do all basic db operations.
 * Currently, for the operations that require a hql query string,
 * it must be passed to the method in order to execute the operation.
 * In the future this class could be improved by implementing an automatic
 * generation of the basic queries strings according to the type <T>.
 */
public class BaseDbService<T> {

    public Session getSession() {
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        session.beginTransaction();
        return session;
    }

    public List<T> getAll(String hqlQuery) {
        Session session = getSession();
        Query<T> query = session.createQuery(hqlQuery);
        List<T> entities = query.getResultList();
        session.close();
        return entities;
    }

    public T getById(String hqlQuery, Long id) {
        Session session = getSession();
        Query<T> query = session.createQuery(hqlQuery);
        query.setParameter("id",id);
        T entity = query.uniqueResult();
        session.close();
        return entity;
    }

    public void create(T entity) {
        Session session = getSession();
        session.save(entity);
    }

    public void deleteById(String hqlQuery, Long id) {
        Session session = getSession();
        Query<T> query = session.createQuery(hqlQuery);
        query.setParameter("id",id);
        query.executeUpdate();
        session.close();
    }
}
