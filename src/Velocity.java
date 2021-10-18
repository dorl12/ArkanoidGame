// ID:313547085

/**
 * The main class for Velocity.
 * This is a program that defines a Velocity of a ball,
 * apply the change in the position of the center point of the ball
 * and converts the velocity from angle and speed parameters.
 *
 * @author Dor Levy
 */
public class Velocity {

    private double dx;
    private double dy;
    /**
     * This method is the constructor of the Velocity class.
     * The method Defines the class members.
     *
     * @param dx This is the change in position on the x axe
     * @param dy This is the change in position on the y axe
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * The getDx method returns the dx value of the velocity.
     *
     * @return double This returns the dx value of the velocity.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * The getDy method returns the dy value of the velocity.
     *
     * @return double This returns the dy value of the velocity.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * The applyToPoint method Takes a point with position (x,y) and returns a new point
     * with position (x+dx, y+dy).
     *
     * @param p This is a point that the method apply on
     * @return Point This returns a new point with position (x+dx, y+dy).
     */
    public Point applyToPoint(Point p) {
        double x = p.getX();
        double y = p.getY();
        return new Point(x + this.dx, y + this.dy);
    }

    /**
     * The fromAngleAndSpeed method converts an angle and a speed into velocity.
     *
     * @param angle This is an angle of movement
     * @param speed This is a speed
     * @return Velocity This returns a new Velocity.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = Math.sin(Math.toRadians(angle)) * speed;
        double dy = -Math.cos(Math.toRadians(angle)) * speed;
        return new Velocity(dx, dy);
    }

    /**
     * The getSpeed method returns the speed value of the velocity.
     *
     * @return int This returns the speed value of the velocity
     */
    public double getSpeed() {
        return Math.sqrt(Math.pow(this.dx, 2) + Math.pow(this.dy, 2));
    }
}
