package ru.neginskiy.tm;

import ru.neginskiy.tm.controller.Bootstrap;

public class Application {

    public static void main(String[] args) {
        Bootstrap bt = new Bootstrap();
        bt.init();
       /*TODO
            +NotNull, Nullable
            +Lombok
            -Hibernate
            -тесты сессии через soapUI
        */
    }
}
