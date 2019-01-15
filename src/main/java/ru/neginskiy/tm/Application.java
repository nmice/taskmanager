package ru.neginskiy.tm;

import ru.neginskiy.tm.command.*;
import ru.neginskiy.tm.controller.Bootstrap;

public class Application {

    private static final Class[] CLAZZ = {ExitCommand.class, HelpCommand.class,
            TaskCreateCommand.class, TaskDeleteCommand.class, TaskEditCommand.class, TaskListCommand.class,
            ProjectCreateCommand.class, ProjectDeleteCommand.class, ProjectEditCommand.class, ProjectListCommand.class};

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Bootstrap bt = new Bootstrap();
        bt.init(CLAZZ);
    }
}
