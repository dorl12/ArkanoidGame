// ID:313547085

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The main class for EndScreenGameOver.
 * This is a program that displays a end screen with the message "Game Over" with the score of the player
 * if the game ended with the player dying (i.e. all balls fall off the screen).
 *
 * @author Dor Levy
 */
public class EndScreenGameOver implements Animation {

    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter score;

    /**
     * This method is a constructor of the EndScreenGameOver class.
     * The method Defines the class members.
     *
     * @param k this is a KeyboardSensor
     * @param score this is a counter that displays the score of the player
     */
    public EndScreenGameOver(KeyboardSensor k, Counter score) {
        this.keyboard = k;
        this.stop = false;
        this.score = score;
    }

    /**
     * The doOneFrame method does one frame of the animation on the DrawSurface.
     *
     * @param d This is a DrawSurface on which we do one frame of the animation
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(d.getWidth() / 4, d.getHeight() / 2, "Game Over. Your score is " + this.score.getValue(),
                32);
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
