package ru.neginskiy.tm;

import ru.neginskiy.tm.controller.Bootstrap;

public class Application {

    public static void main(String[] args) {
        Bootstrap bt = new Bootstrap();
        bt.init();
       /*TODO
            +Сериализация JSON
            +Сериализация - save, load XML через FASTERXML
            +Выпилить Юзера
            +Вынести в bootstrap логику ошибки по сессии Try-Catch
            +Пример с Сериализацией Date
            -MyBatis
            -throw sqlEx переместить из репо в сервисы
            -тестить сессию через soapUI
        */
    }
}
