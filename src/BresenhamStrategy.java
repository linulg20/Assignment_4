
public class BresenhamStrategy {

    public void draw(Matrix canvas,
                     double x1, double y1,
                     double x2, double y2)
    {
        int x0 = (int)Math.round(x1);
        int y0 = (int)Math.round(y1);
        int x1i = (int)Math.round(x2);
        int y1i = (int)Math.round(y2);
        int dx = Math.abs(x1i - x0), sx = x0 < x1i ? 1 : -1;
        int dy = Math.abs(y1i - y0), sy = y0 < y1i ? 1 : -1;
        int err = (dx>dy ? dx : -dy)/2, e2;

        while (true) {
            canvas.set(y0, x0, '#');
            if (x0==x1i && y0==y1i) break;
            e2 = err;
            if (e2> -dx) { err -= dy; x0 += sx; }
            if (e2<  dy) { err += dx; y0 += sy; }
        }
    }
}
