package ru.neginskiy.tm;

import ru.neginskiy.tm.controller.Bootstrap;

public class Application {

    public static void main(String[] args) {
        Bootstrap bt = new Bootstrap();
        bt.init();
       /*TODO
         +В репо всех прописать фетч и файнал,
         +Апперкейс переменных поменять в аппконфиг
         +SessionRepo, UserRepo закрыть дыры
         +boolean validate return поменять на void Validate throw new exception
         -Сериализация - save, load*/
    }
}
