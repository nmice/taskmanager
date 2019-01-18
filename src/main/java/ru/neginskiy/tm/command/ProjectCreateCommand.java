package ru.neginskiy.tm.command;

import ru.neginskiy.tm.entity.Project;

import java.util.Date;

import static ru.neginskiy.tm.util.StringToDateUtil.getDateFromStr;

public class ProjectCreateCommand extends AbstractCommand {

    @Override
    public void execute() {
        Project project = new Project();

        System.out.println("Please enter a name of the project :");
        String name = getBootstrap().readLine();
        project.setName(name);

        System.out.println("Please enter a description of the project :");
        String description = getBootstrap().readLine();
        project.setDescription(description);

        System.out.println("Please enter a begin date in the format DD-MM-YYYY :");
        Date dateBegin = getDateFromStr(getBootstrap().readLine());
        if (dateBegin == null){
            System.out.println("Invalid date or format");
        }
        project.setDateBegin(dateBegin);

        System.out.println("Please enter a end date in the format DD-MM-YYYY :");
        Date dateEnd = getDateFromStr(getBootstrap().readLine());
        if (dateEnd == null){
            System.out.println("Invalid date or format");
        }
        project.setDateEnd(dateEnd);

        if (dateBegin != null && dateEnd != null && dateEnd.compareTo(dateBegin) < 0) {
            System.out.println("Incorrect input: End date must be later than the begin date!");
            project.setDateEnd(null);
        }

        if (name == null && description == null && dateBegin == null && dateEnd == null) {
            System.out.println("All fields are empty, new project is not created!");
            return;
        }

        getBootstrap().getProjectService().merge(project);
        System.out.println("New project created");
    }

    @Override
    public String command() {
        return "projectcreate";
    }

    @Override
    public String description() {
        return "Create a new project";
    }
}
