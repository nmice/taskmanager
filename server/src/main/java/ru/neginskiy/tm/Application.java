package ru.neginskiy.tm;

import ru.neginskiy.tm.controller.Bootstrap;

public class Application {

    public static void main(String[] args) {
        final Bootstrap bt = new Bootstrap();
        bt.init();
       /*TODO
            +Endpoint registry from property,
            +final\ы
            +Collection EmptyList inline
            -JUnit сквозное тестирование с клиента на круды через эндпоинты,
            -jar in pom
        */
    }
}
