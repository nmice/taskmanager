package ru.neginskiy.tm.command;

public class DataXmlLoadCommand extends AbstractCommand {

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public void execute(){
        getBootstrap().getDataEndpointService().loadDataXml(getBootstrap().getActiveSession(), getBootstrap().getActiveSession().getUser().getId());
        System.out.println("Project and task data uploaded from xml");
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
