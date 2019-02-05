package ru.neginskiy.tm.command;

import ru.neginskiy.tm.endpoint.UncorrectSessionException_Exception;

public class DataBinLoadCommand extends AbstractCommand {

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public void execute() {
        try {
            getBootstrap().getDataEndpointService().loadDataBin(getBootstrap().getActiveSession(), getBootstrap().getActiveUser().getId());
        } catch (UncorrectSessionException_Exception e) {
            System.out.println("Uncorrect session, please log in");
        }
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
