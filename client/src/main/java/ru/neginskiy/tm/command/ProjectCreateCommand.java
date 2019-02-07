package ru.neginskiy.tm.command;

import ru.neginskiy.tm.endpoint.Project;
import ru.neginskiy.tm.endpoint.UncorrectSessionException_Exception;

import javax.xml.datatype.XMLGregorianCalendar;

import static ru.neginskiy.tm.util.StrToGcUtil.getGcFromStr;

public class ProjectCreateCommand extends AbstractCommand {

    private final boolean secure = false;

    @Override
    public void execute() throws UncorrectSessionException_Exception {
        Project project = new Project();
        project.setUserId(getBootstrap().getActiveSession().getUserId());

        System.out.println("Please enter a name of the project :");
        String name = getBootstrap().readLine();
        project.setName(name);

        System.out.println("Please enter a description of the project :");
        String description = getBootstrap().readLine();
        project.setDescription(description);

        System.out.println("Please enter a begin date in the format DD-MM-YYYY :");
        XMLGregorianCalendar dateBegin = getGcFromStr(getBootstrap().readLine());
        if (dateBegin == null) {
            System.out.println("Invalid date or format");
        }
        project.setDateBegin(dateBegin);

        System.out.println("Please enter a end date in the format DD-MM-YYYY :");
        XMLGregorianCalendar dateEnd = getGcFromStr(getBootstrap().readLine());
        if (dateEnd == null) {
            System.out.println("Invalid date or format");
        }

        if (dateBegin != null && dateEnd != null && dateEnd.compare(dateBegin) < 0) {
            System.out.println("Incorrect input: End date must be later than the begin date!");
            project.setDateEnd(null);
        }
        project.setDateEnd(dateEnd);

        if (name == null && description == null && dateBegin == null && dateEnd == null) {
            System.out.println("All fields are empty, new project is not created!");
            return;
        }

        getBootstrap().getProjectEndpointService().projectMerge(getBootstrap().getActiveSession(), project);
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

    @Override
    public boolean isSecure() {
        return secure;
    }
}
