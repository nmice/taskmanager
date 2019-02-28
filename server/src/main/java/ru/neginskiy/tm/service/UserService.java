package ru.neginskiy.tm.service;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.IUserRepository;
import ru.neginskiy.tm.api.service.IUserService;
import ru.neginskiy.tm.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

@Getter
@ApplicationScoped
public class UserService implements IUserService {

    @Inject
    private IUserRepository userRepository;

    @Inject
    EntityManagerFactory entityManagerFactory;

    @Override
    public void merge(@Nullable User user) {
        if (user == null) {
            return;
        }
        userRepository.setEntityManager(entityManagerFactory.createEntityManager());
        userRepository.getTransaction().begin();
        userRepository.merge(user);
        userRepository.getTransaction().commit();
        userRepository.close();
    }

    @Override
    public @Nullable User getById(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        userRepository.setEntityManager(entityManagerFactory.createEntityManager());
        final User user = userRepository.getById(id);
        userRepository.close();
        return user;
    }

    @Override
    public @Nullable User findUser(@Nullable String login, @Nullable String passwordHash) {
        if (login == null || passwordHash == null) {
            return null;
        }
        try {
            userRepository.setEntityManager(entityManagerFactory.createEntityManager());
            final User user = userRepository.findUser(login, passwordHash);
            userRepository.close();
            return user;
        } catch (NoResultException e) {
            userRepository.close();
            return null;
        }
    }

    @Override
    public boolean isRegistredLogin(@Nullable String login) {
        if (login == null) {
            return true;
        }
        try {
            userRepository.setEntityManager(entityManagerFactory.createEntityManager());
            final User user = userRepository.getByLogin(login);
            userRepository.close();
            return user != null;
        } catch (NoResultException e) {
            userRepository.close();
            return false;
        }
    }
}