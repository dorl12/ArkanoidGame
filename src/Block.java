// ID:313547085

import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The main class for Block.
 * This is a program that defines a block, getting the collision shape of the block,
 * defining the way a ball hits the block, draws the block on the screen, adds
 * the block to a game, adds and removes a HitListener from the hitListeners list
 * and notifies all listeners about a hit event.
 *
 * @author Dor Levy
 */
public class Block implements Collidable, Sprite, HitNotifier {

    static final double EPSILON = Math.pow(10, -5);
    private Rectangle rectangle;
    private Color color;
    private List<HitListener> hitListeners;

    /**
     * This method is a constructor of the Block class.
     * The method Defines the class members.
     *
     * @param rectangle This is the shape of the block
     */
    public Block(Rectangle rectangle) {
        this.rectangle = rectangle;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * This method is a constructor of the Line class.
     * The method Defines the class members.
     *
     * @param rectangle This is the shape of the block
     * @param color     This is the color of the block
     */
    public Block(Rectangle rectangle, Color color) {
        this.rectangle = rectangle;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * The getRectangle method returns the shape of the block.
     *
     * @return Rectangle This returns the shape of the block
     */
    public Rectangle getRectangle() {
        return this.rectangle;
    }

    /**
     * The getCollisionRectangle method returns the collision shape of the block.
     *
     * @return Rectangle This returns the shape of the block
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * The hit method gets a collisionPoint and the currentVelocity of an object that hit this block
     * and returns the the new velocity expected after the hit.
     *
     * @param hitter this is a ball that hits this block
     * @param collisionPoint  This is the collision point between the object and this block
     * @param currentVelocity This is the current velocity of the object
     * @return Velocity This returns the new velocity of the object after the hit
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.notifyHit(hitter);
        Velocity newVelocity = currentVelocity;

        // In case the object hit the upper or lower side of the block
        if (EPSILON > Math.abs(collisionPoint.getY() - this.rectangle.getUpperLeft().getY())
                || EPSILON > Math.abs(collisionPoint.getY()
                - (this.rectangle.getUpperLeft().getY() + this.rectangle.getHeight()))) {
            return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        }

        // In case the object hit the left or right side of the block
        if (EPSILON > Math.abs(collisionPoint.getX() - this.rectangle.getUpperLeft().getX())
                || EPSILON > Math.abs(collisionPoint.getX()
                - (this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth()))) {
            return new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
        }
        return newVelocity;
    }

    /**
     * The drawOn method draws the block on the screen.
     *
     * @param d This is a DrawSurface on which we draw the block
     */
    public void drawOn(DrawSurface d) {
        java.awt.Color blockColor = this.color;
        d.setColor(blockColor);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
    }

    /**
     * The timePassed method notifies the block that time has passed and makes it move.
     * currently, the method does nothing.
     */
    public void timePassed() {
    }

    /**
     * The addToGame method gets a game and adds the block to the game.
     *
     * @param g This is a game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * The addHitListener method gets a HitListener and adds it to the hitListeners list.
     *
     * @param hl This is a HitListener
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * The removeHitListener method gets a HitListener and removes it from the hitListeners list.
     *
     * @param hl This is a HitListener
     */
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * The notifyHit method gets a ball hitter and notifies all listeners about a hit event with the hitter.
     *
     * @param hitter This is a Ball the hit a block
     */
    private void notifyHit(Ball hitter) {

        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);

        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
