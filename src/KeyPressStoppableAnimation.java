// ID:313547085

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The main class for KeyPressStoppableAnimation.
 * This is a program that defines a decorator-class that will wrap
 * an existing animation and add a "waiting-for-key" behavior to it.
 *
 * @author Dor Levy
 */
public class KeyPressStoppableAnimation implements Animation {

    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * This method is a constructor of the KeyPressStoppableAnimation class.
     * The method Defines the class members.
     *
     * @param sensor this is a KeyboardSensor
     * @param key this is a String
     * @param animation this is an Animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    /**
     * The doOneFrame method does one frame of the animation on the DrawSurface.
     *
     * @param d This is a DrawSurface on which we do one frame of the animation
     */
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (sensor.isPressed(this.key)) {

            // If the key was pressed before the animation started, we ignore the key press.
            if (!this.isAlreadyPressed) {
                this.stop = true;
            }
        }
        this.isAlreadyPressed = false;
    }

    /**
     * The shouldStop method tells the countdown animation it should stop.
     *
     * @return boolean This returns a boolean value
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
