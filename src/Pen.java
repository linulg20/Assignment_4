public class Pen {
    private final BresenhamStrategy strat;
    private boolean down = true;

    /**
     * Create a Pen that uses the given drawing strategy.
     * @param strat the BresenhamStrategy to use for drawing lines
     */
    public Pen(BresenhamStrategy strat) {
        this.strat = strat;
    }

    /**
     * cheks whether the pen is drawin
     * @return true if pen is down n false if pen is up
     */
    public boolean isDown() {
        return down;
    }

    /**
     * stops drawing
     */
    public void up() {
        down = false;
    }

    /**
     * start drawinf
     */
    public void down() {
        down = true;
    }

    /**
     * @param canvas the Matrix to draw on
     * @param x1     starting x-coordinate
     * @param y1     starting y-coordinate
     * @param x2     ending x-coordinate
     * @param y2     ending y-coordinate
     */
    public void draw(Matrix canvas,
                     double x1, double y1,
                     double x2, double y2) {
        if (!down) return;
        strat.draw(canvas, x1, y1, x2, y2);
    }
}
