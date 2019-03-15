package ru.neginskiy.tm.api;

public interface ICommand {

    void execute();

    String command();

    String description();
}
