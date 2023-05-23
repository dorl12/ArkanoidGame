// ID:313547085

/**
 * The main class for PrintingHitListener.
 * This is a program that prints every time a block was hit.
 *
 * @author Dor Levy
 */
public class PrintingHitListener implements HitListener {

    /**
     * The hitEvent method gets the block that is being hit and the ball hitter and prints every
     * time a block was hit.
     *
     * @param beingHit This is the block that is being hit
     * @param hitter This is a ball that hit the block
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A Block was hit.");
    }
}