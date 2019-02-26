package ru.neginskiy.tm;

import ru.neginskiy.tm.controller.Bootstrap;

import javax.enterprise.inject.se.SeContainerInitializer;

public class Application {

    public static void main(String[] args) {
        /*final Bootstrap bt = new Bootstrap();
        bt.init();*/
        SeContainerInitializer.newInstance()  .addPackages(Application.class).initialize().select(Bootstrap.class).get().init();
       /*TODO
            +hibernate
            +Endpoint registry from property,
            +final\ы
            +Collection EmptyList inline
            +JUnit сквозное тестирование с клиента на круды через эндпоинты
            +jar in pom
            +README change
            -WELD
            -DeltaSpike
        */
    }
}
