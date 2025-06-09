public class PenDown implements Command {
    private final Turtle turtle;

    /**
     * create pendown commnd with given turtel
     * @param t turtel to drop pen on canvas
     */
    public PenDown(Turtle t) {
        this.turtle = t;
    }

    /**
     * run the commnd to put pen down
     */
    @Override
    public void execute() {
        turtle.penDown();
    }
    /**
     * undo by lifting pen up
     */
    @Override
    public void undo() {
        turtle.LiftPen();
    }
}