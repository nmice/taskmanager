package ru.neginskiy.tm.api;

public interface ServiceLocator {

    IProjectService getProjectService();
    ISessionService getSessionService();
    ITaskService getTaskService();
    IUserService getUserService();

}
