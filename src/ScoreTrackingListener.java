// ID:313547085

/**
 * The main class for ScoreTrackingListener.
 * This is a program that is in charge of tracking the score of the game.
 *
 * @author Dor Levy
 */
public class ScoreTrackingListener implements HitListener {

    private Counter currentScore;

    /**
     * This method is a constructor of the ScoreTrackingListener class.
     * The method Defines the class members.
     *
     * @param scoreCounter This is a counter of the score
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * The hitEvent method gets the block that is being hit and the ball hitter and adds 5 points
     * to the current score every time the ball hits a block.
     *
     * @param beingHit This is the block that is being hit
     * @param hitter This is a ball that hit the block
     */
    public void hitEvent(Block beingHit, Ball hitter) {
       this.currentScore.increase(5);
    }
}