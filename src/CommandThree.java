public class CommandThree extends CompositeCommand {
    /**
     * creat three command that draws three horizntal lines and two vertcal lines of size
     * start top left corner
     * @param t turtle to draw with
     * @param size factor for the shape
     */
    public CommandThree(Turtle t, double size) {
        double t = 3 * size;
        double v = size;

        add(new Command() {
            @Override public void execute() {
                t.setPosition(0, 0);
                t.setAngle(0);
            }
            @Override public void undo() {
            }
        });

        add(new TraceCommand(t, t));
        add(new TurnCommand(t, 90));
        add(new TraceCommand(t, v));
        add(new TurnCommand(t, 180));
        add(new MoveCommand(t, t));
        add(new TurnCommand(t, 0));
        add(new TraceCommand(t, t));
        add(new TurnCommand(t, 90));
        add(new TraceCommand(t, v));
        add(new TurnCommand(t, 180));
        add(new MoveCommand(t, t));
        add(new TurnCommand(t, 0));
        add(new TraceCommand(t, t));
        add(new TurnCommand(t, 0));
    }
}
