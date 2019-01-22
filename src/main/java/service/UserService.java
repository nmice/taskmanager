package ru.neginskiy.tm.service;

import ru.neginskiy.tm.api.IUserService;
import ru.neginskiy.tm.entity.User;
import ru.neginskiy.tm.repository.UserRepository;

import java.util.List;

public class UserService implements IUserService {

    private final UserRepository entityRepository;

    public UserService(UserRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    @Override
    public void merge(User user) {
        if (user == null) {
            return;
        }
        entityRepository.merge(user);
    }

    @Override
    public User getById(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return entityRepository.getById(id);
    }

    @Override
    public List<User> getAll() {
        return entityRepository.getAll();
    }

    @Override
    public User delete(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return entityRepository.delete(id);
    }
}