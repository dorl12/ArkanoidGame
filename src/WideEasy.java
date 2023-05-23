// ID:313547085

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The main class for WideEasy.
 * This is a program that defines the second level of the game.
 *
 * @author Dor Levy
 */
public class WideEasy implements LevelInformation {

    private int numberOfBalls;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private int numberOfBlocksToRemove;
    private static final int WIDTH_OF_BLOCK = 50;

    /**
     * This method is a constructor of the WideEasy class.
     * The method Defines the class members.
     */
    public WideEasy() {
        this.numberOfBalls = 10;
        this.paddleSpeed = 4;
        this.paddleWidth = 600;
        this.levelName = "Wide Easy";
        this.numberOfBlocksToRemove = 15;
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
        for (int i = 0; i < this.numberOfBalls; i++) {
            ballsVelocitiesList.add(Velocity.fromAngleAndSpeed(85 - 19 * i, 8));
        }
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
        Color[] colors;
        colors = createColorsArray();
        double startingX = 725;
        double startingY = 250;
        for (int i = 0; i < 3; i++) {
            blocksList.add(new Block(new Rectangle(new Point(startingX, startingY), WIDTH_OF_BLOCK, 20),
                    colors[i]));
            startingX -= WIDTH_OF_BLOCK;
            blocksList.add(new Block(new Rectangle(new Point(startingX, startingY), WIDTH_OF_BLOCK, 20),
                    colors[i]));
            startingX -= WIDTH_OF_BLOCK;
        }
        blocksList.add(new Block(new Rectangle(new Point(startingX, startingY), WIDTH_OF_BLOCK, 20),
                Color.GREEN));
        startingX -= WIDTH_OF_BLOCK;
        blocksList.add(new Block(new Rectangle(new Point(startingX, startingY), WIDTH_OF_BLOCK, 20),
                Color.GREEN));
        startingX -= WIDTH_OF_BLOCK;
        blocksList.add(new Block(new Rectangle(new Point(startingX, startingY), WIDTH_OF_BLOCK, 20),
                Color.GREEN));
        startingX -= WIDTH_OF_BLOCK;
        for (int i = 3; i < 6; i++) {
            blocksList.add(new Block(new Rectangle(new Point(startingX, startingY), WIDTH_OF_BLOCK, 20),
                    colors[i]));
            startingX -= WIDTH_OF_BLOCK;
            blocksList.add(new Block(new Rectangle(new Point(startingX, startingY), WIDTH_OF_BLOCK, 20),
                    colors[i]));
            startingX -= WIDTH_OF_BLOCK;
        }
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

    /**
     * The createColorsArray method creates a new colors array.
     *
     * @return Color[] This returns a new array of colors
     */
    public Color[] createColorsArray() {
        Color[] colors;
        colors = new Color[6];
        colors[0] = Color.CYAN;
        colors[1] = Color.PINK;
        colors[2] = Color.BLUE;
        colors[3] = Color.YELLOW;
        colors[4] = Color.ORANGE;
        colors[5] = Color.RED;
        return colors;
    }
}
