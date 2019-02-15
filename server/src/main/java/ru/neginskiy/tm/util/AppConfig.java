package ru.neginskiy.tm.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

    private static final String PROPERTY_FILE = "config.properties";
    public static String secretKey;
    public static int saltCounter;
    public static int sessionLifetime;
    public static String jdbcDriver;
    public static String url;
    public static String username;
    public static String password;
    public static String hDialect;
    public static String hShowWQL;
    public static String hbm2ddlAuto;
    public static String dbPrefix;

    static {
        final Properties properties = new Properties();
        final InputStream is = AppConfig.class.getClassLoader().getResourceAsStream(PROPERTY_FILE);

        try {
            properties.load(is);
            secretKey = properties.getProperty("secretKey");
            saltCounter = Integer.parseInt(properties.getProperty("saltCounter"));
            sessionLifetime = Integer.parseInt(properties.getProperty("sessionLifetime"));
            jdbcDriver = properties.getProperty("jdbc.driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            hDialect = properties.getProperty("hibernate.dialect");
            hShowWQL = properties.getProperty("hibernate.showSQL");
            hbm2ddlAuto = properties.getProperty("hibernate.hbm2ddl.auto");
            dbPrefix = properties.getProperty("db.prefix");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}