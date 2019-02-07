package ru.neginskiy.tm.domain;

import ru.neginskiy.tm.dto.ProjectJsonDTO;
import ru.neginskiy.tm.dto.TaskJsonDTO;
import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class Domain {

    private final List<ProjectJsonDTO> projectJsonDTOList;
    private final List<TaskJsonDTO> taskJsonDTOListList;

    public Domain(List<ProjectJsonDTO> projectJsonDTOList, List<TaskJsonDTO> taskJsonDTOListList) {
        this.projectJsonDTOList = projectJsonDTOList;
        this.taskJsonDTOListList = taskJsonDTOListList;
    }

    public List<ProjectJsonDTO> getProjectJsonDTOList() {
        return projectJsonDTOList;
    }

    public List<TaskJsonDTO> getTaskJsonDTOList() {
        return taskJsonDTOListList;
    }

    public List<Project> getProjectList() {
        List<ProjectJsonDTO> projectJsonDTOS = getProjectJsonDTOList();
        List<Project> projects = new ArrayList<>();
        Project project;
        for (ProjectJsonDTO projectJsonDTO:projectJsonDTOS){
            project = projectJsonDTO.getProject();
            projects.add(project);
        }
        return projects;
    }

    public List<Task> getTaskList() {
        List<TaskJsonDTO> taskJsonDTOS = getTaskJsonDTOList();
               List<Task> tasks = new ArrayList<>();
        Task task;
        for (TaskJsonDTO taskJsonDTO:taskJsonDTOS){
                  task = taskJsonDTO.getTask();
               tasks.add(task);
        }
        return tasks;
    }

}
