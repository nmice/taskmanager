package ru.neginskiy.tm.domain;

import ru.neginskiy.tm.dto.ProjectJsonDTO;
import ru.neginskiy.tm.dto.TaskJsonDTO;
import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class Domain {

    private List<ProjectJsonDTO> projectJsonDTOList;
    private List<TaskJsonDTO> taskJsonDTOList;

    public Domain() {
    }

    public Domain(List<ProjectJsonDTO> projectJsonDTOList, List<TaskJsonDTO> taskJsonDTOList) {
        this.projectJsonDTOList = projectJsonDTOList;
        this.taskJsonDTOList = taskJsonDTOList;
    }

    public List<ProjectJsonDTO> getProjectJsonDTOList() {
        return projectJsonDTOList;
    }

    public List<TaskJsonDTO> getTaskJsonDTOList() {
        return taskJsonDTOList;
    }

    public void setProjectJsonDTOList(List<ProjectJsonDTO> projectJsonDTOList) {
        this.projectJsonDTOList = projectJsonDTOList;
    }

    public void setTaskJsonDTOList(List<TaskJsonDTO> taskJsonDTOList) {
        this.taskJsonDTOList = taskJsonDTOList;
    }

    public List<Project> createProjectList() {
        List<ProjectJsonDTO> projectJsonDTOS = getProjectJsonDTOList();
        List<Project> projects = new ArrayList<>();
        Project project;
        for (ProjectJsonDTO projectJsonDTO:projectJsonDTOS){
            project = projectJsonDTO.createProject();
            projects.add(project);
        }
        return projects;
    }

    public List<Task> createTaskList() {
        List<TaskJsonDTO> taskJsonDTOS = getTaskJsonDTOList();
               List<Task> tasks = new ArrayList<>();
        Task task;
        for (TaskJsonDTO taskJsonDTO:taskJsonDTOS){
                  task = taskJsonDTO.createTask();
               tasks.add(task);
        }
        return tasks;
    }

}
