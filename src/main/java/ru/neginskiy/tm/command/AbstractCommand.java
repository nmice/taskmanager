package ru.neginskiy.tm.command;

import ru.neginskiy.tm.controller.Bootstrap;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public abstract class AbstractCommand {

    private Bootstrap bootstrap;

    public abstract void execute();

    public abstract String command();

    public abstract String description();

    public Bootstrap getBootstrap() {
        return bootstrap;
    }

    public void setBootstrap(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }
}
