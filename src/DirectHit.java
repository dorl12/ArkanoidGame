// ID:313547085

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

/**
 * The main class for DirectHit.
 * This is a program that defines the first level of the game.
 *
 * @author Dor Levy
 */
public class DirectHit implements LevelInformation {

    private int numberOfBalls;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private int numberOfBlocksToRemove;

    /**
     * This method is a constructor of the DirectHit class.
     * The method Defines the class members.
     */
    public DirectHit() {
        this.numberOfBalls = 1;
        this.paddleSpeed = 5;
        this.paddleWidth = 100;
        this.levelName = "Direct Hit";
        this.numberOfBlocksToRemove = 1;
    }

    /**
     * The numberOfBalls method returns the number of balls in the level of the game.
     *
     * @return int This returns the number of balls in the level of the game
     */
    public int numberOfBalls() {
        return this.numberOfBalls;
    }

    /**
     * The initialBallVelocities method returns a list of the ball velocities.
     *
     * @return List<Velocity> This returns a list of the ball velocities
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ballsVelocitiesList = new ArrayList<>();
        ballsVelocitiesList.add(Velocity.fromAngleAndSpeed(0, 6));
        return ballsVelocitiesList;
    }

    /**
     * The paddleSpeed method returns the speed of the paddle of the game.
     *
     * @return int This returns the speed of the paddle of the game
     */
    public int paddleSpeed() {
        return this.paddleSpeed;
    }

    /**
     * The paddleWidth method returns the width of the paddle of the game.
     *
     * @return int This returns the width of the paddle of the game
     */
    public int paddleWidth() {
        return this.paddleWidth;
    }

    /**
     * The levelName method returns the name of the level of the game.
     *
     * @return String This returns the name of the level of the game
     */
    public String levelName() {
        return this.levelName;
    }

    /**
     * The getBackground method returns a sprite with the background of the level.
     *
     * @return Sprite This returns a sprite with the background of the level
     */
    public Sprite getBackground() {
        return new Background(this.levelName);
    }

    /**
     * The blocks method returns a list of the Blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return List<Block> This returns a list of blocks
     */
    public List<Block> blocks() {
        List<Block> blocksList = new ArrayList<>();
        blocksList.add(new Block(new Rectangle(new Point(385, 148), 30, 30), Color.RED));
        return blocksList;
    }

    /**
     * The numberOfBlocksToRemove method returns the number of blocks that should be removed
     * before the level is considered to be "cleared".
     *
     * @return int This returns a number of blocks
     */
    public int numberOfBlocksToRemove() {
        return this.numberOfBlocksToRemove;
    }
}
