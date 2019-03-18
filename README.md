<h1>Taskmanager</h1>

<h2>Проект Taskmanager предназначен для управления списком задач и проектов.</h2>

<h3>Используемые технологии</h3>

<li> Java (1.8.0_192)</li>

<li> Maven (3.6.0)</li>

<li> SOAP WS</li>

<li> Hibernate (5.3.8.Final)</li>

<li> Weld SE (Core) (3.1.0.Final)</li>

<li> Apache DeltaSpike (1.9.0)</li>

<h3>Структура проекта</h3>

<h3>- server -</h3>

<h4>[api]</h4>

<h4>[api.repository]</h4>

<li> IProjectRepository - интерфейс репозитория проектов</li>

<li> ISessionRepository - интерфейс репозитория сессий<li>

<li> ITaskRepository - интерфейс репозитория задач</li>

<li> IUserRepository - интерфейс репозитория пользователей</li>

<h4>[api.service]</h4>

<li> IProjectService - интерфейс логики операций над проектами</li>

<li> ISessionService - интерфейс логики операций над сессиями</li>

<li> ITaskService - интерфейс логики операций над задачами</li>

<li> IUserService - интерфейс логики операций над пользователями</li>

<h4>[endpoint]</h4>

<li> DataEndpoint - класс для сетевого доступа к сервисам сохранения и загрузки</li>

<li> ProjectEndpoint - класс для сетевого доступа к сервисам проектов</li>

<li> SessionEndpoint - класс для сетевого доступа к сервисам cессий</li>

<li> TaskEndpoint - класс для сетевого доступа к сервисам задач</li>

<li> UserEndpoint - класс для сетевого доступа к сервисам пользователей</li>

<h4>[entity]</h4>

<li> AbstractEntity - абстрактный класс сущности</li>

<li> Project - класс проект</li>

<li> Session - класс сессия</li>

<li> Task - класс задача</li>

<li> User - класс пользователь</li>

<h4>[error]</h4>

<li> UncorrectSessionException - класс ошибки сессии</li>

<h4>[service]</h4>

<li> DataService - класс для сохранения и загрузки данных пользователя</li>

<li> ProjectService - класс для выполнения операций над проектами</li>

<li> SessionService - класс для выполнения операций над сессиями</li>

<li> TaskService - класс для выполнения операций над задачами</li>

<li> UserService - класс для выполнения операций над пользователями</li>

<h4>[util]</h4>

<li> AppConfig - утильный класс со static переменными, хранящих значения из config.properties</li>

<li> HibernateSessionFactory - утильный класс для создания EntityManagerFactory</li>

<li> EntityManagerProducer - утильный класс для создания EntityManager</li>

<h4>Application - основной класс на сервере</h4>


<h3>- client -</h3>

<h4>[api]</h4>

<li> ICommand - интерфейс команд</li>

<h4>[command]</h4>

<li> AbstractCommand - абстрактный класс команды</li>

<li> ExitCommand - класс команды выхода</li>

<li> HelpCommand - класс команды помощь</li>

<li> ProjectCreateCommand - класс создания нового проекта</li>

<li> ProjectDeleteCommand - класс удаления проекта</li>

<li> ProjectEditCommand - класс корректировки проекта</li>

<li> ProjectListCommand - класс выдачи информации по всем проектам</li>

<li> TaskCreateCommand - класс создания новой задачи</li>

<li> TaskDeleteCommand - класс удаления задачи</li>

<li> TaskEditCommand - класс корректировки задачи</li>

<li> TaskListCommand - класс выдачи информации по всем задачам</li>

<li> UserCreateCommand - класс создания нового пользователя</li>

<li> UserLoginCommand - класс создания новой сессии существующего пользователя</li>

<li> UserLogoutCommand - класс закрытия сессии пользователя</li>

<h4>[controller]</h4>

<li> Bootstrap - класс начальной загрузки программы на клиенте</li>

<h4>[endpoint]</h4>

<li> Классы, сгенерированные с помощью Endpoint</li>

<h4>[util]</h4>

<li> GcToStrUtil - утильный класс с методом для перевода <i>XMLGregorianCalendar</i> в <i>String</i></li>

<li> StrToGcUtil - утильный класс с методом для перевода <i>String</i> в <i>XMLGregorianCalendar</i></li>

<h4>App - основной класс на клиенте</h4>

<h3>Сборка проекта</h3>

<li> mvn clean install</li>

<h3>Запуск</h3>

<li> java -jar ./taskmanager.jar</li>