package ru.neginskiy.tm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.neginskiy.tm.command.*;
import ru.neginskiy.tm.config.AppConfig;
import ru.neginskiy.tm.controller.Bootstrap;

public class App {

    private static final Class[] CLASSES = {ExitCommand.class, HelpCommand.class,
            TaskCreateCommand.class, TaskDeleteCommand.class, TaskEditCommand.class, TaskListCommand.class,
            ProjectCreateCommand.class, ProjectDeleteCommand.class, ProjectEditCommand.class, ProjectListCommand.class,
            UserCreateCommand.class, UserLoginCommand.class, UserLogoutCommand.class,
            DataBinLoadCommand.class, DataBinSaveCommand.class, DataJsonLoadCommand.class, DataJsonSaveCommand.class,
            DataXmlLoadCommand.class, DataXmlSaveCommand.class};

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        final Bootstrap bootstrap = context.getBean(Bootstrap.class);
        bootstrap.init(CLASSES);
    }
}
