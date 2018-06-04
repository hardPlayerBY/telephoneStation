package com.telephone_station.api.dao;

import com.telephone_station.datamodel.User;

public interface UserDao extends GenericDao<User, String> {
    User get(String login, String password);
}

