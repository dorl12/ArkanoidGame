// ID:313547085

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
import java.util.List;

/**
 * The main class for GameLevel.
 * This is a program that defines a GameLevel, adds sprites and collidables to the GameLevel and removes them,
 * created balls on the top of the paddle, initializes and runs the GameLevel.
 *
 * @author Dor Levy
 */
public class GameLevel implements Animation {

    private static final int HEIGHT_OF_BLOCK = 20;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter remainingBlocks;
    private Counter remainingBalls;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;

    /**
     * This method is a constructor of the GameLevel class.
     * The method Defines the class members.
     *
     * @param levelInformation this is a LevelInformation
     * @param keyboardSensor this is a KeyboardSensor
     * @param animationRunner this is an AnimationRunner
     * @param score this is a counter of the score of the player
     */
    public GameLevel(LevelInformation levelInformation, KeyboardSensor keyboardSensor,
                     AnimationRunner animationRunner, Counter score) {
        this.levelInformation = levelInformation;
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.remainingBlocks = new Counter(this.levelInformation.blocks().size());
        this.remainingBalls = new Counter(this.levelInformation.numberOfBalls());
        this.score = score;
        this.runner = animationRunner;
        this.running = true;
        this.keyboard = keyboardSensor;
    }

    /**
     * The GameEnvironment method returns the gameEnvironment of the game.
     *
     * @return GameEnvironment This returns the gameEnvironment of the game.
     */
    public GameEnvironment getGameEnvironment() {
        return this.environment;
    }

    /**
     * The addCollidable method adds collidables objects to the game environment.
     *
     * @param c This is a collidable object that we add to the game environment.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * The addSprite method adds sprites objects to the game environment.
     *
     * @param s This is a sprite that we add to the game environment.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * The initialize method Initializes a new GameLevel by adding sprites to the background of the level,
     * creating the paddle of the game, creating the borders of the game and adding the blocks of the level
     * to the game environment.
     */
    public void initialize() {
        this.sprites.addSprite(this.levelInformation.getBackground());

        // Creating the paddle of the game and adding it to the game
        Paddle gamePaddle = new Paddle(new Rectangle(new Point(Math.abs(400 - this.levelInformation.paddleWidth() / 2),
                560), this.levelInformation.paddleWidth(), HEIGHT_OF_BLOCK), Color.YELLOW,
                this.keyboard, 20, 780, this.levelInformation.paddleSpeed());
        gamePaddle.addToGame(this);
        this.environment.setPaddle(gamePaddle);

        // Creating the blocks that delimit the game environment
        Block upperBlock = new Block(new Rectangle(new Point(0, 18), 800, 20), Color.GRAY);
        upperBlock.addToGame(this);
        Block lowerBlock = new Block(new Rectangle(new Point(0, 600), 800, 800), Color.GRAY);
        lowerBlock.addToGame(this);
        BallRemover ballRemover = new BallRemover(this, this.remainingBalls);

        // Add the ballRemover to the hitListener list
        lowerBlock.addHitListener(ballRemover);
        Block leftBlock = new Block(new Rectangle(new Point(0, 18), 25, 800), Color.GRAY);
        leftBlock.addToGame(this);
        Block rightBlock = new Block(new Rectangle(new Point(775, 18), 800, 800), Color.GRAY);
        rightBlock.addToGame(this);
        BlockRemover blockRemover = new BlockRemover(this, this.remainingBlocks);
        ScoreTrackingListener trackingListener = new ScoreTrackingListener(this.score);

        // Adding the blocks of the level to the environment of the game.
        for (Block block : this.levelInformation.blocks()) {
            block.addHitListener(blockRemover);
            block.addHitListener(trackingListener);
            block.addToGame(this);
        }
    }

    /**
     * The run method calls to the method createBallsOnTopOfPaddle that adds the balls to the game
     * and uses the runner to run the current animation which is one turn of the game.
     */
    public void run() {
        this.createBallsOnTopOfPaddle(this.levelInformation.numberOfBalls(),
                this.levelInformation.initialBallVelocities());

        // Countdown before turn starts.
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        this.running = true;

        // Use the runner to run the current animation which is one turn of the game.
        this.runner.run(this);
    }

    /**
     * The createBallsOnTopOfPaddle method creates balls on the top of the paddle, sets it's velocity
     * and adds it to the game.
     *
     * @param numOfBalls this is the number of balls in the level
     * @param ballsVelocitiesList this is a list of the balls velocities in the level
     */
    public void createBallsOnTopOfPaddle(int numOfBalls, List<Velocity> ballsVelocitiesList) {
        for (int i = 0; i < numOfBalls; i++) {
            Ball ball = new Ball(new Point(400, 555), 5, Color.WHITE);
            ball.setVelocity(ballsVelocitiesList.get(i));
            ball.addToGame(this);
        }
    }

    /**
     * The removeCollidable method removes collidables objects from the game environment.
     *
     * @param c This is a collidable object that we remove from the game environment.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidableFromList(c);
    }

    /**
     * The removeSprite method removes sprites objects from the game environment.
     *
     * @param s This is a sprite that we remove from the game environment.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSpriteFromList(s);
    }

    /**
     * The shouldStop method tells the animation it should stop.
     *
     * @return boolean This returns a boolean value
     */
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * The doOneFrame method does one frame of the animation on the DrawSurface.
     *
     * @param d This is a DrawSurface on which we do one frame of the animation
     */
    public void doOneFrame(DrawSurface d) {

        // Drawing all of the sprites objects
        this.sprites.drawAllOn(d);

        // Making the sprites objects to move
        this.sprites.notifyAllTimePassed();

        // In case all of the balls fell from the screen, end the game
        if (this.remainingBalls.getValue() == 0) {
            this.running = false;
        }

        // In case the level is cleared, add 100 points to the score and run the next level of the game.
        if (this.remainingBlocks.getValue()
                == this.levelInformation.blocks().size() - this.levelInformation.numberOfBlocksToRemove()) {
            this.score.increase(100);
            this.running = false;
        }

        // In case the key "p" is pressed, the game will stop.
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, this.keyboard.SPACE_KEY,
                    new PauseScreen(this.keyboard)));
        }
    }

    /**
     * The getNumOfBalls method returns the number of balls remaining in the gameLevel.
     *
     * @return int This returns the number of balls
     */
    public int getNumOfBalls() {
        return this.remainingBalls.getValue();
    }

    /**
     * The isRunning method returns a value that displays if the gameLevel is running on the screen.
     *
     * @return boolean This returns a boolean value
     */
    public boolean isRunning() {
        return this.running;
    }
}