// ID:313547085

import biuoop.DrawSurface;

/**
 * The main interface for Sprite.
 * This is an interface that includes methods that draw the sprites
 * to the screen and notify the sprites that time has passed.
 *
 * @author Dor Levy
 */
public interface Sprite {

    /**
     * The drawOn method draws the sprite to the screen.
     * @param d This is
     */
    void drawOn(DrawSurface d);

    /**
     * The timePassed method notifies the sprite that time has passed.
     */
    void timePassed();
}
