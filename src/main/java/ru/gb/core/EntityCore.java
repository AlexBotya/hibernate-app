package ru.gb.core;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EntityCore {
    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static EntityManager start() {
    factory = new Configuration().configure("hibernate.cfg.xml")
            .buildSessionFactory();
    EntityManager entityManager = factory.createEntityManager();
        return entityManager;
    }
    public EntityManagerFactory getFactory() {
        return factory;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
