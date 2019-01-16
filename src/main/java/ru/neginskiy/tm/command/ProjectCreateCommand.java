package ru.neginskiy.tm.command;

import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.util.DateUtil;

import java.util.Date;

public class ProjectCreateCommand extends AbstractCommand {

    @Override
    public void execute() {
        Project project = new Project();

        System.out.println("Please enter a name of the project :");
        String name = getBootstrap().readLine();
        project.setName(DateUtil.getCorrectStrOrDefault(name, "New Project"));

        System.out.println("Please enter a description of the project :");
        String description = getBootstrap().readLine();
        project.setDescription(DateUtil.getCorrectStrOrDefault(description,"New Description"));

        System.out.println("Please enter a begin date in the format DD-MM-YYYY :");
        project.setDateBegin(DateUtil.getDateBeginFromKbOrDefault());

        System.out.println("Please enter a end date in the format DD-MM-YYYY :");
        Date dateEnd = DateUtil.getDateEndFromKbOrDefault();
        project.setDateEnd(dateEnd);

        if (dateEnd.compareTo(dateBegin) < 0) {
            System.out.println("End date must be later than the begin date, the default task date is one day");
            dateEnd = new Date(System.currentTimeMillis() + ONE_DAY);
        }

        getBootstrap().getProjectService().merge(project);
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
