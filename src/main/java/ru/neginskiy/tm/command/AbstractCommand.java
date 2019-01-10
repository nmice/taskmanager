package ru.neginskiy.tm.command;

public abstract class AbstractCommand {

    public abstract void execute();

    public abstract String command();

    public abstract String description();
}
