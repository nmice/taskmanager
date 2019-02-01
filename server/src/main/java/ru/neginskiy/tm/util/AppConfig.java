package ru.neginskiy.tm.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

    private static final String PROPERTY_FILE = "config.properties";
    public static String SECRET_KEY;
    public static int SALT_COUNTER;
    public static String DB_URL;
    public static String DB_USERNAME;
    public static String DB_PASSWORD;
    public static String DB_DRIVER;

    public static void init() {
        final Properties properties = new Properties();
        final InputStream is = AppConfig.class.getClassLoader().getResourceAsStream(PROPERTY_FILE);

        try {
            properties.load(is);
            SECRET_KEY = properties.getProperty("secretKey");
            SALT_COUNTER = Integer.parseInt(properties.getProperty("saltCounter"));
            DB_URL = properties.getProperty("db.url");
            DB_USERNAME = properties.getProperty("db.username");
            DB_PASSWORD = properties.getProperty("db.password");
            DB_DRIVER = properties.getProperty("db.driver");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}