// ID:313547085

/**
 * The main class for Line.
 * This is a program that defines a Line on the screen,
 * including the length of the line, it's middle point and programs
 * that checks if it intersects with other line, returns the intersection
 * point and defines if the two lines are equal.
 *
 * @author Dor Levy
 */
public class Line {

    private Point start;
    private Point end;

    /**
     * This method is a constructor of the Line class.
     * The method Defines the class members.
     *
     * @param start This is the Point at the beginning of the Line
     * @param end   This is the Point at the end of the Line
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * This method is a constructor of the Point Line.
     * The method Defines the class members.
     *
     * @param x1 This is the x value of the start Point
     * @param y1 This is the y value of the start Point
     * @param x2 This is the x value of the end Point
     * @param y2 This is the y value of the end Point
     */

    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * The length method returns the length of the line.
     *
     * @return double This returns the length of the line.
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * The middle method returns the middle point of the line.
     *
     * @return double This returns the middle point of the line.
     */

    public Point middle() {
        double middleX = (this.start.getX() + this.end.getX()) / 2;
        double middleY = (this.start.getY() + this.end.getY()) / 2;
        return new Point(middleX, middleY);
    }

    /**
     * The start method returns the start point of the line.
     *
     * @return Point This returns the start point of the line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * The end method returns the end point of the line.
     *
     * @return Point This returns the end point of the line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * The isIntersecting method gets a Line and returns true if the lines intersect, false otherwise.
     *
     * @param other This is a Line that we check if it intersect with this Line.
     * @return boolean This returns true if the lines intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        // In case two Points are the same return true.
        if (this.start.equals(other.start) || this.start.equals(other.end)
                || this.end.equals(other.start) || this.end.equals(other.end)) {
            return true;
        }
        double x1 = this.start.getX();
        double x2 = this.end.getX();
        double x3 = other.start.getX();
        double x4 = other.end.getX();
        double y1 = this.start.getY();
        double y2 = this.end.getY();
        double y3 = other.start.getY();
        double y4 = other.end.getY();

        // Checking if the lines are out of the range of each other.
        if (Math.max(x1, x2) < Math.min(x3, x4) || Math.max(x3, x4) < Math.min(x1, x2)
                || Math.max(y1, y2) < Math.min(y3, y4) || Math.max(y3, y4) < Math.min(y1, y2)) {
            return false;
        }

        // Calculating the Slope of each line.
        double m1 = (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
        double m2 = (other.start.getY() - other.end.getY()) / (other.start.getX() - other.end.getX());

        // Calculating the b1 and b2 values according to the line formula
        double b1 = y1 - m1 * x1;
        double b2 = y3 - m2 * x3;

        // Calculating the potential x value of the intersection point
        double intersectionPointX = (b2 - b1) / (m1 - m2);

        // Checking if the intersection point is out of bound
        if ((intersectionPointX < Math.max(Math.min(x1, x2), Math.min(x3, x4)))
                || (intersectionPointX > Math.min(Math.max(x1, x2), Math.max(x3, x4)))) {
            return false;
        }
        return true;
    }

    /**
     * The intersectionWith method gets a Line and returns the intersection point if the lines intersect,
     * and null otherwise.
     *
     * @param other This is a Line that the function returns the intersection point if the lines intersect
     * @return Point This returns the intersection point if the lines intersect,
     * and null otherwise.
     */
    public Point intersectionWith(Line other) {
        double x1 = this.start.getX();
        double x2 = this.end.getX();
        double x3 = other.start.getX();
        double x4 = other.end.getX();

        // In case one of the lines is parallel to the Y axis.
        if (x1 == x2 || x3 == x4) {
            return parallelToYAxis(other);
        }
        double y1 = this.start.getY();
        double y2 = this.end.getY();
        double y3 = other.start.getY();
        double y4 = other.end.getY();
        double m1 = (y1 - y2) / (x1 - x2);
        double m2 = (y3 - y4) / (x3 - x4);
        double b1 = y1 - m1 * x1;
        double b2 = y3 - m2 * x3;

        // In case the lines don't intersect or equal to each other
        if (!isIntersecting(other) || equals(other)) {
            return null;
        }

        // Checking if the two lines converge
        if (m1 == m2 && ((Math.min(x1, x2) < Math.max(x3, x4) && Math.max(x1, x2) > Math.min(x3, x4)
                || Math.min(x3, x4) < Math.max(x1, x2) && Math.max(x3, x4) > Math.min(x1, x2)))) {
            return null;
        }

        // In case the lines touch each other in the edges of each line
        if ((m1 == m2 && this.start.equals(other.end))) {
            return this.start;
        }
        if (m1 == m2 && this.end.equals(other.start)) {
            return this.end;
        }

        // Calculating the intersection point
        double intersectionPointX = (b2 - b1) / (m1 - m2);
        double intersectionPointY = m1 * intersectionPointX + b1;
        return new Point(intersectionPointX, intersectionPointY);
    }

