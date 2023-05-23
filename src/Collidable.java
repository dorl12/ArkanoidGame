// ID:313547085

/**
 * The main interface for Collidable.
 * This is an interface that includes methods that gets the collision
 * shape of the collidable object and notifies the object that another
 * object collided with it and changes the velocity of the object.
 *
 * @author Dor Levy
 */
public interface Collidable {

    /**
     * The getCollisionRectangle method returns the collision shape of the object.
     *
     * @return Rectangle This returns the collision shape of the object
     */
    Rectangle getCollisionRectangle();

    /**
     * The hit method notifies the object that another object collided with it
     * at collisionPoint with a given velocity and returns the new velocity expected after the hit.
     *
     * @param hitter This is a ball that hits the collidable object
     * @param collisionPoint This is the collisionPoint with the objects
     * @param currentVelocity This is the current velocity of the other object
     * @return Velocity This returns the new velocity of the object
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
