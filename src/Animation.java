// ID:313547085

import biuoop.DrawSurface;

/**
 * The main interface for Animation.
 * This is an interface that includes methods that do one frame of the animation
 * on a DrawSurface and tell to the animation when to stop.
 *
 * @author Dor Levy
 */
public interface Animation {

    /**
     * The doOneFrame method does one frame of the animation on the DrawSurface.
     *
     * @param d This is a DrawSurface on which we do one frame of the animation
     */
    void doOneFrame(DrawSurface d);

    /**
     * The shouldStop method tells the animation it should stop.
     *
     * @return This returns a boolean value
     */
    boolean shouldStop();
}