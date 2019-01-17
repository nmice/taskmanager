package ru.neginskiy.tm.command;

import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.entity.Task;

import java.util.Date;
import java.util.List;

import static ru.neginskiy.tm.util.StringToDateUtil.getDateFromStr;

public class TaskCreateCommand extends AbstractCommand {

    @Override
    public void execute() {
        Task task = new Task();

        System.out.println("Please select project number for the task :");
        List<Project> projectList = getBootstrap().getProjectService().getAll();
        int indexOfProject = 0;
        for (Project project : projectList) {
            System.out.printf("%-3s%s%s%n", indexOfProject++, " - ", project.getName());
        }

        int projectNumber;
        String projectId;
        try {
            projectNumber = Integer.parseInt(getBootstrap().readLine());
            Project project = projectList.get(projectNumber);
            if (project == null) {
                System.out.println("Incorrect input, project not found");
                return;
            }
            projectId = project.getId();
        } catch (Exception e) {
            System.out.println("Incorrect input, project not found");
            return;
        }
        task.setProjectId(projectId);

        System.out.println("Please enter a name of the task :");
        String name = getBootstrap().readLine();
        task.setName(name);

        System.out.println("Please enter a description of the task :");
        String description = getBootstrap().readLine();
        task.setDescription(description);

        System.out.println("Please enter a begin date in the format DD-MM-YYYY :");
        Date dateBegin = getDateFromStr(getBootstrap().readLine());
        task.setDateBegin(dateBegin);

        System.out.println("Please enter a end date in the format DD-MM-YYYY :");
        Date dateEnd = getDateFromStr(getBootstrap().readLine());
        task.setDateEnd(dateEnd);

        if (dateBegin != null && dateEnd != null && dateEnd.compareTo(dateBegin) < 0) {
            System.out.println("End date must be later than the begin date, incorrect input");
            task.setDateEnd(null);
        }

        getBootstrap().getTaskService().merge(task);
        System.out.println("New task created");
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
