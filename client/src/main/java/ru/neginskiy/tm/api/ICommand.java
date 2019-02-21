package ru.neginskiy.tm.api;

import ru.neginskiy.tm.endpoint.UncorrectSessionException_Exception;

public interface ICommand {

    void execute() throws UncorrectSessionException_Exception;

    String command();

    String description();
}
