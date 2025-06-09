public class Trace implements Command {
    private final Turtle turtle;
    private final double dist;

    /**
     * create trace commnd with turtle and distance to draw
     * @param turtle turtle to draw with
     * @param dist how far to draw
     */
    public Trace(Turtle turtle, double dist) {
        this.turtle = turtle;
        this.dist   = dist;
    }

    /** run turtle trace for dist */
    @Override public void execute() {
        turtle.trace(dist);
    }

    /** undo trace by moving turtle back by dist */
    @Override public void undo() {
        turtle.move(-dist);
    }
}
