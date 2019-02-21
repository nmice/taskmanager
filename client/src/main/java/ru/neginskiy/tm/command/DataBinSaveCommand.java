package ru.neginskiy.tm.command;

public class DataBinSaveCommand extends AbstractCommand {

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public void execute(){
        getBootstrap().getDataEndpointService().saveDataBin(getBootstrap().getActiveSession(), getBootstrap().getActiveSession().getUser().getId());
        System.out.println("Project and task data saved to bin");
    }

    @Override
    public String command() {
        return "data-bin-save";
    }

    @Override
    public String description() {
        return "Save Bin Data";
    }
}
