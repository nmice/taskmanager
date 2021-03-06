package ru.neginskiy.tm.command;

public class HelpCommand extends AbstractCommand {

    private final boolean secure = true;

    @Override
    public void execute() {
        for (AbstractCommand command : getBootstrap().getStringToCommand().values()) {
            System.out.printf("%-13s%s%s%n", command.command(), " - ", command.description());
        }
        System.out.println();
    }

    @Override
    public String command() {
        return "help";
    }

    @Override
    public String description() {
        return "Print help";
    }

    @Override
    public boolean isSecure() {
        return secure;
    }
}
