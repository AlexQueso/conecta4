package utils.views;

import conecta4.types.Message;
import org.apache.commons.lang.math.IntRange;
import utils.models.Command;

import java.util.ArrayList;

public abstract class Menu {

    private ArrayList<Command> commands;

    public Menu() {
        this.commands = new ArrayList<>();
    }

    public void execute() {
        boolean error;
        int option;
        ArrayList<Command> activeCommands = getActiveCommands();
        assert activeCommands.size() > 0;
        do {
            error = false;
            this.printMenuActiveCommands(activeCommands);
            option = Console.getInstance().readInt("") - 1;
            if (!new IntRange(0, activeCommands.size() - 1).containsInteger(option)) {
                error = true;
            }
        } while (error);
        activeCommands.get(option).execute();
    }

    private ArrayList<Command> getActiveCommands() {
        ArrayList<Command> activeCommands = new ArrayList<>();
        for (Command command : commands) {
            if (command.isActive()) {
                activeCommands.add(command);
            }
        }
        return activeCommands;
    }

    private void printMenuActiveCommands(ArrayList<Command> activeCommands) {
        Console.getInstance().writeln();
        Console.getInstance().writeln(Message.MENU_HEADER.toString());
        for (int i = 0; i < activeCommands.size(); i++) {
            Console.getInstance().writeln((i + 1) + ") " + activeCommands.get(i).getTitle());
        }
    }

    protected void addCommand(Command command) {
        this.commands.add(command);
    }
}
