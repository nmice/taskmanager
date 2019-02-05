package ru.neginskiy.tm.api;

import ru.neginskiy.tm.service.DataService;

public interface ServiceLocator {

    IProjectService getProjectService();
    ISessionService getSessionService();
    ITaskService getTaskService();
    IUserService getUserService();
    DataService getDataService();
}