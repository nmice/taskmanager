package ru.neginskiy.tm.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import ru.neginskiy.tm.api.repository.ITaskRepository;
import ru.neginskiy.tm.entity.Task;
import ru.neginskiy.tm.api.service.ITaskService;

import java.util.List;

public class TaskService implements ITaskService {

    private final SqlSessionFactory sqlSessionFactory;

    public TaskService(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void merge(Task task) {
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
    public Task getById(String id) {
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
    public List<Task> getAllByUserId(String userId) {
        if (userId == null || userId.isEmpty()) {
            return null;
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
    public Task delete(String id) {
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
