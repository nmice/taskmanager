package ru.neginskiy.tm.command;

import ru.neginskiy.tm.endpoint.UncorrectSessionException_Exception;

public class DataJsonLoadCommand extends AbstractCommand {

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public void execute() {
        try {
            getBootstrap().getDataEndpointService().loadDataJson(getBootstrap().getActiveSession(), getBootstrap().getActiveUser().getId());
            System.out.println("Project and task data uploaded from json");
        } catch (UncorrectSessionException_Exception e) {
            getBootstrap().setActiveUser(null);
            System.out.println("Uncorrect session, please log in");
        }
    }

    @Override
    public String command() {
        return "data-json-load";
    }

    @Override
    public String description() {
        return "Load Json Data";
    }
}
