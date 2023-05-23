// ID:313547085

import java.util.ArrayList;
import java.util.List;

/**
 * The main class for GameEnvironment.
 * This is a program that defines a game environment, adds collidables to the
 * game environment and removes it and gets the closest collision info between the collidables
 * in the game environment and a trajectory of a line.
 *
 * @author Dor Levy
 */
public class GameEnvironment {

    private List<Collidable> collidablesArrayList;
    private Paddle paddle;

    /**
     * This method is a constructor of the GameEnvironment class.
     * The method Defines the collidablesArrayList member.
     */
    public GameEnvironment() {
        this.collidablesArrayList = new ArrayList<>();
    }

    /**
     * The setPaddle method sets the paddle member of the class.
     *
     * @param gamePaddle this is a paddle.
     */
    public void setPaddle(Paddle gamePaddle) {
        this.paddle = gamePaddle;
    }

    /**
     * The getPaddle method returns paddle member of the class.
     *
     * @return Paddle This returns the paddle member of the class.
     */
    public Paddle getPaddle() {
        return this.paddle;
    }

    /**
     * The addCollidable method gets a collidable object and adds it to the environment.
     *
     * @param c This is collidable object.
     */
    public void addCollidable(Collidable c) {
        collidablesArrayList.add(c);
    }

    /**
     * The CollisionInfo method gets a Line trajectory and returns the information
     * about the closest collision with any of the collidables
     * in this collection if it is going to occur, null otherwise.
     *
     * @param trajectory This is a trajectory of an object moving from line.start() to line.end().
     * @return CollisionInfo This returns the information about the closest collision if it is going to occur,
     * null otherwise.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        double distanceBetweenPoints = Double.MAX_VALUE;
        Point closestPoint = null;
        Collidable collisionObject = null;
        List<Collidable> collidablesArrayListCopy = new ArrayList<>(this.collidablesArrayList);

        // Finding the collisionObject and the closestPoint of the closest collision that is going to occur.
        for (int i = 0; i < collidablesArrayListCopy.size(); i++) {
            if (trajectory.closestIntersectionToStartOfLine(collidablesArrayListCopy
                    .get(i).getCollisionRectangle()) != null) {
                if (trajectory.start().distance(trajectory.closestIntersectionToStartOfLine(collidablesArrayListCopy
                        .get(i).getCollisionRectangle())) < distanceBetweenPoints) {
                    distanceBetweenPoints = trajectory.start().distance(trajectory.
                            closestIntersectionToStartOfLine(collidablesArrayListCopy.get(i).getCollisionRectangle()));
                    closestPoint = trajectory.closestIntersectionToStartOfLine(collidablesArrayListCopy
                            .get(i).getCollisionRectangle());
                    collisionObject = collidablesArrayListCopy.get(i);
                }
            }
        }

        // In case there is no collision with any of the collidables in the collection.
        if (closestPoint == null || collisionObject == null) {
            return null;
        }
        return new CollisionInfo(closestPoint, collisionObject);
    }

    /**
     * The removeCollidableFromList method removes collidables objects from the collidablesArray List.
     *
     * @param c This is a collidable object that we remove from the collidablesArray List.
     */
    public void removeCollidableFromList(Collidable c) {
        collidablesArrayList.remove(c);
    }
}
