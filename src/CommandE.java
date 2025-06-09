
public class ECommand extends CompositeCommand {
    /**
     * create e command that draws 3 horizontal lines of length 3*size
     * and two vertical lines of length size starts at top left corner
     * @param t turtle to draw with
     * @param size scale factor for the letter
     */
    public ECommand(Turtle t, double size) {
        double e = 3 * size;
        double v = size;

        add(new Command() {
            @Override public void execute() {
                t.setPosition(0, 0);
                t.setAngle(0);
            }
            @Override public void undo() {
            }
        });
        add(new TraceCommand(t, e));
        add(new TurnCommand(t, 180));
        add(new TraceCommand(t, e));
        add(new TurnCommand(t, 90));
        add(new TraceCommand(t, v));
        add(new TurnCommand(t, 0));
        add(new TraceCommand(t, e));
        add(new TurnCommand(t, 180));
        add(new TraceCommand(t, e));
        add(new TurnCommand(t, 90));
        add(new TraceCommand(t, v));
        add(new TurnCommand(t, 0));
        add(new TraceCommand(t, e));
        add(new TurnCommand(t, 0));
    }
}
