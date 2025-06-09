// Turtle.java
public class Turtle {
    private double x, y, angle;
    private final Pen pen;
    private final Matrix canvas;

    /**
     * create a turtle at 0,0 facing east with a pen and canvas
     * @param canvas the matrix to draw on
     * @param pen the pen to use for drawing
     */
    public Turtle(Matrix canvas, Pen pen) {
        this.canvas = canvas;
        this.pen    = pen;
        this.x      = 0;
        this.y      = 0;
        this.angle  = 0;
    }

    public double getX()     { return x; }
    public double getY()     { return y; }
    public double getAngle() { return angle; }

    /**
     * move the turtle forward by dist without drawing
     * @param dist distance to move
     */
    public void move(double dist) {
        x += dist * Math.cos(Math.toRadians(angle));
        y += dist * Math.sin(Math.toRadians(angle));
    }

    /**
     * draw a line forward by dist and update position
     * @param dist distance to draw
     */
    public void trace(double dist) {
        double newX = x + dist * Math.cos(Math.toRadians(angle));
        double newY = y + dist * Math.sin(Math.toRadians(angle));
        pen.draw(canvas, x, y, newX, newY);
        x = newX;
        y = newY;
    }

    /** set turtle to a new position without drawing */
    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /** set turtle facing angle in degrees, normalized to 0-359 */
    public void setAngle(double angle) {
        this.angle = (angle % 360 + 360) % 360;
    }

    /** prints the current canvas to the screen */
    public void show() {
        canvas.print();
    }

    /** clears the canvas to all spaces */
    public void clear() {
        canvas.clear();
    }

    /** lift the pen so it stops drawing */
    public void LiftPen() {
        pen.up();
    }

    /** put the pen down so it starts drawing */
    public void penDown() {
        pen.down();
    }
}
