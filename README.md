<h1>Taskmanager</h1>

<h2>Проект Taskmanager предназначен для управления списком задач и проектов.</h2>

<h3>Используемые технологии</h3>

<li> Java (1.8.0_192)</li>

<li> Maven (3.6.0)</li>

<h3>Структура проекта</h3>

<<<<<<< HEAD
<h4>[api]</h4>

<li> ICommand - интерфейс команд</li>

<li> IProjectService - интерфейс реализации команд над проектами</li>

<li> IRepository - интерфейс репозиториев</li>

<li> ITaskService - интерфейс реализации команд над задачами</li>

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

<li> Bootstrap - класс начальной загрузки программы</li>

<h4>[entity]</h4>

<li> AbstractEntity - абстрактный класс сущности</li>

<li> Task - класс задача</li>

<li> Project - класс проект</li>

<h4>[repository]</h4>

<li> AbstractRepository - абстрактный класс репозитория</li>

<li> ProjectRepository - класс для хранения и доступа к проектам</li>

<li> TaskRepository - класс для хранения и доступа к задачам</li>

<h4>[repository]</h4>

<li> ProjectService - класс для выполнения операций над проектами</li>

<li> TaskService - класс для выполнения операций над задачами</li>
=======
<h4>[command]</h4>

<li> AbstractCommand - абстрактный класс комманды</li>

<li> CreateProjectCommand - класс создания нового проекта</li>

<li> CreateTaskCommand - класс создания новой задачи</li>

<li> DeleteProjectCommand - класс удаления проекта</li>

<li> DeleteTaskCommand - класс удаления задачи</li>

<li> EditProjectCommand - класс корректировки проекта</li>

<li> EditTaskCommand - класс корректировки задачи</li>

<li> ProjectListCommand - класс выдачи информации по всем проектам</li>

<li> TaskListCommand - класс выдачи информации по всем задачам</li>

<h4>[entity]</h4>

<li> Task - задача</li>

<li> Project - проект</li>

<h4>[repository]</h4>

<li> TaskRepository - класс для создания и управления задачами</li>

<li> ProjectRepository - класс для создания и управления проектами</li>
>>>>>>> 4588b408f9c5eede1ade78a4b65a479e95f2e2ed

<h4>Application - основной класс</h4>

<h3>Сборка проекта</h3>

 mvn clean install

<h3>Запуск</h3>

<<<<<<< HEAD
 java -jar ./taskmanager.jar
=======
 java -jar ./taskmanager.jar
>>>>>>> 4588b408f9c5eede1ade78a4b65a479e95f2e2ed
