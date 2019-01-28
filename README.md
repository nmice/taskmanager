<h1>Taskmanager</h1>

<h2>Проект Taskmanager предназначен для управления списком задач и проектов.</h2>

<h3>Используемые технологии</h3>

<li> Java (1.8.0_192)</li>

<li> Maven (3.6.0)</li>

<h3>Структура проекта</h3>

<h3>- server -</h3>

<h4>[api]</h4>

<li> IProjectService - интерфейс операций над проектами</li>

<li> IRepository - интерфейс репозиториев</li>

<li> ISessionService - интерфейс операций над сессиями</li>

<li> ITaskService - интерфейс операций над задачами</li>

<li> IUserService - интерфейс операций над пользователями</li>

<li> ServiceLocator - интерфейс доступа к сервисам</li>

<h4>[controller]</h4>

<li> Bootstrap - класс начальной загрузки программы на сервере</li>

<h4>[endpoint]</h4>

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

<h4>[repository]</h4>

<li> AbstractRepository - абстрактный класс репозитория</li>

<li> ProjectRepository - класс для хранения и доступа к хранилищу проектов</li>

<li> SessionRepository - класс для хранения и доступа к хранилищу сессий</li>

<li> TaskRepository - класс для хранения и доступа к хранилищу задач</li>

<li> UserRepository - класс для хранения и доступа к хранилищу пользователей</li>

<h4>[service]</h4>

<li> ProjectService - класс для выполнения операций над проектами</li>

<li> SessionService - класс для выполнения операций над сессиями</li>

<li> TaskService - класс для выполнения операций над задачами</li>

<li> UserService - класс для выполнения операций над пользователями</li>

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

<h4>[controller]</h4>

<li> Bootstrap - класс начальной загрузки программы на клиенте</li>

<h4>[endpoint]</h4>

<li> Классы, сгенерированные с помощью Endpoint</li>

<h4>[util]</h4>

<li> GcToStrUtil - утильный класс с методом для перевода <i>XMLGregorianCalendar</i> в <i>String</i></li>
<li> StrToGcUtil - утильный класс с методом для перевода <i>String</i> в <i>XMLGregorianCalendar</i></li>

<h4>App - основной класс на клиенте</h4>

<h3>Сборка проекта</h3>

 mvn clean install

<h3>Запуск</h3>

 java -jar ./taskmanager.jar
