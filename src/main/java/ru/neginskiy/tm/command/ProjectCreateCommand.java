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
        project.setDateBegin(dateBegin);

        System.out.println("Please enter a end date in the format DD-MM-YYYY :");
        Date dateEnd = getDateFromStr(getBootstrap().readLine());
        project.setDateEnd(dateEnd);

        if (dateBegin != null && dateEnd != null && dateEnd.compareTo(dateBegin) < 0) {
            System.out.println("End date must be later than the begin date, incorrect input");
            project.setDateEnd(null);
        }

/*
        if (name == null && description == null && dateBegin == null && dateEnd == null){
            System.out.println("New project not created!");
            return;
        }
*/

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
