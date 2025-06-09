public class MoveCommand implements Command {
    private final Turtle turtle;
    private final double dist;
    private double prevX, prevY;

    /**
     * create move commnd with turtel and how far to move
     * @param t turtel to move
     * @param dist distance to move
     */
    public MoveCommand(Turtle t, double dist) {
        this.turtle = t;
        this.dist   = dist;
    }

    /**
     * run commnd to save old pos and move turtel
     */
    @Override
    public void execute() {
        prevX = turtle.getX();
        prevY = turtle.getY();
        turtle.move(dist);
    }

    /**
     * undo by setting turtel back to old pos
     */
    @Override
    public void undo() {
        turtle.setPosition(prevX, prevY);
    }
}