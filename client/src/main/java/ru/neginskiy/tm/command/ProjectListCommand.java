package ru.neginskiy.tm.command;

import ru.neginskiy.tm.endpoint.Project;

import java.util.List;

import static ru.neginskiy.tm.util.GcToStrUtil.getStrFromGc;

public class ProjectListCommand extends AbstractCommand {

    private final boolean secure = false;

    @Override
    public void execute() {
        List<Project> projectList = getBootstrap().getProjectEndpointService().projectGetAllByUserId(getBootstrap().getActiveUser().getId());
        if (projectList.size() == 0) {
            System.out.println("Projects not found");
            return;
        }
        for (Project project : projectList) {
            System.out.printf("%s (%s), %s - %s%n", project.getName(), project.getDescription(), getStrFromGc(project.getDateBegin()), getStrFromGc(project.getDateEnd()));

        }
    }

    @Override
    public String command() {
        return "projectlist";
    }

    @Override
    public String description() {
        return "Get project list";
    }

    @Override
    public boolean isSecure() {
        return secure;
    }
}
