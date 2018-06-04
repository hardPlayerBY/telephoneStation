package com.telephone_station.datamodel;

import java.util.ArrayList;
import java.util.List;

public class Count extends Entity {

    private List<Service> services = new ArrayList<Service>();

    private User user;

    private CountState state= CountState.ClOSE;

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CountState getState() {
        return state;
    }

    public void setState(CountState state) {
        this.state = state;
    }
}
