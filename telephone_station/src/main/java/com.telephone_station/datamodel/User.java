package com.telephone_station.datamodel;


import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name="login")
    private String login;
    @Column(name="password")
    private String password;
    @Column(name="authority")
    @Enumerated(EnumType.STRING)
    private Authority authority;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
}
