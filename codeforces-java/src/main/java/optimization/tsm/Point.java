package optimization.tsm;

public class Point {

    private final int number;
    private final double x;
    private final double y;

    public Point(int number, double x, double y) {
        this.number = number;
        this.x = x;
        this.y = y;
    }

    public double squareDistanceTo(Point p) {
        double dx = p.x - this.x;
        double dy = p.y - this.y;
        return dx * dx + dy * dy;
    }

    public double distanceTo(Point p) {
        return Math.sqrt(squareDistanceTo(p));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getNumber() {
        return number;
    }

}