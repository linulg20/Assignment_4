

public class SCommand extends CompositeCommand {

     /**
     *  * Draws S  by turning and drawinf
     *  * The S is the same as 5 and they are drawn the same
     * Create an SCommand that draws S by size.
     * It draws 3 straight lines (each 3×size long)
     * and two vertical connectors (each size long).
     * The turtle must start at the top-left of the letter towards looking east
      * @param size the scale factor for the letter
     * @param t the Turtle used to draw
     */
    public SCommand(Turtle t, double size) {
        double v1  = 3 * size;
        double v = size;
        add(new TurnCommand(t,   0));
        add(new TraceCommand(t,   v1 - 1));
        add(new TurnCommand(t, 180));
        add(new TraceCommand(t,   v1 - 1));
        add(new TurnCommand(t,  90));
        add(new TraceCommand(t,   v - 1));
        add(new TurnCommand(t,   0));
        add(new TraceCommand(t,   v1 - 1));
        add(new TurnCommand(t,  90));
        add(new TraceCommand(t,   v - 1));
        add(new TurnCommand(t, 180));
        add(new TraceCommand(t,   v1 - 1));
        add(new TurnCommand(t,   0));
    }
}
