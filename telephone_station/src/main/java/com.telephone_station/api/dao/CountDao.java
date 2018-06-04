package com.telephone_station.api.dao;

import com.telephone_station.datamodel.Count;
import com.telephone_station.datamodel.CountState;

import java.util.List;

public interface CountDao extends GenericDao<Count,Long> {
    public List<Count> getCountsByState(CountState state);
}
