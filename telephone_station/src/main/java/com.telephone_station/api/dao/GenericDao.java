package com.telephone_station.api.dao;

import javax.persistence.EntityManager;
import java.util.List;

import com.telephone_station.datamodel.Entity;

public interface GenericDao<E,K> {
    public EntityManager getEntityManager();
    public E get(K key);
    public List<E> getAll();
    public void add(E entity);
    public void delete(E entity);
    public void update(E entity);
}
