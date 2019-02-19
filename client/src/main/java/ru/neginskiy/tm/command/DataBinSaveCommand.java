package ru.neginskiy.tm.command;

import ru.neginskiy.tm.endpoint.UncorrectSessionException_Exception;

public class DataBinSaveCommand extends AbstractCommand {

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public void execute() throws UncorrectSessionException_Exception {
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
