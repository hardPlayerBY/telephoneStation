package com.telephone_station.dao;

import com.telephone_station.api.dao.UserDao;
import com.telephone_station.datamodel.User;

public class UserDaoImpl extends GenericDaoImpl<User, String> implements UserDao{
    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User get(String login, String password) {
        User user = super.get(login);
        return user==null ? user : user.getPassword().equals(password) ? user : null;
    }

    @Override
    public User get(String key){
        throw new NullPointerException();
    }
}