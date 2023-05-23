// ID:313547085

/**
 * The main class for BlockRemover.
 * This is a program that is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 *
 * @author Dor Levy
 */
public class BlockRemover implements HitListener {

    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * This method is a constructor of the BlockRemover class.
     * The method Defines the class members.
     *
     * @param game This is a game
     * @param removedBlocks This is a counter of the remaining blocks
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * The hitEvent method gets the block that is being hit and the ball hitter and removes the blocks
     * that are hit from the game.
     *
     * @param beingHit This is the block that is being hit
     * @param hitter This is a ball that hit the block
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.game.removeCollidable(beingHit);
        this.game.removeSprite(beingHit);

        // Decreases the number of remaining blocks by 1
        this.remainingBlocks.decrease(1);

        // Remove this listener from the block that is being removed from the game.
        beingHit.removeHitListener(this);
    }
}