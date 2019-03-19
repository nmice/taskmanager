package ru.neginskiy.tm.service;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.IUserRepository;
import ru.neginskiy.tm.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;

@Transactional
@ApplicationScoped
public class UserService{

    @Inject
    private IUserRepository userRepository;

    public void merge(@Nullable User user) {
        if (user == null) {
            return;
        }
        userRepository.merge(user);
    }

    public @Nullable User getById(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        final User user = userRepository.findBy(id);
        return user;
    }

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