package com.telephone_station.datamodel;

public enum Authority {
    USER("USER"),
    ADMIN("ADMIN"),
    DISPATCHER("DISPATCHER");
    private String authority;
    Authority(String line){
        authority = line;
    }
    @Override
    public String toString(){
        return authority;
    }
}
