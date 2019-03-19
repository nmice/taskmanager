<h1>Taskmanager</h1>

<h2>Проект Taskmanager предназначен для управления списком задач и проектов.</h2>

<h3>Используемые технологии</h3>

<li> Java (1.8.0_192)</li>

<li> Maven (3.6.0)</li>

<li> SOAP WS</li>

<li> Hibernate (5.3.8.Final)</li>

<li> WildFly (2.0.1.Final)</li>

<li> Apache DeltaSpike (1.9.0)</li>

<li> WildFly (2.0.1.Final)</li>

<h3>Структура проекта</h3>

<h3>- server -</h3>

<h4>[api]</h4>

<h4>[api.repository]</h4>

<li> IProjectRepository - интерфейс репозитория проектов</li>

<li> ITaskRepository - интерфейс репозитория задач</li>

<li> IUserRepository - интерфейс репозитория пользователей</li>

<h4>[endpoint]</h4>

<li> DataEndpoint - класс для сетевого доступа к сервисам сохранения и загрузки</li>

<li> ProjectEndpoint - класс для сетевого доступа к сервисам проектов</li>

<li> TaskEndpoint - класс для сетевого доступа к сервисам задач</li>

<li> UserEndpoint - класс для сетевого доступа к сервисам пользователей</li>

<h4>[entity]</h4>

<li> AbstractEntity - абстрактный класс сущности</li>

<li> Project - класс проект</li>

<li> Task - класс задача</li>

<li> User - класс пользователь</li>

<h4>[service]</h4>

<li> ProjectService - класс для выполнения операций над проектами</li>

<li> TaskService - класс для выполнения операций над задачами</li>

<li> UserService - класс для выполнения операций над пользователями</li>

<h4>[servlets]</h4>

<li> LoginServlet - сервлет логики обработки данных для авторизации/создания пользователя</li>

<li> LogoutServlet - сервлет логики завершения сеанса</li>

<li> ProjectDeleteServlet - сервлет логики удаления проекта</li>

<li> ProjectFormServlet - сервлет перенаправления на форму создания/редактирования проекта</li>

<li> ProjectListServlet - сервлет отображения проектов</li>

<li> ProjectMergeServlet - сервлет добавления/редактирования проекта</li>

<li> StartServlet - стартовый сервлет</li>

<li> TaskDeleteServlet - сервлет логики удаления задачи</li>

<li> TaskFormServlet - сервлет перенаправления на форму создания/редактирования задачи</li>

<li> TaskListServlet - сервлет отображения задач</li>

<li> TaskMergeServlet - сервлет добавления/редактирования задачи</li>

<h4>[util]</h4>

<li> EntityManagerProducer - утильный класс для создания EntityManager</li>

<li> ServletFilter - утильный класс для фильтра страниц при заходе без авторизации</li>

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