package ru.neginskiy.tm.command;

public class DataBinLoadCommand extends AbstractCommand{

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public void execute() {
        getBootstrap().getDataEndpointService().loadDataBin(getBootstrap().getActiveSession(), getBootstrap().getActiveUser().getId());
    }

    @Override
    public String command() {
        return "data-bin-load";
    }

    @Override
    public String description() {
        return "Load Bin Data";
    }
}
