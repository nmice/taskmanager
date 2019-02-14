package ru.neginskiy.tm.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.ITaskRepository;
import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.api.service.ITaskService;
import ru.neginskiy.tm.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class TaskService implements ITaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void merge(@Nullable Task task) {
        if (task == null) {
            return;
        }
        final SqlSession session = sqlSessionFactory.openSession();
        final ITaskRepository taskMapper = session.getMapper(ITaskRepository.class);
        taskMapper.merge(task);
        session.commit();
        session.close();
    }

    @Override
    public @Nullable Task getById(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        final SqlSession session = sqlSessionFactory.openSession();
        final ITaskRepository taskMapper = session.getMapper(ITaskRepository.class);
        final Task task = taskMapper.getById(id);
        session.commit();
        session.close();
        return task;
    }

    @Override
    public @NotNull List<Task> getAllByUserId(@Nullable String userId) {
        if (userId == null || userId.isEmpty()) {
            return new ArrayList<>();
        }
        final SqlSession session = sqlSessionFactory.openSession();
        final ITaskRepository taskMapper = session.getMapper(
                ITaskRepository.class);
        final List<Task> taskList = taskMapper.getAllByUserId(userId);
        session.commit();
        session.close();
        return taskList;
    }

    @Override
    public @Nullable Task delete(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        final SqlSession session = sqlSessionFactory.openSession();
        final ITaskRepository taskMapper = session.getMapper(ITaskRepository.class);
        final Task task = taskMapper.getById(id);
        if (task == null) {
            return null;
        }
        int counter = taskMapper.delete(id);
        if (counter == 0) {
            return null;
        }
        session.commit();
        session.close();
        return task;
    }


}
