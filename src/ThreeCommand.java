// ThreeCommand.java
public class ThreeCommand extends CompositeCommand {
    /**
     * creat three command that draws three horizntal lines and two vertcal lines of size
     * start top left corner
     * @param turtle turtle to draw with
     * @param size factor for the shape
     */
    public ThreeCommand(Turtle turtle, double size) {
        double bar  = 3 * size;
        double vert = size;

        // teleport home
        add(new Command() {
            @Override public void execute() {
                turtle.setPosition(0, 0);
                turtle.setAngle(0);
            }
            @Override public void undo() { }
        });

        add(new Trace(turtle, bar));
        add(new Turn(turtle, 90));
        add(new Trace(turtle, vert));
        add(new Turn(turtle, 180));
        add(new MoveCommand(turtle, bar));
        add(new Turn(turtle, 0));
        add(new Trace(turtle, bar));
        add(new Turn(turtle, 90));
        add(new Trace(turtle, vert));
        add(new Turn(turtle, 180));
        add(new MoveCommand(turtle, bar));
        add(new Turn(turtle, 0));
        add(new Trace(turtle, bar));
        add(new Turn(turtle, 0));
    }
}
