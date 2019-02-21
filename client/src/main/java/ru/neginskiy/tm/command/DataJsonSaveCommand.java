package ru.neginskiy.tm.command;

public class DataJsonSaveCommand extends AbstractCommand {

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public void execute(){
        getBootstrap().getDataEndpointService().saveDataJson(getBootstrap().getActiveSession(),
                getBootstrap().getActiveSession().getUser().getId());
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
