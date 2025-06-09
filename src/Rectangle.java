public class Rectangle implements Command {
    private final CompositeCommand composite = new CompositeCommand();
    /**
     * create rectangle commnd with width w and height h
     * draws four sides starting top left fasing eest
     * @param t turtle to draw with
     * @param w width of rectengle
     * @param h height of rectengle
     */
    public Rectangle(Turtle t, double w, double h) {
        composite.add(new Trace(t, w - 1));
        composite.add(new Turn(t, 90));
        composite.add(new Trace(t, h - 1));
        composite.add(new Turn(t, 180));
        composite.add(new Trace(t, w - 1));
        composite.add(new Turn(t, 270));
        composite.add(new Trace(t, h - 1));
        composite.add(new Turn(t, 0));
    }
    @Override public void execute() {
        composite.execute();
    }
    @Override public void undo(){
        composite.undo();
    }
}