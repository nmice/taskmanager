package ru.neginskiy.tm.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.neginskiy.tm.command.AbstractCommand;
import ru.neginskiy.tm.endpoint.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@ApplicationScoped
@NoArgsConstructor
@Getter
public class Bootstrap {

    private final Map<String, AbstractCommand> stringToCommand = new HashMap<>();

    @Inject
    private TaskEndpoint taskEndpointService;
    @Inject
    private ProjectEndpoint projectEndpointService;
    @Inject
    private UserEndpoint userEndpointService;
    @Inject
    private SessionEndpoint sessionEndpointService;
    @Inject
    private DataEndpoint dataEndpointService;

    @Setter
    private Session activeSession;

    private final Scanner scanner = new Scanner(System.in);

    public void init(@NotNull Class[] classes) throws IllegalAccessException, InstantiationException {
        registry(classes);
        while (true) {
            receiveCommand();
        }
    }

    private void registry(@NotNull Class... classes) throws InstantiationException, IllegalAccessException {
        for (Class clazz : classes) {
            registry(clazz);
        }
    }

    private void registry(@NotNull Class clazz) throws IllegalAccessException, InstantiationException {
        final Object o = clazz.newInstance();
        if (o instanceof AbstractCommand) {
            final AbstractCommand abstractCommand = (AbstractCommand) clazz.newInstance();
            abstractCommand.setBootstrap(this);
            stringToCommand.put(abstractCommand.command(), abstractCommand);
        }
    }

    private void receiveCommand() {
        System.out.println("Enter command: ");
        final String text = readLine();
        if (text == null) {
            return;
        }
        final AbstractCommand command = stringToCommand.get(text);
        if (command == null) {
            System.out.println("Incorrect command");
            return;
        }
        try {
            if (getActiveSession() != null || command.isSecure()) {
                command.execute();
            } else {
                System.out.println("This command is not available now, please login!");
            }
        } catch (UncorrectSessionException_Exception sessionEx) {
            setActiveSession(null);
            System.out.println("Uncorrect session, please log in");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public @Nullable String readLine() {
        final String str = scanner.nextLine().trim();
        if (str.isEmpty()) {
            System.out.println("Incorrect input");
            return null;
        }
        return str;
    }
}