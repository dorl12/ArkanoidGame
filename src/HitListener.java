// ID:313547085

/**
 * The main interface for HitListener.
 * This is an interface that includes a method that is called whenever the beingHit object is hit.
 *
 * @author Dor Levy
 */
public interface HitListener {

    /**
     * The hitEvent method is called whenever the beingHit object is hit.
     *
     * @param beingHit This is the block that is being hit
     * @param hitter This is a ball that hit the block
     */
    void hitEvent(Block beingHit, Ball hitter);
}
