package ru.neginskiy.tm.command;

import ru.neginskiy.tm.endpoint.UncorrectSessionException_Exception;

public class DataJsonLoadCommand extends AbstractCommand {

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public void execute() throws UncorrectSessionException_Exception {
        getBootstrap().getDataEndpointService().loadDataJson(getBootstrap().getActiveSession(), getBootstrap().getActiveSession().getUser().getId());
        System.out.println("Project and task data uploaded from json");
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