package ru.neginskiy.tm;

import ru.neginskiy.tm.controller.Bootstrap;

import javax.enterprise.inject.se.SeContainerInitializer;

public class Application {

    public static void main(String[] args) {
        SeContainerInitializer.newInstance().addPackages(Application.class)
                .initialize().select(Bootstrap.class).get().init();
       /*TODO
            +WELD on Client
            +README change
            -DeltaSpike
            -Repo as interfaces
            -Transactional
        */
    }
}
