package ru.neginskiy.tm.domain;

import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.entity.Task;

import java.util.List;

public class Domain {

    private List<Project> projectList;
    private List<Task> taskList;

    public Domain(List<Project> projectList, List<Task> taskList) {
        this.projectList = projectList;
        this.taskList = taskList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
