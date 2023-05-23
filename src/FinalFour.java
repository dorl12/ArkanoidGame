// ID:313547085

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The main class for FinalFour.
 * This is a program that defines the fourth level of the game.
 *
 * @author Dor Levy
 */
public class FinalFour implements LevelInformation {

    private int numberOfBalls;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private int numberOfBlocksToRemove;
    public static final int NUM_OF_ROWS = 7;
    public static final int NUM_OF_REC_IN_ROW = 15;
    private static final int WIDTH_OF_BLOCK = 50;
    private static final int HEIGHT_OF_BLOCK = 20;

    /**
     * This method is a constructor of the FinalFour class.
     * The method Defines the class members.
     */
    public FinalFour() {
        this.numberOfBalls = 3;
        this.paddleSpeed = 18;
        this.paddleWidth = 100;
        this.levelName = "Final Four";
        this.numberOfBlocksToRemove = 105;
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
        int angle = 335;
        for (int i = 0; i < this.numberOfBalls; i++) {
            ballsVelocitiesList.add(Velocity.fromAngleAndSpeed(angle, 6));
            angle += 25;
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

        // Creating an array of colors for the game blocks
        Color[] colors;
        colors = createColorsArray();
        double startingX = 725;
        double startingY = 100;

        // Creating the game blocks using two for loops
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            for (int j = NUM_OF_REC_IN_ROW; j > 0; j--) {
                Block block =
                        new Block(new Rectangle(new Point(startingX, startingY), WIDTH_OF_BLOCK, HEIGHT_OF_BLOCK),
                                colors[i]);
                blocksList.add(block);
                startingX = startingX - WIDTH_OF_BLOCK;
            }
            startingY = startingY + HEIGHT_OF_BLOCK;
            startingX = 725;
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
        colors = new Color[7];
        colors[0] = Color.GRAY;
        colors[1] = Color.RED;
        colors[2] = Color.YELLOW;
        colors[3] = Color.GREEN;
        colors[4] = Color.WHITE;
        colors[5] = Color.PINK;
        colors[6] = Color.CYAN;
        return colors;
    }
}
