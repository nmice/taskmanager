package ru.neginskiy.tm.command;

import ru.neginskiy.tm.endpoint.UncorrectSessionException_Exception;

public class DataJsonSaveCommand extends AbstractCommand {

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public void execute() {
        try {
            getBootstrap().getDataEndpointService().saveJsonBin(getBootstrap().getActiveSession(), getBootstrap().getActiveUser().getId());
            System.out.println("Project and task data saved from json");
        } catch (UncorrectSessionException_Exception e) {
            getBootstrap().setActiveUser(null);
            System.out.println("Uncorrect session, please log in");
        }
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
