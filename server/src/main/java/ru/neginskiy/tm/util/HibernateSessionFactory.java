package ru.neginskiy.tm.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import ru.neginskiy.tm.entity.*;

import java.util.HashMap;
import java.util.Map;

import static ru.neginskiy.tm.util.AppConfig.*;

public class HibernateSessionFactory {


    public static SessionFactory sessionFactory;

    public static void buildFactory() {

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

        sources.addAnnotatedClass(Task.class);

        sources.addAnnotatedClass(User.class);

        sources.addAnnotatedClass(Session.class);

        sources.addAnnotatedClass(Project.class);

        final Metadata metadata = sources.getMetadataBuilder().build();

        sessionFactory = metadata.getSessionFactoryBuilder().build();

    }
}
