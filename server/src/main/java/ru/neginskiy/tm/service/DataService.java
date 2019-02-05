package ru.neginskiy.tm.service;

import ru.neginskiy.tm.api.ServiceLocator;
import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.entity.Task;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class DataService {

    ServiceLocator serviceLocator;

    public DataService(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public void saveDataBin(String userId) {
        List<Project> projectList = serviceLocator.getProjectService().getAllByUserId(userId);
        List<Task> taskList = serviceLocator.getTaskService().getAllByUserId(userId);
        String userLogin = serviceLocator.getUserService().getById(userId).getLogin();

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("projects-" + userLogin + ".dat"))) {
            oos.writeObject(projectList);
            oos.writeObject(taskList);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void loadDataBin(String userId) {
        String userLogin = serviceLocator.getUserService().getById(userId).getLogin();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("projects-" + userLogin + ".dat"))) {
            List<Project> projectList = (List<Project>) ois.readObject();
            for (Project project : projectList) {
                serviceLocator.getProjectService().merge(project);
            }
            List<Task> taskList = (List<Task>) ois.readObject();
            for (Task task : taskList) {
                serviceLocator.getTaskService().merge(task);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
