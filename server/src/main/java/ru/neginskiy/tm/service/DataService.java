package ru.neginskiy.tm.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.neginskiy.tm.api.ServiceLocator;
import ru.neginskiy.tm.domain.Domain;
import ru.neginskiy.tm.dto.ProjectJsonDTO;
import ru.neginskiy.tm.dto.TaskJsonDTO;
import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.entity.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataService {

    ServiceLocator serviceLocator;

    public DataService(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public void saveDataBin(String userId) {
        final String userLogin = serviceLocator.getUserService().getById(userId).getLogin();
        final List<Project> projectList = serviceLocator.getProjectService().getAllByUserId(userId);
        final List<Task> taskList = serviceLocator.getTaskService().getAllByUserId(userId);

        try (final ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("projects-" + userLogin + ".dat"))) {
            oos.writeObject(projectList);
            oos.writeObject(taskList);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void loadDataBin(String userId) {
        final String userLogin = serviceLocator.getUserService().getById(userId).getLogin();

        try (final ObjectInputStream ois = new ObjectInputStream(new FileInputStream("projects-" + userLogin + ".dat"))) {
            final List<Project> projectList = (List<Project>) ois.readObject();
            for (Project project : projectList) {
                serviceLocator.getProjectService().merge(project);
            }
            final List<Task> taskList = (List<Task>) ois.readObject();
            for (Task task : taskList) {
                serviceLocator.getTaskService().merge(task);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void saveDataJson(String userId) {
        final String userLogin = serviceLocator.getUserService().getById(userId).getLogin();
        final String baseFile = "projects-" + userLogin + ".json";

        final List<Project> projectList = serviceLocator.getProjectService().getAllByUserId(userId);
        final List<Task> taskList = serviceLocator.getTaskService().getAllByUserId(userId);

        final List<ProjectJsonDTO> projectJsonDTOList = new ArrayList<>();
        final List<TaskJsonDTO> taskJsonDTOList = new ArrayList<>();

        for (Project project : projectList) {
            ProjectJsonDTO projectJsonDTO = new ProjectJsonDTO(project);
            projectJsonDTOList.add(projectJsonDTO);
        }

        for (Task task : taskList) {
            TaskJsonDTO taskJsonDTO = new TaskJsonDTO(task);
            taskJsonDTOList.add(taskJsonDTO);
        }

        final Domain domain = new Domain(projectJsonDTOList,taskJsonDTOList);

        final ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File(baseFile), domain);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void loadDataJson(String userId) {
        final String userLogin = serviceLocator.getUserService().getById(userId).getLogin();

        final String fileName = "projects-" + userLogin + ".json";
        final ObjectMapper mapper = new ObjectMapper();

        try {
            //final Domain domain = (Domain) mapper.getFactory().createParser(fileName).readValuesAs(Domain.class);
            final Domain domain = mapper.readValue(new File(fileName), Domain.class);

            final List<Project> projectList = domain.getProjectList();
            final List<Task> taskList = domain.getTaskList();

            for (Project project : projectList) {
                serviceLocator.getProjectService().merge(project);
            }

            for (Task task : taskList) {
                serviceLocator.getTaskService().merge(task);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}

