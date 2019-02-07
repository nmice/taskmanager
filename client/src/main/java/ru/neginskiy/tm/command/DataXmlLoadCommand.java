package ru.neginskiy.tm.command;

import ru.neginskiy.tm.endpoint.UncorrectSessionException_Exception;

public class DataXmlLoadCommand extends AbstractCommand {

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public void execute() {
        try {
            getBootstrap().getDataEndpointService().loadDataXml(getBootstrap().getActiveSession(), getBootstrap().getActiveUser().getId());
            System.out.println("Project and task data uploaded from xml");
        } catch (UncorrectSessionException_Exception e) {
            getBootstrap().setActiveUser(null);
            System.out.println("Uncorrect session, please log in");
        }
    }

    @Override
    public String command() {
        return "data-xml-load";
    }

    @Override
    public String description() {
        return "Load XML Data";
    }
}
