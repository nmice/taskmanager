package ru.neginskiy.tm;

import ru.neginskiy.tm.command.*;
import ru.neginskiy.tm.repository.ProjectRepository;
import ru.neginskiy.tm.repository.TaskRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Application {

    public static void main(String[] args) {

        Map<String, AbstractCommand> stringToCommand = new HashMap<>();
        stringToCommand.put("ct", new CreateTaskCommand());
        stringToCommand.put("rt", new TaskListCommand());
        stringToCommand.put("ut", new EditTaskCommand());
        stringToCommand.put("dt", new DeleteTaskCommand());
        stringToCommand.put("cp", new CreateProjectCommand());
        stringToCommand.put("rp", new ProjectListCommand());
        stringToCommand.put("up", new EditProjectCommand());
        stringToCommand.put("dp", new DeleteProjectCommand());

        ProjectRepository projectRepository = new ProjectRepository();
        TaskRepository taskRepository = new TaskRepository();

        while (true) {
            System.out.println("Enter the command: \r\n" +
                    "CT - create Task \r\n" +
                    "RT - read Task \r\n" +
                    "UT - update Task \r\n" +
                    "DT - delete Task \r\n" +
                    "CP - create Project \r\n" +
                    "RP - read Project \r\n" +
                    "UP - update Project \r\n" +
                    "DP - delete Project \r\n" +
                    "EXIT - exit program");
            Scanner scanner = new Scanner(System.in);
            String text = scanner.nextLine().toLowerCase().trim();
            if (text.equals("exit")) {
                return;
            }
            try {
                AbstractCommand command = stringToCommand.get(text);
                command.execute();
            } catch (Exception e) {
                System.out.println("Incorrect command, try again...");
            }
        }
    }
}
