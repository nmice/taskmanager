package ru.neginskiy.tm;

import ru.neginskiy.tm.controller.Bootstrap;

public class Application {

    public static void main(String[] args) {
        Bootstrap bt = new Bootstrap();
        bt.init();
       /*TODO boolean isUncorrectSession return поменять на void Validate throw new exception ,
         +В репо всех прописать фетч и файнал,
         +Апперкейс переменных поменять в аппконфиг
         SessionRepo и UserRepo - закрыть дыры (валидация сессии даже там)
         Сериализация - save, load*/
    }
}
