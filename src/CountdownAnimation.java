// ID:313547085

import biuoop.DrawSurface;
import biuoop.Sleeper;
import java.awt.Color;

/**
 * The main class for CountdownAnimation.
 * This is a program that displays a given gameScreen,
 * for numOfSeconds seconds, and on top of it, it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before
 * it is replaced with the next one.
 *
 * @author Dor Levy
 */
public class CountdownAnimation implements Animation {

    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean startGame;
    private Counter numOnScreen;

    /**
     * This method is a constructor of the CountdownAnimation class.
     * The method Defines the class members.
     *
     * @param numOfSeconds this is a number of seconds for the Countdown Animation to appear
     * @param countFrom this is a number from which we begin the Countdown
     * @param gameScreen this is a game screen
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.startGame = false;
        this.numOnScreen = new Counter(countFrom);
    }

    /**
     * The doOneFrame method does one frame of the Countdown animation on the DrawSurface.
     *
     * @param d This is a DrawSurface on which we do one frame of the Countdown animation
     */
    public void doOneFrame(DrawSurface d) {
        Sleeper sleeper = new Sleeper();
        this.gameScreen.drawAllOn(d);

        // In case we reached zero through the countdown, the game will begin
        if (this.numOnScreen.getValue() == 0) {
            this.startGame = true;
        }
        d.setColor(Color.GRAY);
        d.drawText(385, 350, String.valueOf(numOnScreen.getValue()), 60);
        if (this.numOnScreen.getValue() != this.countFrom) {
            sleeper.sleepFor((long) (this.numOfSeconds / this.countFrom * 1000));
        }
        this.numOnScreen.decrease(1);
    }

    /**
     * The shouldStop method tells the countdown animation it should stop.
     *
     * @return boolean This returns a boolean value
     */
    public boolean shouldStop() {
        return this.startGame;
    }
}
