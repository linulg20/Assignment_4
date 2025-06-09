public class LiftPen implements Command {
    private final Turtle turtle;
    /**
     * create penup commnd with given turtel
     * @param t turtel to lift pen from
     */
    public PenUpCommand(Turtle t) {
        this.turtle = t;
    }
    /**
     * run the commnd to lift pen up
     */
    @Override
    public void execute() {
        turtle.penUp();
    }
    /**
     * undo by putting pen back down
     */
    @Override
    public void undo() {
        turtle.penDown();
    }
}
