package ru.neginskiy.tm.api;

import ru.neginskiy.tm.api.service.IProjectService;
import ru.neginskiy.tm.api.service.ISessionService;
import ru.neginskiy.tm.api.service.ITaskService;
import ru.neginskiy.tm.api.service.IUserService;
import ru.neginskiy.tm.service.DataService;

import javax.persistence.EntityManagerFactory;

public interface ServiceLocator {

    IProjectService getProjectService();
    ISessionService getSessionService();
    ITaskService getTaskService();
    IUserService getUserService();
    DataService getDataService();
    EntityManagerFactory getEntityManagerFactory();
}
