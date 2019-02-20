package ru.neginskiy.tm;

import ru.neginskiy.tm.controller.Bootstrap;

public class Application {

    public static void main(String[] args) {
        Bootstrap bt = new Bootstrap();
        bt.init();
       /*TODO
            -Endpoint registry from property,
            -JUnit сквозное тестирование с клиента на круды через эндпоинты,
            -final\ы
            +Collection EmptyList inline
        */
    }
}
