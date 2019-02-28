package ru.neginskiy.tm;

import ru.neginskiy.tm.command.*;
import ru.neginskiy.tm.controller.Bootstrap;

import javax.enterprise.inject.se.SeContainerInitializer;


public class App {

    private static final Class[] CLASSES = {ExitCommand.class, HelpCommand.class,
            TaskCreateCommand.class, TaskDeleteCommand.class, TaskEditCommand.class, TaskListCommand.class,
            ProjectCreateCommand.class, ProjectDeleteCommand.class, ProjectEditCommand.class, ProjectListCommand.class,
            UserCreateCommand.class, UserLoginCommand.class, UserLogoutCommand.class,
            DataBinLoadCommand.class, DataBinSaveCommand.class, DataJsonLoadCommand.class, DataJsonSaveCommand.class,
            DataXmlLoadCommand.class, DataXmlSaveCommand.class};

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        SeContainerInitializer
                .newInstance()
                .addPackages(App.class)
                .initialize()
                .select(Bootstrap.class)
                .get()
                .init(CLASSES);
    }
}
