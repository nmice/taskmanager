package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.entity.User;

public class UserRepository extends AbstractRepository<User> {

    private static UserRepository instance;

    private UserRepository() {
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            User demoUser = new User();
            demoUser.setId("UID");
            demoUser.setLogin("test");
            demoUser.setPasswordHash("0");
            instance = new UserRepository();
            instance.merge(demoUser);
            return instance;
        }
        return instance;
    }
}
