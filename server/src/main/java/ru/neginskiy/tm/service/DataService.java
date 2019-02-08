package ru.neginskiy.tm.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.neginskiy.tm.api.ServiceLocator;
import ru.neginskiy.tm.dto.Domain;
import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.entity.Task;

import java.io.*;
import java.util.List;

public class DataService {

    ServiceLocator serviceLocator;

    public DataService(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public void saveDataBin(String userId) {
        final String userLogin = serviceLocator.getUserService().getById(userId).getLogin();
        final String fileName = "projects-" + userLogin + ".dat";
        Domain domain = createDomain(userId);
        try (final ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(domain);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void loadDataBin(String userId) {
        final String userLogin = serviceLocator.getUserService().getById(userId).getLogin();
        final String fileName = "projects-" + userLogin + ".dat";
        try (final ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            final Domain domain = (Domain) ois.readObject();
            mergeProjectsAndTasksFromDomain(domain);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void saveDataJson(String userId) {
        final String userLogin = serviceLocator.getUserService().getById(userId).getLogin();
        final String fileName = "projects-" + userLogin + ".json";
        final Domain domain = createDomain(userId);
        final ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(fileName), domain);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void loadDataJson(String userId) {
        final String userLogin = serviceLocator.getUserService().getById(userId).getLogin();
        final String fileName = "projects-" + userLogin + ".json";
        final ObjectMapper mapper = new ObjectMapper();
        try {
            final Domain domain = mapper.readValue(new File(fileName), Domain.class);
            mergeProjectsAndTasksFromDomain(domain);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void saveDataXml(String userId) {
        final String userLogin = serviceLocator.getUserService().getById(userId).getLogin();
        final String fileName = "projects-" + userLogin + ".xml";
        final Domain domain = createDomain(userId);
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File(fileName), domain);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void loadDataXml(String userId) {
        final String userLogin = serviceLocator.getUserService().getById(userId).getLogin();
        final String fileName = "projects-" + userLogin + ".xml";
        final XmlMapper mapper = new XmlMapper();
        try {
            final Domain domain = mapper.readValue(new File(fileName), Domain.class);
            mergeProjectsAndTasksFromDomain(domain);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private Domain createDomain(String userId) {
        Domain domain = new Domain();
        final List<Project> projectList = serviceLocator.getProjectService().getAllByUserId(userId);
        final List<Task> taskList = serviceLocator.getTaskService().getAllByUserId(userId);
        domain.setProjectList(projectList);
        domain.setTaskList(taskList);
        return domain;
    }

    private void mergeProjectsAndTasksFromDomain(Domain domain) {
        final List<Project> projectList = domain.getProjectList();
        final List<Task> taskList = domain.getTaskList();
        for (Project project : projectList) {
            serviceLocator.getProjectService().merge(project);
        }
        for (Task task : taskList) {
            serviceLocator.getTaskService().merge(task);
        }
    }
}

