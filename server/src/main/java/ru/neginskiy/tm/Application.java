package ru.neginskiy.tm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.neginskiy.tm.controller.Bootstrap;
import ru.neginskiy.tm.util.AppConfig;

public class Application {

    public static void main(String[] args) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        final Bootstrap bootstrap = context.getBean(Bootstrap.class);
        bootstrap.init();
    }
}
