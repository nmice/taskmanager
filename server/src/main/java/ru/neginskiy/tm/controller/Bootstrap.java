package ru.neginskiy.tm.controller;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import ru.neginskiy.tm.api.*;
import ru.neginskiy.tm.api.repository.IProjectRepository;
import ru.neginskiy.tm.api.repository.ISessionRepository;
import ru.neginskiy.tm.api.repository.ITaskRepository;
import ru.neginskiy.tm.api.repository.IUserRepository;
import ru.neginskiy.tm.api.service.IProjectService;
import ru.neginskiy.tm.api.service.ISessionService;
import ru.neginskiy.tm.api.service.ITaskService;
import ru.neginskiy.tm.api.service.IUserService;
import ru.neginskiy.tm.endpoint.*;
import ru.neginskiy.tm.entity.User;
import ru.neginskiy.tm.service.*;

import javax.sql.DataSource;
import javax.xml.ws.Endpoint;

import static ru.neginskiy.tm.util.AppConfig.*;

public class Bootstrap implements ServiceLocator {

    private static final Class[] MAPPER_CLASSES = {IProjectRepository.class, ITaskRepository.class,
            IUserRepository.class, ISessionRepository.class};

    private ITaskService taskService;
    private IProjectService projectService;
    private IUserService userService;
    private ISessionService sessionService;
    private DataService dataService;

    public void init() {
        final SqlSessionFactory sqlSessionFactory = createSqlSessionFactory();

        taskService = new TaskService(sqlSessionFactory);
        projectService = new ProjectService(sqlSessionFactory);
        userService = new UserService(sqlSessionFactory);
        sessionService = new SessionService(sqlSessionFactory);
        dataService = new DataService(this);

        createTestUser();

        registryInNet();
    }

    private SqlSessionFactory createSqlSessionFactory() {
        final DataSource dataSource = new PooledDataSource(dbDriver, dbUrl, dbUsername, dbPassword);
        final TransactionFactory transactionFactory = new JdbcTransactionFactory();
        final Environment environment = new Environment("development", transactionFactory, dataSource);
        final Configuration configuration = new Configuration(environment);

        for (Class mapperClass : MAPPER_CLASSES) {
            configuration.addMapper(mapperClass);
        }

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        sqlSessionFactoryBuilder.build(configuration);
        return sqlSessionFactoryBuilder.build(configuration);
    }

    private void createTestUser() {
        User testUser = new User();
        testUser.setId("dba0d409-0622-4c62-8356-4bc48bdfcbf3");
        testUser.setLogin("test");
        testUser.setPasswordHash(String.valueOf(("test").hashCode()));
        getUserService().merge(testUser);
    }

    private void registryInNet() {
        Endpoint.publish("http://localhost:1234/TaskEndpoint?wsdl", new TaskEndpoint(this));
        Endpoint.publish("http://localhost:1234/ProjectEndpoint?wsdl", new ProjectEndpoint(this));
        Endpoint.publish("http://localhost:1234/UserEndpoint?wsdl", new UserEndpoint(userService));
        Endpoint.publish("http://localhost:1234/SessionEndpoint?wsdl", new SessionEndpoint(sessionService));
        Endpoint.publish("http://localhost:1234/DataEndpoint?wsdl", new DataEndpoint(this));
    }

    public IProjectService getProjectService() {
        return projectService;
    }

    public ITaskService getTaskService() {
        return taskService;
    }

    public IUserService getUserService() {
        return userService;
    }

    public ISessionService getSessionService() {
        return sessionService;
    }

    public DataService getDataService() {
        return dataService;
    }
}