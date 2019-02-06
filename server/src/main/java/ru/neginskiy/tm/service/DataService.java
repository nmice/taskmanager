package ru.neginskiy.tm.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.neginskiy.tm.api.ServiceLocator;
import ru.neginskiy.tm.domain.Domain;
import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.entity.Task;

import javax.swing.text.html.parser.Entity;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        final ObjectMapper mapper = new ObjectMapper();

        //final Domain domain = new Domain();


        try {
            for (Project project : projectList) {
                mapper.writeValueAsString(project.getId());
                mapper.writeValueAsString(project.getName());
                mapper.writeValueAsString(project.getDescription());
                mapper.writeValueAsString(project.getUserId());
                mapper.writeValueAsString(project.getDateBegin().getTime());


            }
            //mapper.writeValue(new File(baseFile), domain);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void loadDataJson(String userId) {
        final String userLogin = serviceLocator.getUserService().getById(userId).getLogin();

        final String fileName = "projects-" + userLogin + ".json";
        final ObjectMapper mapper = new ObjectMapper();

        try {
            final Domain domain = (Domain) mapper.getFactory().createParser(fileName).readValuesAs(Domain.class);
            //final Domain domain = (Domain) mapper.readValue(new File(fileName), Domain.class);

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

