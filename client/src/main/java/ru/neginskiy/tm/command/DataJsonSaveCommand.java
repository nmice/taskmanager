package ru.neginskiy.tm.command;

import ru.neginskiy.tm.endpoint.UncorrectSessionException_Exception;

public class DataJsonSaveCommand extends AbstractCommand {

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public void execute() throws UncorrectSessionException_Exception {
        getBootstrap().getDataEndpointService().saveDataJson(getBootstrap().getActiveSession(), getBootstrap().getActiveSession().getUserId());
        System.out.println("Project and task data saved to json");
    }

    @Override
    public String command() {
        return "data-json-save";
    }

    @Override
    public String description() {
        return "Save Json Data";
    }
}
