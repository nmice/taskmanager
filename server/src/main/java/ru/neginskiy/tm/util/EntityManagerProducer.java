package ru.neginskiy.tm.util;

import org.apache.deltaspike.jpa.api.transaction.TransactionScoped;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EntityManagerProducer {

    @Inject
    EntityManagerFactory entityManagerFactory;

    @Produces
    @TransactionScoped
    public EntityManager create() {
        return entityManagerFactory.createEntityManager();
    }

    public void dispose (@Disposes EntityManager entityManager){
        if (entityManager.isOpen()){
            entityManager.close();
        }
    }
}
