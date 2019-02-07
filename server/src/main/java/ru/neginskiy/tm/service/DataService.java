package ru.neginskiy.tm.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.neginskiy.tm.api.ServiceLocator;
import ru.neginskiy.tm.domain.Domain;
import ru.neginskiy.tm.dto.ProjectJsonDTO;
import ru.neginskiy.tm.dto.TaskJsonDTO;
import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.entity.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
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

        final Domain domain = createDomain(userId);

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
            final Domain domain = mapper.readValue(new File(fileName), Domain.class);

            final List<Project> projectList = domain.createProjectList();
            final List<Task> taskList = domain.createTaskList();

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

    public void saveDataXml(String userId){
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

            final List<Project> projectList = domain.createProjectList();
            final List<Task> taskList = domain.createTaskList();

            for (Project project : projectList) {
                serviceLocator.getProjectService().merge(project);
            }

            for (Task task : taskList) {
                serviceLocator.getTaskService().merge(task);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private Domain createDomain(String userId) {
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
        return new Domain(projectJsonDTOList, taskJsonDTOList);
    }

/*    static class TaskDeserializer extends StdDeserializer<Date> {

        public TaskDeserializer() {
            this(null);
        }

        public TaskDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public Date deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode node = jp.getCodec().readTree(jp);
            Date dateBegin = node.get("dateBegin") == null ? null : new Date(node.get("dateBegin").asLong());
            Date dateEnd = node.get("dateEnd") == null ? null : new Date(node.get("dateEnd").asLong());

            return new Task(id, itemName, new User(userId, null));
        }
    }*/

}

