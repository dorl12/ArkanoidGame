// ID:313547085

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * The main class for Paddle.
 * This is a program that defines a game paddle, it's ability to move right and left,
 * draws it on the screen and makes it move, defines the way a ball it's the paddle
 * and adds the paddle to a game.
 *
 * @author Dor Levy
 */
public class Paddle implements Sprite, Collidable {

    private static final double EPSILON = Math.pow(10, -10);
    private biuoop.KeyboardSensor keyboard;
    private Rectangle block;
    private Color color;
    private int leftBorder;
    private int rightBorder;
    private int paddleSpeed;

    /**
     * This method is a constructor of the Paddle class.
     * The method Defines the class members.
     *
     * @param block This is the shape of the paddle
     * @param color This is the color of the paddle
     * @param keyboard   This is the keyboard that makes the paddle move right and left
     * @param leftBorder   This is the left border of the paddle
     * @param rightBorder   This is the right border of the paddle
     * @param paddleSpeed   This is the speed of the paddle
     */
    public Paddle(Rectangle block, Color color, biuoop.KeyboardSensor keyboard, int leftBorder, int rightBorder,
                  int paddleSpeed) {
        this.block = block;
        this.color = color;
        this.keyboard = keyboard;
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
        this.paddleSpeed = paddleSpeed;
    }

    /**
     * The moveLeft method makes the paddle to move left.
     */
    public void moveLeft() {
        this.block.setUpperLeft(this.block.getUpperLeft().getX()
                - this.paddleSpeed, this.block.getUpperLeft().getY());
    }

    /**
     * The moveRight method makes the paddle to move right.
     */
    public void moveRight() {
        this.block.setUpperLeft(this.block.getUpperLeft().getX()
                + this.paddleSpeed, this.block.getUpperLeft().getY());
    }

    /**
     * The timePassed method notifies the paddle that time has passed and makes it move.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY) && this.block.getUpperLeft().getX() >= this.leftBorder) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY) && this.block.getUpperLeft().getX() + block.getWidth()
                <= this.rightBorder) {
            moveRight();
        }
    }

    /**
     * The drawOn method draws the paddle on the screen.
     *
     * @param d This is a DrawSurface on which we draw the paddle
     */
    public void drawOn(DrawSurface d) {
        Block paddleBlock = new Block(this.block, this.color);
        paddleBlock.drawOn(d);
    }

    /**
     * The getCollisionRectangle method returns the collision shape of the paddle.
     *
     * @return Rectangle This returns the collision shape of the paddle.
     */
    public Rectangle getCollisionRectangle() {
        return this.block;
    }

    /**
     * The hit method gets the collisionPoint and the currentVelocity of a ball and returns the
     * newVelocity of the ball after it hits the paddle.
     *
     * @param hitter this is a ball that hits the paddle
     * @param collisionPoint This is the collisionPoint of the ball with the paddle
     * @param currentVelocity This is the current velocity of the ball
     * @return Velocity This returns the new velocity of the ball after it hits the paddle
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity newVelocity = currentVelocity;

        // In case the ball hits the sides of the paddle
        if (EPSILON > Math.abs(collisionPoint.getX() - this.block.getUpperLeft().getX())
                || EPSILON > Math.abs(collisionPoint.getX()
                - (this.block.getUpperLeft().getX() + this.block.getWidth()))) {
            newVelocity = new Velocity(-1 * currentVelocity.getDx(), currentVelocity.getDy());
        }

        // In case the ball hits the left-most region (region 1) of the paddle
        if ((EPSILON > (this.block.getUpperLeft().getY() - collisionPoint.getY()) && ((collisionPoint.getX()
                > this.block.getUpperLeft().getX() && this.block.getUpperLeft().getX() + (this.block.getWidth() / 5)
                > collisionPoint.getX())))) {
            newVelocity = Velocity.fromAngleAndSpeed(300, currentVelocity.getSpeed());
        }

        // In case the ball hits region 2 of the paddle
        if (EPSILON > (this.block.getUpperLeft().getY() - collisionPoint.getY()) && ((collisionPoint.getX()
                > this.block.getUpperLeft().getX() + (this.block.getWidth() / 5) && this.block.getUpperLeft().getX()
                + 2 * (this.block.getWidth() / 5) > collisionPoint.getX()))) {
            newVelocity = Velocity.fromAngleAndSpeed(330, currentVelocity.getSpeed());
        }

        // In case the ball hits region 3 of the paddle
        if (EPSILON > (this.block.getUpperLeft().getY() - collisionPoint.getY()) && ((collisionPoint.getX()
                > this.block.getUpperLeft().getX() + 2 * (this.block.getWidth() / 5) && this.block.getUpperLeft().getX()
                + 3 * (this.block.getWidth() / 5) > collisionPoint.getX()))) {
            newVelocity = new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());
        }

        // In case the ball hits region 4 of the paddle
        if (EPSILON > (this.block.getUpperLeft().getY() - collisionPoint.getY()) && ((collisionPoint.getX()
                > this.block.getUpperLeft().getX() + 3 * (this.block.getWidth() / 5) && this.block.getUpperLeft().getX()
                + 4 * (this.block.getWidth() / 5) > collisionPoint.getX()))) {
            newVelocity = Velocity.fromAngleAndSpeed(30, currentVelocity.getSpeed());
        }

        // In case the ball hits region 5 of the paddle
        if (EPSILON > (this.block.getUpperLeft().getY() - collisionPoint.getY()) && ((collisionPoint.getX()
                > this.block.getUpperLeft().getX() + 4 * (this.block.getWidth() / 5) && this.block.getUpperLeft().getX()
                + this.block.getWidth() > collisionPoint.getX()))) {
            newVelocity = Velocity.fromAngleAndSpeed(60, currentVelocity.getSpeed());
        }
        return newVelocity;
    }

    /**
     * The addToGame method adds this paddle to the game.
     *
     * @param g This is a game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}
