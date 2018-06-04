package com.telephone_station.dao;

import com.telephone_station.datamodel.Service;
import com.telephone_station.api.dao.ServiceDao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class ServiceDaoImpl extends GenericDaoImpl<Service,Long> implements ServiceDao {

    public ServiceDaoImpl(Class<Service> clazz) {
        super(clazz);
    }

    public List<Service> getByPrice(long price) {
        EntityManager session = getEntityManager();
        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery<Service> query = cb.createQuery(Service.class);
        Root<Service> root = query.from(Service.class);
        query.select(root);
        query.where(cb.equal(root.get("price"), price));
        return session.createQuery(query).getResultList();
    }

    public Service getByName(String name) {
        EntityManager session = getEntityManager();
        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery<Service> query = cb.createQuery(Service.class);
        Root<Service> root = query.from(Service.class);
        query.select(root);
        query.where(cb.equal(root.get("name"), name));
        List<Service> result =  session.createQuery(query).getResultList();
        return result.size() == 0 ? null : result.get(0);
    }
}
