/**
 * interface is for commands to can do and then undo.
 * do the command.
 * take back the command.
 */
public interface Command {

    void execute();
    void undo();
}
