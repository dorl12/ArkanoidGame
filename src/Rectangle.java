// ID:313547085

import java.util.ArrayList;
import java.util.List;

/**
 * The main class for Rectangle.
 * This is a program that Create a new rectangle with location and width/height.
 * In addition the program creates a List of intersection points of the rectangle
 * with a specified line.
 *
 * @author Dor Levy
 */
public class Rectangle {

    private Point upperLeft;
    private double width;
    private double height;

    /**
     * This method is a constructor of the Rectangle class.
     * The method Defines the class members.
     *
     * @param upperLeft This is the upper left point of the rectangle
     * @param width This is the width of the rectangle
     * @param height This is the height of the rectangle
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }


    /**
     * The getWidth method returns the width of the rectangle.
     *
     * @return double This returns the width of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * The getHeight method returns the height of the rectangle.
     *
     * @return double This returns the height of the rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * The getUpperLeft method returns the upper left point of the rectangle.
     *
     * @return Point This returns the upper left point of the rectangle
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * The setUpperLeft method gets the x and y values and sets the upper left point of the rectangle.
     *
     * @param x This is the x value of the upper left point of the rectangle
     * @param y This is the y value of the upper left point of the rectangle
     */
    public void setUpperLeft(double x, double y) {
        this.upperLeft = new Point(x, y);
    }

    /**
     * The intersectionPoints method gets a Line and returns a (possibly empty) List of intersection points
     * with the specified line.
     *
     * @param line This is a line
     * @return java.util.List<Point> This returns a list of intersection points with the line
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        double upperLeftXValue = this.upperLeft.getX();
        double upperLeftYValue = this.upperLeft.getY();

        // Defining the sides of the rectangle
        Line leftSide = new Line(upperLeftXValue, upperLeftYValue, upperLeftXValue, upperLeftYValue
                + this.height);
        Line upperSide = new Line(upperLeftXValue, upperLeftYValue, upperLeftXValue + this.width,
                upperLeftYValue);
        Line rightSide = new Line(upperLeftXValue + this.width, upperLeftYValue, upperLeftXValue
                + this.width, upperLeftYValue + this.height);
        Line lowerSide = new Line(upperLeftXValue, upperLeftYValue + this.height, upperLeftXValue
                + this.width, upperLeftYValue + this.height);

        // getting the four lines of the rectangle into an array
        Line[] linesArray;
        linesArray = new Line[4];
        linesArray[0] = leftSide;
        linesArray[1] = upperSide;
        linesArray[2] = rightSide;
        linesArray[3] = lowerSide;
        List<Point> intersectionPointsList = new ArrayList<>();

        // getting the intersection points of the sides of the rectangle with the line
        for (int i = 0; i < linesArray.length; i++) {
            Point intersectionPoint = linesArray[i].intersectionWith(line);
            if (intersectionPoint != null) {
                intersectionPointsList.add(intersectionPoint);
            }
        }
        return intersectionPointsList;
    }
}
