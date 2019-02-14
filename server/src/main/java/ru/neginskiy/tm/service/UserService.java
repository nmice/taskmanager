package ru.neginskiy.tm.service;

import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.api.repository.IUserRepository;
import ru.neginskiy.tm.api.service.IUserService;
import ru.neginskiy.tm.entity.User;
import ru.neginskiy.tm.repository.UserRepository;

public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void merge(@Nullable User user) {
        if (user == null) {
            return;
        }
        final SqlSession session = sqlSessionFactory.openSession();
        final IUserRepository userMapper = session.getMapper(IUserRepository.class);
        userMapper.merge(user);
        session.commit();
        session.close();
    }

    @Override
    public @Nullable User getById(@Nullable String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        final SqlSession session = sqlSessionFactory.openSession();
        final IUserRepository userMapper = session.getMapper(IUserRepository.class);
        final User user = userMapper.getById(id);
        session.commit();
        session.close();
        return user;
    }

    @Override
    public @Nullable User findUser(@Nullable String login, @Nullable String passwordHash) {
        if (login == null || passwordHash == null) {
            return null;
        }
        final SqlSession session = sqlSessionFactory.openSession();
        final IUserRepository userMapper = session.getMapper(IUserRepository.class);
        final User user = userMapper.findUser(login, passwordHash);
        session.commit();
        session.close();
        return user;
    }

    @Override
    public boolean isRegistredLogin(@Nullable String login) {
        if (login == null) {
            return true;
        }
        final SqlSession session = sqlSessionFactory.openSession();
        final IUserRepository userMapper = session.getMapper(IUserRepository.class);
        final User user = userMapper.getByLogin(login);
        session.commit();
        session.close();
        return user != null;
    }
}