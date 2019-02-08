package ru.neginskiy.tm.controller;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import ru.neginskiy.tm.api.*;
import ru.neginskiy.tm.connection.DBConnection;
import ru.neginskiy.tm.endpoint.*;
import ru.neginskiy.tm.entity.User;
import ru.neginskiy.tm.repository.SessionRepository;
import ru.neginskiy.tm.repository.TaskRepository;
import ru.neginskiy.tm.repository.ProjectRepository;
import ru.neginskiy.tm.repository.UserRepository;
import ru.neginskiy.tm.service.*;

import javax.sql.DataSource;
import javax.xml.ws.Endpoint;
import java.sql.*;

import static ru.neginskiy.tm.util.AppConfig.*;

public class Bootstrap implements ServiceLocator {

    private final DBConnection dbConnection = new DBConnection();

    private ITaskService taskService;
    private IProjectService projectService;
    private IUserService userService;
    private ISessionService sessionService;
    private DataService dataService;

    public void init() {
        dbConnection.initDB();
        final Connection connection = dbConnection.getConnection();
        final SqlSessionFactory sqlSessionFactory = createSqlSessionFactory();

        final TaskRepository taskRepository = new TaskRepository(connection, sqlSessionFactory);
        final ProjectRepository projectRepository = new ProjectRepository(connection, sqlSessionFactory);
        final UserRepository userRepository = new UserRepository(connection, sqlSessionFactory);
        final SessionRepository sessionRepository = new SessionRepository(connection, sqlSessionFactory);

        taskService = new TaskService(taskRepository);
        projectService = new ProjectService(projectRepository, taskRepository);
        userService = new UserService(userRepository);
        sessionService = new SessionService(sessionRepository);
        dataService = new DataService(this);

        createTestUser();

        registryInNet();
    }

    private SqlSessionFactory createSqlSessionFactory() {
        final DataSource dataSource = new PooledDataSource(dbDriver,dbUrl,dbUsername,dbPassword);
        final TransactionFactory transactionFactory=new JdbcTransactionFactory();
        final Environment environment = new Environment("development", transactionFactory,dataSource);
        final Configuration configuration = new Configuration(environment);

        configuration.addMapper(IRepository.class);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder= new SqlSessionFactoryBuilder();
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

    public Connection getConnection() {
        return dbConnection.getConnection();
    }
}