package ru.neginskiy.tm.command;

public class DataXmlSaveCommand extends AbstractCommand {

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public void execute(){
        getBootstrap().getDataEndpointService().saveDataXml(getBootstrap().getActiveSession(), getBootstrap().getActiveSession().getUser().getId());
        System.out.println("Project and task data saved to xml");
    }

    @Override
    public String command() {
        return "data-xml-save";
    }

    @Override
    public String description() {
        return "Save XML Data";
    }
}
