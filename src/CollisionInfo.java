// ID:313547085

/**
 * The main class for CollisionInfo.
 * This is a program that defines the collision point and the object with whom
 * the collision occurred.
 *
 * @author Dor Levy
 */
public class CollisionInfo {

    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * This method is a constructor of the CollisionInfo class.
     * The method Defines the class members.
     *
     * @param collisionPoint This is the collision point with the object
     * @param collisionObject This is object with whom the collision occurred
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * The collisionPoint method returns the collision point with the object.
     *
     * @return Point This returns the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * The collisionObject method returns the collidable object involved in the collision.
     *
     * @return Collidable This returns the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}
