package ru.neginskiy.tm;

import ru.neginskiy.tm.controller.Bootstrap;

public class Application {

    public static void main(String[] args) {
        Bootstrap bt = new Bootstrap();
        bt.init();
       /*TODO
            -Сериализация - save, load XML JSON через FASTERXML
            -Вынести в bootstrap логику ошибки по сессии
            +Try-Catch вынести на UI из сервисов
            -MyBatis
        */
    }
}
