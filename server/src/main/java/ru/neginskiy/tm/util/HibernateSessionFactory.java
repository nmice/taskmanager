package ru.neginskiy.tm.util;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.jetbrains.annotations.NotNull;
import ru.neginskiy.tm.entity.*;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;

import static ru.neginskiy.tm.util.AppConfig.*;

public class HibernateSessionFactory {

    private static final Class[] ANNOTATION_CLASSES = {User.class, Task.class,
            Project.class, Session.class};

    @Produces
    //@ApplicationScoped
    public static @NotNull EntityManager createEntityManager() {
        final Map<String, String> settings = new HashMap<>();
        settings.put(Environment.DRIVER, jdbcDriver);
        settings.put(Environment.URL, url);
        settings.put(Environment.USER, username);
        settings.put(Environment.PASS, password);
        settings.put(Environment.DIALECT, hDialect);
        settings.put(Environment.HBM2DDL_AUTO, hbm2ddlAuto);
        settings.put(Environment.SHOW_SQL, hShowWQL);
        final StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
        registryBuilder.applySettings(settings);
        final StandardServiceRegistry registry = registryBuilder.build();
        final MetadataSources sources = new MetadataSources(registry);
        for (Class anotationClass : ANNOTATION_CLASSES) {
            sources.addAnnotatedClass(anotationClass);
        }
        final Metadata metadata = sources.getMetadataBuilder().build();
        return metadata.getSessionFactoryBuilder().build().createEntityManager();
    }

}
