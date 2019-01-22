package ru.neginskiy.tm.command;

import ru.neginskiy.tm.endpoint.Project;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;

import static ru.neginskiy.tm.util.StrToGcUtil.getGcFromStr;

public class ProjectEditCommand extends AbstractCommand {

    private final boolean secure = false;

    @Override
    public void execute() {
        System.out.println("Please select project number to update :");
        List<Project> projectList = getBootstrap().getProjectEndpointService().projectGetAllByUserId(getBootstrap().getActiveUser().getId());
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
            System.out.println(project);
        } catch (Exception e) {
            System.out.println("Incorrect input, project not found");
            return;
        }

        System.out.println("Enter the command for update: \r\n" +
                "changename        - Change name of project \r\n" +
                "changedescription - Change description of project \r\n" +
                "changebegindate   - Change a begin date of project \r\n" +
                "changeenddate     - Change a end date of project");
        String updateCommandString = getBootstrap().readLine();
        switch (updateCommandString) {
            case "changename":
                System.out.println("Please enter a new project name: ");
                String name = getBootstrap().readLine();
                project.setName(name);
                System.out.println("Name changed");
                break;
            case "changedescription":
                System.out.println("Please enter a new project description: ");
                String description = getBootstrap().readLine();
                project.setDescription(description);
                System.out.println("Description changed");
                break;
            case "changebegindate":
                System.out.println("Please enter a new project begin date: ");
                XMLGregorianCalendar dateBegin = getGcFromStr(getBootstrap().readLine());
                if (dateBegin == null) {
                    return;
                }

                XMLGregorianCalendar dateEnd = project.getDateEnd();
                if (dateEnd != null && dateEnd.getMillisecond() < dateBegin.getMillisecond()) {
                    System.out.println("End date must be later than the begin date, incorrect input");
                    return;
                }
                project.setDateBegin(dateBegin);
                System.out.println("Begin date changed");
                break;
            case "changeenddate":
                System.out.println("Please enter a new project end date: ");
                dateEnd = getGcFromStr(getBootstrap().readLine());
                if (dateEnd == null) {
                    return;
                }
                dateBegin = project.getDateBegin();
                if (dateBegin != null && dateEnd.getMillisecond() < dateBegin.getMillisecond()) {
                    System.out.println("End date must be later than the begin date, incorrect input");
                    return;
                }
                project.setDateEnd(dateEnd);
                System.out.println("End date changed");
                break;
        }
        getBootstrap().getProjectEndpointService().projectMerge(project);
        System.out.println("Project updated");
    }

    @Override
    public String command() {
        return "projectedit";
    }

    @Override
    public String description() {
        return "Edit project";
    }

    @Override
    public boolean isSecure() {
        return secure;
    }
}
