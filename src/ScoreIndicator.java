// ID:313547085

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * The main class for ScoreIndicator.
 * This is a program that defines a ScoreIndicator and draws it on the screen.
 *
 * @author Dor Levy
 */
public class ScoreIndicator implements Sprite {

    private Point location;
    private Counter score;

    /**
     * This method is a constructor of the ScoreIndicator class.
     * The method Defines the class members.
     *
     * @param score This is a counter of the score
     */
    public ScoreIndicator(Counter score) {
        this.location = new Point(400, 15);
        this.score = score;
    }

    /**
     * The drawOn method gets a surface and draws the ScoreIndicator on the given DrawSurface.
     *
     * @param d This is the DrawSurface on which we draw the ScoreIndicator.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText((int) this.location.getX(), (int) this.location.getY(), "Score: " + this.score.getValue(), 15);
    }

    /**
     * The timePassed method notifies the ScoreIndicator that time has passed and makes it move.
     * currently, the method does nothing.
     */
    public void timePassed() {
    }
}
