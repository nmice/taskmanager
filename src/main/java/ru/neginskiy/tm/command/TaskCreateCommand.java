package ru.neginskiy.tm.command;

import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.util.DateUtil;

import java.util.Date;
import java.util.Scanner;

public class TaskCreateCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("Please enter project ID for the task :");
        Scanner scanner = new Scanner(System.in);
        String projectID = scanner.nextLine();
        Project project = getBootstrap().getProjectService().getById(projectID);
        if (project == null) {
            System.out.println("Incorrect input, project not found");
            return;
        }

        System.out.println("Please enter a name of the task :");
        String name = getBootstrap().readLine();
        name = DateUtil.getCorrectStrOrDefault(name,"New Task");

        System.out.println("Please enter a description of the task :");
        String description = DateUtil.getCorrectStrOrDefault(description(),"New Description");

        System.out.println("Please enter a begin date in the format DD-MM-YYYY :");
        Date dateBegin = DateUtil.getDateBeginFromKbOrDefault();

        System.out.println("Please enter a end date in the format DD-MM-YYYY :");
        Date dateEnd = DateUtil.getDateBeginFromKbOrDefault();

        Task task = new Task();
        task.setProjectId(projectID);
        task.setName(name);
        task.setDescription(description);
        task.setDateBegin(dateBegin);
        task.setDateEnd(dateEnd);

        getBootstrap().getTaskService().merge(task);//todo readline
    }

    @Override
    public String command() {
        return "taskcreate";
    }

    @Override
    public String description() {
        return "Create a new task";
    }
}
