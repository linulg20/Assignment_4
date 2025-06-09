public class Turn implements Command {
    private final Turtle turtle;
    private final double heading;
    private double prevH;
    /**
     * create turn commnd with turtel and new heading
     * @param t turtel to turn
     * @param heading new heading in degrees
     */
    public Turn(Turtle t, double heading) {
        this.turtle  = t;
        this.heading = (heading % 360 + 360) % 360;
    }
    /**
     * run the commnd and save old heading
     */
    @Override
    public void execute() {
        prevH = turtle.getAngle();
        turtle.setAngle(heading);
    }
    /**
     * undo by setting back old heading
     */
    @Override
    public void undo() {
        turtle.setAngle(prevH);
    }
}
