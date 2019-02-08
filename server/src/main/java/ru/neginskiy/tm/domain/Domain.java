package ru.neginskiy.tm.domain;

import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.entity.Task;

import java.io.Serializable;
import java.util.List;

public class Domain implements Serializable {

    private List<Project> projectList;
    private List<Task> taskList;

    public Domain() {
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

}
