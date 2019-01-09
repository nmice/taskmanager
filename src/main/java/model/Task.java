package model;

import static util.TasksUtil.getNewId;

public class Task {

    private String description;

    private String project;

    private int id;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {

        return description;
    }

    public String getProject() {
        return project;
    }

    public int getId() {
        return id;
    }

    public Task(String description, String project) {
        this.description = description;
        this.project = project;
        this.id = getNewId();
    }

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", project='" + project + '\'' +
                ", id=" + id +
                '}';
    }
}
