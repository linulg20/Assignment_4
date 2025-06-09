public class Trace implements Command {
    private final Turtle t;
    private final double dist;

    /**
     * create trace commnd with turtle and distance to draw
     * @param t turtle to draw with
     * @param dist how far to draw
     */
    public Trace(Turtle t, double dist) {
        this.t = t;
        this.dist = dist;
    }

    /**
     * run turtle trace for dist
     */
    @Override
    public void execute() {
        t.trace(dist);
    }

    /**
     * undo trace by moving turtle back by dist
     */
    @Override
    public void undo() {
        t.move(-dist);
    }
}
