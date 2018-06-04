package com.telephone_station.dao;

import com.telephone_station.api.dao.CountDao;
import com.telephone_station.api.dao.GenericDao;
import com.telephone_station.datamodel.Count;
import com.telephone_station.datamodel.CountState;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CountDaoImpl extends GenericDaoImpl<Count, Long> implements CountDao{

    public CountDaoImpl() {
        super(Count.class);
    }

    @Override
    public List<Count> getCountsByState(CountState state) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Count> query = cb.createQuery(clazz);        //result
        Root<Count> root = query.from(clazz);                    //source
        query.select(root);
        query.where(cb.equal(root.get("state"), state));
        return em.createQuery(query).getResultList();
    }
}
