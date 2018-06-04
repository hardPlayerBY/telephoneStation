package com.telephone_station.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class HibernetUtil {
    private static final String PERSISTENT_UNIT_NAME = "station";

    private static final EntityManagerFactory factory;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            factory = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public static void close() {
        factory.close();
    }
}