    /**
     * The parallelToYAxis method gets a Line and returns the intersection point if the lines intersect,
     * and null otherwise.
     *
     * @param other This is a Line that the function returns the intersection point if the lines intersect
     * @return Point This returns the intersection point if the lines intersect,
     * and null otherwise.
     */
    public Point parallelToYAxis(Line other) {
        double x1 = this.start.getX();
        double x2 = this.end.getX();
        double x3 = other.start.getX();
        double x4 = other.end.getX();
        double y1 = this.start.getY();
        double y2 = this.end.getY();
        double y3 = other.start.getY();
        double y4 = other.end.getY();

        // In case this line is parallel to the Y axis
        if (x1 == x2) {

            // Checking if the intersection point is out of bound
            if ((Math.max(x3, x4) < x1 || Math.min(x3, x4) > x1) || (Math.max(y1, y2) < Math.min(y3, y4))
                    || (Math.min(y1, y2) > Math.max(y3, y4))) {
                return null;
            }
        }

        // In case the other line is parallel to the Y axis
        if (x3 == x4) {

            // Checking if the intersection point is out of bound
            if ((Math.max(x1, x2) < x3 || Math.min(x1, x2) > x3) || (Math.max(y3, y4) < Math.min(y1, y2))
                    || (Math.min(y3, y4) > Math.max(y1, y2))) {
                return null;
            }
        }

        // In case this line is parallel to the Y axis, return the intersection point
        if (x1 == x2) {
            double m2 = (y3 - y4) / (x3 - x4);
            double b2 = y3 - m2 * x3;
            return new Point(x1, m2 * x1 + b2);
        }

        // In case the other line is parallel to the Y axis, return the intersection point
        double m1 = (y1 - y2) / (x1 - x2);
        double b1 = y1 - m1 * x1;
        return new Point(x3, m1 * x3 + b1);
    }

    /**
     * The equals method gets a Line and returns true is the lines are equal, false otherwise.
     *
     * @param other This is a Line that we check if it's equal to this line
     * @return boolean This returns true is the lines are equal, false otherwise.
     */
    public boolean equals(Line other) {
        return (this.start.equals(other.start) || this.start.equals(other.end)) && (this.end.equals(other.start)
                || this.end.equals(other.end));
    }

    /**
     * The closestIntersectionToStartOfLine method gets a Rectangle and returns the closest intersection point
     * between this line and the rectangle if exists, null otherwise.
     *
     * @param rect This is a rectangle that we check if intersects with this line.
     * @return Point This returns the closest intersection point if exists, null otherwise.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {

        // In case this has no intersection points with the rectangle.
        if (rect.intersectionPoints(this).isEmpty()) {
            return null;
        }
        double distanceBetweenPoints = Double.MAX_VALUE;
        Point closestPoint = null;

        // Finding the closest intersection point between the rectangle to the start point of the line.
        for (int i = 0; i < rect.intersectionPoints(this).size(); i++) {
            if (this.start.distance(rect.intersectionPoints(this).get(i)) < distanceBetweenPoints) {
                closestPoint = rect.intersectionPoints(this).get(i);
                distanceBetweenPoints = this.start.distance(rect.intersectionPoints(this).get(i));
            }
        }
        return closestPoint;
    }
}
