package ru.neginskiy.tm.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@ComponentScan/*("ru.neginskiy.tm")*/
@PropertySource("classpath:config.properties")
@EnableTransactionManagement
@EnableJpaRepositories("ru.neginskiy.tm.api.repository")

public class AppConfig {

    @Autowired
    private Environment env;

/*    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("ru.titov.taskmanagerserver.entity");
        final JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("datasource.url"));
        dataSource.setUsername(env.getProperty("datasource.login"));
        dataSource.setPassword(env.getProperty("datasource.password"));
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    private Properties additionalProperties() {
        final Properties properties = new Properties();
        properties.setProperty(Environment.HBM2DDL_AUTO, env.getProperty("datasource.hbm2ddlauto"));
        properties.setProperty(Environment.DIALECT, env.getProperty("datasource.dialect"));
        properties.setProperty(Environment.SHOW_SQL, env.getProperty("datasource.showSql"));
        return properties;
    }*/

    private static final String PROPERTY_FILE = "config.properties";
    public static String secretKey;
    public static int saltCounter;
    public static int sessionLifetime;
    public static String jdbcDriver;
    public static String url;
    public static String username;
    public static String password;
    public static String dbPrefix;
    public static String hDialect;
    public static String hShowWQL;
    public static String hbm2ddlAuto;
    public static String host;
    public static String port;

    static {
        final Properties properties = new Properties();
        final InputStream is = AppConfig.class.getClassLoader().getResourceAsStream(PROPERTY_FILE);

        try {
            properties.load(is);
            secretKey = properties.getProperty("secretKey");
            saltCounter = Integer.parseInt(properties.getProperty("saltCounter"));
            sessionLifetime = Integer.parseInt(properties.getProperty("sessionLifetime"));
            jdbcDriver = properties.getProperty("jdbc.driver");
            url = properties.getProperty("db.url");
            username = properties.getProperty("db.username");
            password = properties.getProperty("db.password");
            dbPrefix = properties.getProperty("db.prefix");
            hDialect = properties.getProperty("hibernate.dialect");
            hShowWQL = properties.getProperty("hibernate.showSQL");
            hbm2ddlAuto = properties.getProperty("hibernate.hbm2ddl.auto");
            host = properties.getProperty("host");
            port = properties.getProperty("port");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}