import java.util.ArrayList;
import java.util.List;
/**
 * composite of multple commands that run togher
 */
public class CompositeCommand implements Command {
    private final List<Command> commands = new ArrayList<>();
    /**
     * create empty composite command
     */
    public CompositeCommand() {
    }
    /**
     * create composite with an existing list of commands
     * @param cmds list of commands to add
     */
    public CompositeCommand(List<Command> cmds) {
        commands.addAll(cmds);
    }

    /**
     * add command to the composite
     * @param cmd command to add
     */
    public void add(Command cmd) {
        commands.add(cmd);
    }
    /**
     * run command in the order added
     */
    @Override
    public void execute() {
        for (Command c : commands) {
            c.execute();
        }
    }
    /**
     * undo commands in reverse order
     */
    @Override
    public void undo() {
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }
}
