package ru.neginskiy.tm.command;

import ru.neginskiy.tm.util.DateUtil;

import java.util.Date;
import java.util.Scanner;

public class TaskCreateCommand extends AbstractCommand {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a name of the task :");
        String name = scanner.nextLine();

        System.out.println("Please enter a description of the task :");
        String description = scanner.nextLine();

        System.out.println("Please enter a begin date in the format DD-MM-YYYY :");
        Date dateBegin = DateUtil.getFormattedDateFromKb("begin date", "dd-MM-yyyy");

        System.out.println("Please enter a end date in the format DD-MM-YYYY :");
        Date dateEnd = DateUtil.getFormattedDateFromKb("begin date", "dd-MM-yyyy");

        System.out.println("Please enter project ID :");
        String projectID = scanner.nextLine();

        getBootstrap().getTaskService().createTask(name, description, dateBegin, dateEnd, projectID);
    }

    @Override
    public String command() {
        return "taskcreate";
    }

    @Override
    public String description() {
        return " - Create a new task";
    }
}
