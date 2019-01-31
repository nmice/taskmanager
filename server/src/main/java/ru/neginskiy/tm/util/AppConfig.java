package ru.neginskiy.tm.util;

import ru.neginskiy.tm.entity.Session;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

    private static final String PROPERTY_FILE = "/config.properties";

    public static String SECRET_KEY;

    public static int SALT_COUNTER;

    public void init() {
        final InputStream is = getClass().getResourceAsStream(PROPERTY_FILE);
        final Properties properties = new Properties();
        try {
            properties.load(is);
            SECRET_KEY = properties.getProperty("secretKey");
            SALT_COUNTER = Integer.parseInt(properties.getProperty("saltCounter"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




