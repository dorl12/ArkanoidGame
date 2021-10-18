// ID:313547085

/**
 * The main class for BallRemover.
 * This is a program that is in charge of removing balls from the game, as well as keeping count
 * of the number of balls that remain.
 *
 * @author Dor Levy
 */
public class BallRemover implements HitListener {

    private GameLevel game;
    private Counter remainingBalls;

    /**
     * This method is a constructor of the BallRemover class.
     * The method Defines the class members.
     *
     * @param game This is a game
     * @param remainingBalls This is a counter of the remaining balls
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }

    /**
     * The hitEvent method gets the block that is being hit and the ball hitter and removes the ball
     * from the game.
     *
     * @param beingHit This is the block that is being hit
     * @param hitter This is a ball that hit the block
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.game.removeSprite(hitter);

        // Decreases the number of remaining balls by 1
        this.remainingBalls.decrease(1);
    }
}