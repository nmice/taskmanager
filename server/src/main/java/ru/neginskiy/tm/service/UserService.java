package ru.neginskiy.tm.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import ru.neginskiy.tm.api.IUserRepository;
import ru.neginskiy.tm.api.IUserService;
import ru.neginskiy.tm.entity.User;

public class UserService implements IUserService {

    private final SqlSessionFactory sqlSessionFactory;

    public UserService(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void merge(User user) {
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
    public User getById(String id) {
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
    public User findUser(String login, String passwordHash) {
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
    public boolean isRegistredLogin(String login) {
        if (login == null) {
            return true;
        }
        final SqlSession session = sqlSessionFactory.openSession();
        final IUserRepository userMapper = session.getMapper(IUserRepository.class);
        final User user = userMapper.getByLogin(login);
        session.commit();
        session.close();
        return user!=null;
    }
}