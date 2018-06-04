package com.telephone_station.api.dao;

import com.telephone_station.datamodel.Service;

import java.util.List;

public interface ServiceDao extends GenericDao<Service,Long> {
    List<Service> getByPrice(long price);
    Service getByName(String name);
}
