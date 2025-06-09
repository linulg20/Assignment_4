public class TextSE350Command implements Command {
    private final CompositeCommand composite = new CompositeCommand();

    /**
     * creat textse350 commnd at pos x y with scale size
     * @param t turtle to draw with
     * @param x x start pos
     * @param y y start pos
     * @param size scale factor
     */
    public TextSE350Command(Turtle t, double x, double y, double size) {
        double letterWidth = 3 * size;
        double gap         = size;
        double stride      = letterWidth + gap;

        double[] xx = {
                x,
                x + 1 * stride,
                x + 2 * stride,
                x + 3 * stride,
                x + 4 * stride
        };

        class Teleport implements Command {
            private final double tx, ty, ang;
            private double oldX, oldY, oldAng;
            Teleport(double tx, double ty, double ang) {
                this.tx = tx; this.ty = ty; this.ang = ang;
            }
            @Override public void execute() {
                oldX   = t.getX();
                oldY   = t.getY();
                oldAng = t.getAngle();
                t.LiftPen();
                t.setPosition(tx, ty);
                t.setAngle(ang);
                t.penDown();
            }
            @Override public void undo() {
                t.LiftPen();
                t.setPosition(oldX, oldY);
                t.setAngle(oldAng);
                t.penDown();
            }
        }

        composite.add(new Teleport(xx[0], y, 0));
        composite.add(new CommandS(t, size));
        composite.add(new Teleport(xx[1], y, 0));
        composite.add(new CommandE(t, size));
        composite.add(new Teleport(xx[2], y, 0));
        composite.add(new ThreeCommand(t, size));
        composite.add(new Teleport(xx[3], y, 0));
        composite.add(new CommandS(t, size));
        composite.add(new Teleport(xx[4], y, 0));
        composite.add(new Rectangle(
                t,
                letterWidth,
                2 * size + 3
        ));
        composite.add(new Turn(t, 0));
    }

    @Override public void execute() {
        composite.execute();
    }

    @Override public void undo() {
        composite.undo();
    }
}