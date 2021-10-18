// ID:313547085

/**
 * The main interface for HitNotifier.
 * This is an interface that includes methods that add hitListeners to hit events and remove them.
 *
 * @author Dor Levy
 */
public interface HitNotifier {

    /**
     * The addHitListener method gets a HitListener and adds it to the hitListeners list.
     *
     * @param hl This is a HitListener
     */
    void addHitListener(HitListener hl);

    /**
     * The removeHitListener method gets a HitListener and removes it from the hitListeners list.
     *
     * @param hl This is a HitListener
     */
    void removeHitListener(HitListener hl);
}
