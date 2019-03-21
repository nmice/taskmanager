package ru.neginskiy.tm.service;

import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.neginskiy.tm.api.repository.IUserRepository;
import ru.neginskiy.tm.api.service.IUserService;
import ru.neginskiy.tm.entity.User;

import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

@Transactional
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public void merge(@Nullable User user) {
        if (user == null) {
            return;
        }
        userRepository.save(user);
    }

    @Override
    public @Nullable User getById(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        final User user = userRepository.getOne(id);
        return user;
    }

    @Override
    public @Nullable User findUser(@Nullable String login, @Nullable String passwordHash) {
        if (login == null || passwordHash == null) {
            return null;
        }
        try {
            final User user = userRepository.findUser(login, passwordHash);
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public boolean isRegistredLogin(@Nullable String login) {
        if (login == null) {
            return true;
        }
        try {
            final User user = userRepository.getByLogin(login);
            return user != null;
        } catch (NoResultException e) {
            return false;
        }
    }
}