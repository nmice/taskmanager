package ru.neginskiy.tm.service;

import ru.neginskiy.tm.entity.Project;
import ru.neginskiy.tm.api.IProjectService;
import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.repository.ProjectRepository;
import ru.neginskiy.tm.repository.TaskRepository;

import java.util.List;

public class ProjectService implements IProjectService {

    private final ProjectRepository projectRepository;

    private final TaskRepository taskRepository;

    public ProjectService(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public void merge(Project project) {
        if (project == null) {
            return;
        }
        projectRepository.merge(project);
    }

    @Override
    public Project getById(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return projectRepository.getById(id);
    }

    @Override
    public List<Project> getAllByUserId(String userId) {
        if (userId == null || userId.isEmpty()) {
            return null;
        }
        return projectRepository.getAllByUserId(userId);
    }

    @Override
    public Project delete(String id) {
        List<Task> taskList = taskRepository.;
        if (taskList.size() == 0) {
            System.out.println("Tasks not found");
        } else {
            for (Task task : taskList) {
                if (id.equals(task.getProjectId())) {
                    getBootstrap().getTaskEndpointService().taskDelete(task.getId());
                }
            }
            System.out.println("Project's tasks deleted");
        }



        if (id == null || id.isEmpty()) {
            return null;
        }
        return projectRepository.delete(id);
    }
}
