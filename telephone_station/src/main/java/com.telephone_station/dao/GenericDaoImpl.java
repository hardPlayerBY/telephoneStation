package com.telephone_station.dao;

import com.telephone_station.api.dao.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class GenericDaoImpl<E,T> implements GenericDao<E,T> {

    protected final Class<E> clazz;

    protected GenericDaoImpl(Class<E> clazz) {
        this.clazz = clazz;
    }

    public EntityManager getEntityManager() {
        return HibernetUtil.getEntityManager();
    }

    public List<E> getAll() {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<E> query = cb.createQuery(clazz);        //result
        Root<E> root = query.from(clazz);                    //source
        query.select(root);
        return em.createQuery(query).getResultList();
    }

    @Override
    public E get(T key) {
        EntityManager em = getEntityManager();
        EntityTransaction tr = em.getTransaction();
        E user = null;
        try {
            tr.begin();
            user = em.find(clazz, key);
            tr.commit();
        }catch(Exception e){
            tr.rollback();
            throw e;
        }
        return user;
    }

    public void add(E entity) throws PersistenceException {
        EntityManager em = getEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.persist(entity);
            tr.commit();
        } catch (PersistenceException e) {
            tr.rollback();
            throw e;
        }
    }

    public void delete(E entity) {
        EntityManager em = getEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.remove(em.contains(entity) ? entity : em.merge(entity));
            tr.commit();
        } catch (PersistenceException e) {
            tr.rollback();
            throw e;
        }
    }

    public void update(E entity) {
        EntityManager em = getEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.merge(entity);
            tr.commit();
        } catch (PersistenceException e) {
            tr.rollback();
            throw e;
        }
    }

}
