public class LiftPen implements Command {
    private final Turtle turtle;
    /**
     * create penup commnd with given turtel
     * @param t turtel to lift pen from
     */
    public LiftPen(Turtle t) {
        this.turtle = t;
    }
    /**
     * run the commnd to lift pen up
     */
    @Override
    public void execute() {
        turtle.LiftPen();
    }
    /**
     * undo by putting pen back down
     */
    @Override
    public void undo() {
        turtle.penDown();
    }
}
