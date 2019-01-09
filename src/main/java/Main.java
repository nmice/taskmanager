import model.Task;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static util.TasksUtil.TASK_BASE;
import static util.TasksUtil.createTask;

public class Main {

    public static void main(String[] args) {

/*        List<Task> tasks = Arrays.asList(
                new Task("Task one", "Project one"),
                new Task("Task two", "Project one"),
                new Task("Task three", "Project one"),
                new Task("Task one", "Project two"),
                new Task("Task two", "Project two"),
                new Task("Task three", "Project two")
        );*/

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the command (C - create/R - read/U - update/D - delete) :");
        String command = scanner.nextLine();

        if (command.equalsIgnoreCase("c")) {
            System.out.println("Please enter description of task :");
            String description = scanner.nextLine();
            System.out.println("Please enter project :");
            String project = scanner.nextLine();
            createTask(description, project);
        }

        if (command.equalsIgnoreCase("r")) {
            System.out.println("Please input ID of task for read Task by ID:");
            int id = scanner.nextInt();

            System.out.println(TASK_BASE);
        }
    }

}
