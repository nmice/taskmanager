package ru.neginskiy.tm.command;

import ru.neginskiy.tm.endpoint.Project;
import ru.neginskiy.tm.endpoint.Task;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;

import static ru.neginskiy.tm.util.StrToGcUtil.getGcFromStr;

public class TaskCreateCommand extends AbstractCommand {

    private final boolean secure = false;

    @Override
    public void execute() {
        List<Project> projectList = getBootstrap().getProjectEndpointService().projectGetAll();
        if (projectList.size() == 0) {
            System.out.println("Projects not found, please create a project first for the task");
            return;
        }

        System.out.println("Please select project number for the task :");
        int indexOfProject = 0;
        for (Project project : projectList) {
            System.out.printf("%-3s%s%s%n", indexOfProject++, " - ", project.getName());
        }

        Project project;
        try {
            int projectNumber = Integer.parseInt(getBootstrap().readLine());
            project = projectList.get(projectNumber);
            if (project == null) {
                System.out.println("Incorrect input, project not found");
                return;
            }
        } catch (Exception e) {
            System.out.println("Incorrect input, project not found");
            return;
        }
        String projectId = project.getId();

        Task task = new Task();
        task.setProjectId(projectId);

        System.out.println("Please enter a name of the task :");
        String name = getBootstrap().readLine();
        task.setName(name);

        System.out.println("Please enter a description of the task :");
        String description = getBootstrap().readLine();
        task.setDescription(description);

        System.out.println("Please enter a begin date in the format DD-MM-YYYY :");
        XMLGregorianCalendar dateBegin = getGcFromStr(getBootstrap().readLine());
        if (dateBegin == null) {
            System.out.println("Invalid date or format");
        }
        task.setDateBegin(dateBegin);

        System.out.println("Please enter a end date in the format DD-MM-YYYY :");
        XMLGregorianCalendar dateEnd = getGcFromStr(getBootstrap().readLine());
        if (dateEnd == null) {
            System.out.println("Invalid date or format");
        }

        if (dateBegin != null && dateEnd != null && dateEnd.compare(dateBegin)<0) {
            System.out.println("Incorrect input: End date must be later than the begin date!");
            task.setDateEnd(null);
        }
        task.setDateEnd(dateEnd);

        if (name == null && description == null && dateBegin == null && dateEnd == null) {
            System.out.println("All fields are empty, new task is not created!");
            return;
        }

        getBootstrap().getTaskEndpointService().taskMerge(task);
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

    @Override
    public boolean isSecure() {
        return secure;
    }
}




