package ru.neginskiy.tm.api;

import ru.neginskiy.tm.service.ProjectService;

public interface ServiceLocator {

    ProjectService getProjectService();

}
