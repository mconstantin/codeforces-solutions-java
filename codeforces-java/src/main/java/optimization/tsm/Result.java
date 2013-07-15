package optimization.tsm;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class Result {

    private final List<Point> input;
    private final List<Point> path;
    private final double distance;
    private final boolean optimal;

    public Result(List<Point> input, List<Point> path, boolean optimal) {
        this.input = input;
        this.path = path;
        this.distance = calcTotalDistance(path);
        this.optimal = optimal;
    }

    public static double calcTotalDistance(List<Point> path) {
        if (path.isEmpty()) {
            return 0.0;
        }

        double res = 0.0;
        Iterator<Point> it = path.iterator();
        Point prev = it.next();
        Point first = prev;

        while (it.hasNext()) {
            Point next = it.next();
            res = res + prev.distanceTo(next);
            prev = next;
        }

        res = res + prev.distanceTo(first);
        return res;
    }

    public void outputTo(PrintWriter out) {
        out.print(distance);
        out.print(' ');
        out.print(optimal ? 1 : 0);
        out.println();

        for (Point p : path) {
            out.print(p.getNumber());
            out.print(' ');
        }
        out.flush();
    }

    public void visualize(String filename) {
        new Drawer(input, this, filename).visualize();
    }

    public void check() {
        boolean[] visited = new boolean[input.size()];
        for (Point p : path) {
            int number = p.getNumber();
            if (visited[number]) {
                throw new IllegalStateException("not valid path");
            }
            visited[number] = true;
        }
    }

    public double getDistance() {
        return distance;
    }

    public List<Point> getPath() {
        return path;
    }

}
