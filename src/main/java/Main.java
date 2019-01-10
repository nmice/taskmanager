import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static repository.TasksUtil.TASK_BASE;
import static repository.TasksUtil.createTask;

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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the command (C - create/R - read/U - update/D - delete) :");
        String command = scanner.nextLine();



        if (command.equalsIgnoreCase("c")) {
            System.out.println("Please enter a name of the task :");
            String description = scanner.nextLine();
            System.out.println("Please enter a description of the task :");
            String project = scanner.nextLine();
            System.out.println("Please enter date of begin :");
            String dateBegin = scanner.nextLine();
            System.out.println("Please enter date of end :");
            String dateEnd = scanner.nextLine();
            System.out.println("Please enter project ID :");
            int projectID = scanner.nextInt();
            createTask(description, project, LocalDate.parse(dateBegin, formatter), LocalDate.parse(dateEnd, formatter), projectID);
            System.out.println(TASK_BASE);
        }

        if (command.equalsIgnoreCase("r")) {
             System.out.println(TASK_BASE);
        }

    }

}
