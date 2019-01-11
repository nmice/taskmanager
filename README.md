<h1>Taskmanager</h1>

<h2>Проект Taskmanager предназначен для управления списком задач и проектов.</h2>

<h3>Используемые технологии</h3>

<li> Java (1.8.0_192)</li>

<li> Maven (3.6.0)</li>

<h3>Структура проекта</h3>

<h4>[command]</h4>

AbstractCommand - абстрактный класс комманды

CreateProjectCommand - класс создания нового проекта

CreateTaskCommand - класс создания новой задачи

DeleteProjectCommand - класс удаления проекта

DeleteTaskCommand - класс удаления задачи

EditProjectCommand - класс корректировки проекта

EditTaskCommand - класс корректировки задачи

ProjectListCommand - класс выдачи информации по всем проектам

TaskListCommand - класс выдачи информации по всем задачам

<h4>[entity]</h4>
Task - задача
Project - проект

<h4>[repository]</h4>

TaskRepository - класс для создания и управления задачами
ProjectRepository - класс для создания и управления проектами

<h4>App - основной класс</h4>

<h3>Сборка проекта</h3>
 mvn clean install

<h3>Запуск</h3>
 java -jar ./taskmanager.jar
