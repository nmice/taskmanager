<h1>Taskmanager</h1>

<h2>Проект Taskmanager предназначен для управления списком задач и проектов.</h2>

<h3>Используемые технологии</h3>

<li> Java (1.8.0_192)</li>

<li> Maven (3.6.0)</li>

<h3>Структура проекта</h3>

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

<h4>App - основной класс</h4>

<h3>Сборка проекта</h3>

 mvn clean install

<h3>Запуск</h3>

 java -jar ./taskmanager.jar
