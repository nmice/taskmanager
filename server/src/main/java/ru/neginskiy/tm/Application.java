package ru.neginskiy.tm;

import ru.neginskiy.tm.controller.Bootstrap;

import javax.enterprise.inject.se.SeContainerInitializer;

public class Application {

    public static void main(String[] args) {
        SeContainerInitializer.newInstance().addPackages(Application.class)
                .initialize().select(Bootstrap.class).get().init();
       /*TODO
            +hibernate
            +Endpoint registry from property,
            +final\ы
            +Collection EmptyList inline
            +JUnit сквозное тестирование с клиента на круды через эндпоинты
            +jar in pom
            -WELD
            -README change
            -DeltaSpike
        */
    }
}
