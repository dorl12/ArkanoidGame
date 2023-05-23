// ID:313547085

/**
 * The main class for Point.
 * This is a program that defines a point on the screen,
 * including the distance between two points and a program
 * to check if two points are equals.
 *
 * @author Dor Levy
 */
public class Point {

    private static final double EPSILON = Math.pow(10, -10);

    private double x;
    private double y;
    /**
     * This method is the constructor of the Point class.
     * The method Defines the class members.
     *
     * @param x This is the x value of the Point
     * @param y This is the y value of the Point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * The distance method gets a Point and returns return the distance of this point to the other point.
     *
     * @param other is a Point that we measure the distance between it and the Point.
     * @return double This returns the distance between other and the Point.
     */
    public double distance(Point other) {
        double x1 = this.x;
        double y1 = this.y;
        double x2 = other.x;
        double y2 = other.y;

        // In case the Points are the same Point.
        if (x1 == x2 && y1 == y2) {
            return 0;
        }
        return Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
    }

    /**
     * The equals method gets a Point and returns true is the points are equal, false otherwise.
     *
     * @param other This is a Point that we check if it is equal to this Point.
     * @return boolean This returns true is the points are equal, false otherwise.
     */
    public boolean equals(Point other) {

        // In case other is null
        if (other == null) {
            return false;
        }
        return (Math.abs(this.x - other.x) <= EPSILON && Math.abs(this.y - other.y) <= EPSILON);
    }

    /**
     * The getX method returns the x value of the Point.
     *
     * @return double This returns the x value of the Point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * The getY method returns the y value of the Point.
     *
     * @return double This returns the y value of the Point.
     */
    public double getY() {
        return this.y;
    }
}
