public class Show implements Command {
    private final Turtle turtle;
    /**
     * create show commnd with given turtel
     * @param t turtel to show canavs from
     */
    public Show(Turtle t) {
        this.turtle = t;
    }
    /**
     * run the show method on turtel
     */
    @Override
    public void execute() {
        turtle.show();
    }
    /**
     * undo does nothing
     */
    @Override
    public void undo() {
    }
}
