package ru.neginskiy.tm.command;

import ru.neginskiy.tm.util.DateUtil;

import java.util.Date;
import java.util.Scanner;

public class TaskEditCommand extends AbstractCommand {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter task ID to update: ");
        String id = scanner.nextLine();
        System.out.println(getBootstrap().getTaskService().getById(id));
        System.out.println("Enter the command: \r\n" +
                "changename        - change name of Task \r\n" +
                "changedescription - change description of Task \r\n" +
                "changeenddate     - change a end date of Task");
        String updateCommandString = scanner.nextLine().toLowerCase().trim();
        switch (updateCommandString) {
            case "changename":
                System.out.println("Please enter a new task name: ");
                String name = scanner.nextLine();
                getBootstrap().getTaskService().updateName(id, name);
            case "changedescription":
                System.out.println("Please enter a new task description: ");
                String description = scanner.nextLine();
                getBootstrap().getTaskService().updateDescription(id, description);
            case "changeenddate":
                System.out.println("Please enter a new task end date: ");
                Date endDate = DateUtil.getDateBeginFromKbOrDefault();
                getBootstrap().getTaskService().updateEndDate(id, endDate);
        }
    }

    @Override
    public String command() {
        return "taskedit";
    }

    @Override
    public String description() {
        return "Edit task";
    }
}
