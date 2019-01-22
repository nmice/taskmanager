package ru.neginskiy.tm.command;

import ru.neginskiy.tm.api.ICommand;
import ru.neginskiy.tm.controller.Bootstrap;

public abstract class AbstractCommand implements ICommand {

    private Bootstrap bootstrap;

    public Bootstrap getBootstrap() {
        return bootstrap;
    }

    public void setBootstrap(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    public abstract boolean isSecure();
}
