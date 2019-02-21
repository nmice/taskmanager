package ru.neginskiy.tm.command;

public class DataJsonLoadCommand extends AbstractCommand {

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public void execute(){
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