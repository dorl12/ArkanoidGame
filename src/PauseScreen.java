// ID:313547085

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The main class for PauseScreen.
 * This is a program that will display a screen with the message "paused -- press space to continue"
 * until a key is pressed.
 *
 * @author Dor Levy
 */
public class PauseScreen implements Animation {

    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * This method is a constructor of the PauseScreen class.
     * The method Defines the class members.
     *
     * @param k this is a KeyboardSensor
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * The doOneFrame method does one frame of the animation on the DrawSurface.
     *
     * @param d This is a DrawSurface on which we do one frame of the animation
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(d.getWidth() / 4, d.getHeight() / 2, "paused -- press space to continue", 32);
    }

    /**
     * The shouldStop method tells the animation it should stop.
     *
     * @return boolean This returns a boolean value
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
