package ru.neginskiy.tm.command;

import ru.neginskiy.tm.util.DateUtil;

import java.util.Date;
import java.util.Scanner;

public class ProjectCreateCommand extends AbstractCommand {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a name of the project :");
        String name = scanner.nextLine();

        System.out.println("Please enter a description of the project :");
        String description = scanner.nextLine();

        System.out.println("Please enter a begin date in the format DD-MM-YYYY :");
        Date dateBegin = DateUtil.getFormattedDateFromKb("begin date", "dd-MM-yyyy");

        System.out.println("Please enter a end date in the format DD-MM-YYYY :");
        Date dateEnd = DateUtil.getFormattedDateFromKb("begin date", "dd-MM-yyyy");

        getBootstrap().getProjectService().createProject(name, description, dateBegin, dateEnd);
    }

    @Override
    public String command() {
        return "projectcreate";
    }

    @Override
    public String description() {
        return " - Create a new project";
    }
}
