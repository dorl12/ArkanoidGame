// ID:313547085

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * The main class for AnimationRunner.
 * This is a program that defines an animation runner and runs an animation.
 *
 * @author Dor Levy
 */
public class AnimationRunner {

    private int framesPerSecond;
    private Sleeper sleeper;
    private GUI gui;

    /**
     * This method is a constructor of the AnimationRunner class.
     * The method Defines the class members.
     *
     * @param gui This is a GUI
     */
    public AnimationRunner(GUI gui) {
        this.framesPerSecond = 60;
        this.sleeper = new Sleeper();
        this.gui = gui;
    }

    /**
     * The run method gets an animation and runs it on the DrawSurface.
     *
     * @param animation This is an animation
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;

        // Run the animation while the shouldStop method return false.
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis();
            DrawSurface d = this.gui.getDrawSurface();
            animation.doOneFrame(d);
            this.gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}