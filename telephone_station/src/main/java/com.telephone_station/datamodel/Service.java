package com.telephone_station.datamodel;


import javax.persistence.Table;
import java.util.Objects;


@javax.persistence.Entity
@Table(name = "services")
public class Service extends Entity {

    private long price = 0;
    private String name;

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
