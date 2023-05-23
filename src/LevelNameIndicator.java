// ID:313547085

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * The main class for LevelNameIndicator.
 * This is a program that defines a LevelNameIndicator and draws it on the screen.
 *
 * @author Dor Levy
 */
public class LevelNameIndicator implements Sprite {

    private Point location;
    private String levelName;

    /**
     * This method is a constructor of the LevelNameIndicator class.
     * The method Defines the class members.
     *
     * @param levelName This is a name of a level of the game
     */
    public LevelNameIndicator(String levelName) {
        this.location = new Point(600, 15);
        this.levelName = levelName;
    }

    /**
     * The drawOn method gets a surface and draws the LevelNameIndicator on the given DrawSurface.
     *
     * @param d This is the DrawSurface on which we draw the LevelNameIndicator.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText((int) this.location.getX(), (int) this.location.getY(),
                "Level Name: " + String.valueOf(levelName), 15);
    }

    /**
     * The timePassed method notifies the LevelNameIndicator that time has passed and makes it move.
     * currently, the method does nothing.
     */
    public void timePassed() {
    }
}
