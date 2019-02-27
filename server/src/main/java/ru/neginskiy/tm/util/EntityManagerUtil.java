package ru.neginskiy.tm.util;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EntityManagerUtil {

    @Inject
    EntityManagerFactory entityManagerFactory;

    @Produces
    public EntityManager getEntityManager(final EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }
}
