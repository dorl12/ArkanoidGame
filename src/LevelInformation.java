// ID:313547085

import java.util.List;

/**
 * The main interface for LevelInformation.
 * This is an interface that defines the information of a level in the game.
 *
 * @author Dor Levy
 */
public interface LevelInformation {

    /**
     * The numberOfBalls method returns the number of balls in the level of the game.
     *
     * @return int This returns the number of balls in the level of the game
     */
    int numberOfBalls();

    /**
     * The initialBallVelocities method returns a list of the ball velocities.
     *
     * @return List<Velocity> This returns a list of the ball velocities
     */
    List<Velocity> initialBallVelocities();

    /**
     * The paddleSpeed method returns the speed of the paddle of the game.
     *
     * @return int This returns the speed of the paddle of the game
     */
    int paddleSpeed();

    /**
     * The paddleWidth method returns the width of the paddle of the game.
     *
     * @return int This returns the width of the paddle of the game
     */
    int paddleWidth();

    /**
     * The levelName method returns the name of the level of the game.
     *
     * @return String This returns the name of the level of the game
     */
    String levelName();

    /**
     * The getBackground method returns a sprite with the background of the level.
     *
     * @return Sprite This returns a sprite with the background of the level
     */
    Sprite getBackground();

    /**
     * The blocks method returns a list of the Blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return List<Block> This returns a list of blocks
     */
    List<Block> blocks();

    /**
     * The numberOfBlocksToRemove method returns the number of blocks that should be removed
     * before the level is considered to be "cleared".
     *
     * @return int This returns a number of blocks
     */
    int numberOfBlocksToRemove();
}