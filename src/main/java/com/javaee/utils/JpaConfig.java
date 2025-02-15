package com.javaee.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaConfig {
    public static final String PERSISTANCE_UNIT = "persistence-unit";

    private static final EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT);
    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}
