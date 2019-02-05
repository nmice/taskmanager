package ru.neginskiy.tm.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

    private static final String PROPERTY_FILE = "config.properties";
    public static String secretKey;
    public static int saltCounter;
    public static int sessionLifetime;
    public static String dbUrl;
    public static String dbUsername;
    public static String dbPassword;
    public static String dbDriver;

    static {
        final Properties properties = new Properties();
        final InputStream is = AppConfig.class.getClassLoader().getResourceAsStream(PROPERTY_FILE);

        try {
            properties.load(is);
            secretKey = properties.getProperty("secretKey");
            saltCounter = Integer.parseInt(properties.getProperty("saltCounter"));
            sessionLifetime = Integer.parseInt(properties.getProperty("sessionLifetime"));
            dbUrl = properties.getProperty("db.url");
            dbUsername = properties.getProperty("db.username");
            dbPassword = properties.getProperty("db.password");
            dbDriver = properties.getProperty("db.driver");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}