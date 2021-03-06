package ru.neginskiy.tm.command;

import ru.neginskiy.tm.endpoint.Task;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;

import static ru.neginskiy.tm.util.GcToStrUtil.getStrFromGc;
import static ru.neginskiy.tm.util.StrToGcUtil.getGcFromStr;

public class TaskEditCommand extends AbstractCommand {

    private final boolean secure = false;

    @Override
    public void execute() {
        System.out.println("Please select project number to update :");
        List<Task> taskList = getBootstrap().getTaskEndpointService().taskGetAll();
        int index = 0;
        for (Task task : taskList) {
            System.out.printf("%-3s%s%s%n", index++, " - ", task.getName());
        }

        Task task;
        try {
            int taskNumber = Integer.parseInt(getBootstrap().readLine());
            task = taskList.get(taskNumber);
            if (task == null) {
                System.out.println("Incorrect input, task not found");
                return;
            }
            System.out.printf("%s (%s), %s - %s%n", task.getName(), task.getDescription(), getStrFromGc(task.getDateBegin()), getStrFromGc(task.getDateEnd()));
        } catch (Exception e) {
            System.out.println("Incorrect input, task not found");
            return;
        }

        System.out.println("Enter the command: \r\n" +
                "changename        - change name of task \r\n" +
                "changedescription - change description of task \r\n" +
                "changebegindate   - Change a begin date of task \r\n" +
                "changeenddate     - change a end date of task");
        String updateCommandString = getBootstrap().readLine();
        switch (updateCommandString) {
            case "changename":
                System.out.println("Please enter a new task name: ");
                String name = getBootstrap().readLine();
                task.setName(name);
                System.out.println("Name changed");
                break;
            case "changedescription":
                System.out.println("Please enter a new task description: ");
                String description = getBootstrap().readLine();
                task.setDescription(description);
                System.out.println("Description changed");
                break;

            case "changebegindate":
                System.out.println("Please enter a new task begin date: ");
                XMLGregorianCalendar dateBegin = getGcFromStr(getBootstrap().readLine());
                if (dateBegin == null) {
                    return;
                }
                XMLGregorianCalendar dateEnd = task.getDateEnd();
                if (dateEnd != null && dateEnd.getMillisecond() < dateBegin.getMillisecond()) {
                    System.out.println("End date must be later than the begin date, incorrect input");
                    return;
                }
                task.setDateBegin(dateBegin);
                System.out.println("Begin date changed");
                break;
            case "changeenddate":
                System.out.println("Please enter a new task end date: ");
                dateEnd = getGcFromStr(getBootstrap().readLine());
                if (dateEnd == null) {
                    return;
                }
                dateBegin = task.getDateBegin();
                if (dateBegin != null && dateEnd.getMillisecond() < dateBegin.getMillisecond()) {
                    System.out.println("End date must be later than the begin date, incorrect input");
                    return;
                }
                task.setDateEnd(dateEnd);
                System.out.println("End date changed");
                break;
        }
        getBootstrap().getTaskEndpointService().taskMerge(task);
        System.out.println("Task updated");
    }

    @Override
    public String command() {
        return "taskedit";
    }

    @Override
    public String description() {
        return "Edit task";
    }

    @Override
    public boolean isSecure() {
        return secure;
    }
}
