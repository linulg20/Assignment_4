import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
/**
 * starts a simlpe turtel editor to read and run commnads
 */
public class TurtleEditor {
    /**
     * main method to read input and run commnads
     * @param args none used
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Matrix canvas = new Matrix(20, 60);
        Pen pen = new Pen(new BresenhamStrategy());
        Turtle turtle = new Turtle(canvas, pen);

        Deque<Command> undoStack = new ArrayDeque<>();
        Deque<Command> redoStack = new ArrayDeque<>();

        while (true) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");
            Command cmd = null;

            try {
                switch (parts[0]) {
                    case "clear":
                        turtle.clear();
                        undoStack.clear();
                        redoStack.clear();
                        continue;
                    case "rectangle": {
                        double w = Double.parseDouble(parts[1]);
                        double h = Double.parseDouble(parts[2]);
                        cmd = new Rectangle(turtle, w, h);
                        break;
                    }
                    case "s": {
                        double sz = Double.parseDouble(parts[1]);
                        int rows = (int) (2 * sz + 3);
                        canvas = new Matrix(rows, (int) (3 * sz) + 1, ' ');
                        turtle = new Turtle(canvas, pen);
                        cmd = new CommandS(turtle, sz);
                        break;
                    }
                    case "e": {
                        double esz = Double.parseDouble(parts[1]);
                        int erows = Integer.parseInt(parts[2]);
                        canvas = new Matrix(erows, (int) (3 * esz) + 1, ' ');
                        turtle = new Turtle(canvas, pen);
                        cmd = new CommandE(turtle, esz);
                        break;
                    }
                    case "three": {
                        double tSize = Double.parseDouble(parts[1]);
                        int tRows = Integer.parseInt(parts[2]);
                        canvas = new Matrix(tRows, (int) (3 * tSize) + 1, ' ');
                        turtle = new Turtle(canvas, pen);
                        cmd = new ThreeCommand(turtle, tSize);
                        break;
                    }
                    case "textse350": {
                        canvas = new Matrix(5, 19, ' ');
                        turtle = new Turtle(canvas, pen);
                        cmd = new TextSE350Command(turtle, 0, 0, 1);
                        break;
                    }
                    case "show":
                        cmd = new Show(turtle);
                        break;
                    case "move":
                        cmd = new MoveCommand(turtle, Double.parseDouble(parts[1]));
                        break;
                    case "trace":
                        cmd = new Trace(turtle, Double.parseDouble(parts[1]));
                        break;
                    case "turn":
                        cmd = new Turn(turtle, Double.parseDouble(parts[1]));
                        break;
                    case "undo":
                        if (!undoStack.isEmpty()) {
                            Command u = undoStack.pop();
                            u.undo();
                            redoStack.push(u);
                        }
                        continue;
                    case "redo":
                        if (!redoStack.isEmpty()) {
                            Command r = redoStack.pop();
                            r.execute();
                            undoStack.push(r);
                        }
                        continue;
                    case "quit":
                        return;
                    default:
                        continue;
                }
            } catch (Exception ex) {
                continue;
            }

            cmd.execute();
            undoStack.push(cmd);
            redoStack.clear();
        }
    }
}