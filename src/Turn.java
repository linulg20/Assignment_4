// Turn.java
public class Turn implements Command {
    private final Turtle turtle;
    private final double heading;
    private double prevH;

    /**
     * create turn commnd with turtel and new heading
     * @param turtle turtel to turn
     * @param heading new heading in degrees
     */
    public Turn(Turtle turtle, double heading) {
        this.turtle  = turtle;
        this.heading = (heading % 360 + 360) % 360;
    }

    /** run the commnd and save old heading */
    @Override public void execute() {
        prevH = turtle.getAngle();
        turtle.setAngle(heading);
    }

    /** undo by setting back old heading */
    @Override public void undo() {
        turtle.setAngle(prevH);
    }
}
