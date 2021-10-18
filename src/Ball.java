// ID:313547085

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * The main class for Ball.
 * This is a program that defines a Ball,
 * draw it on the screen, set it's velocity makes it move on the screen and adds the ball to a game.
 *
 * @author Dor Levy
 */
public class Ball implements Sprite {

    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;

    /**
     * This method is a constructor of the Ball class.
     * The method Defines the class members.
     *
     * @param center This is the center point of the ball
     * @param r      This is the radius of the ball
     * @param color  This is the color of the ball
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;

        // Default value
        this.velocity = new Velocity(-1, 1);
    }

    /**
     * The getX method returns the x value of the center point of the ball.
     *
     * @return int This returns the x value of the Point.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * The getY method returns the y value of the center point of the ball.
     *
     * @return int This returns the y value of the Point.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * The getSize method returns the radius of the ball.
     *
     * @return int This returns the radius of the ball.
     */
    public int getSize() {
        return this.r;
    }

    /**
     * The getColor method returns the color of the ball.
     *
     * @return java.awt.Color This returns the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * The setVelocity method gets a velocity and sets it in the ball object.
     *
     * @param v This is the velocity of the ball.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * The getVelocity method returns the velocity of the ball.
     *
     * @return Velocity This returns the velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * The drawOn method gets a surface and draws the ball on the given DrawSurface.
     *
     * @param surface This is the DrawSurface on which we draw the ball.
     */
    public void drawOn(DrawSurface surface) {
        int x = this.getX();
        int y = this.getY();
        int ballRadius = this.getSize();
        java.awt.Color ballColor = this.getColor();
        // Setting the color of the ball
        surface.setColor(ballColor);
        // Filling the ball with the color
        surface.fillCircle(x, y, ballRadius);
        surface.setColor(Color.BLACK);
        surface.drawCircle(x, y, ballRadius);
    }

    /**
     * The moveOneStep method makes the ball to move according to it's velocity and it's trajectory on the screen.
     */
    public void moveOneStep() {

        // The trajectory of the ball on the screen.
        Line trajectory = new Line(this.center, this.getVelocity().applyToPoint(this.center));

        // In case no collision is going to happen according to the trajectory.
        if (this.gameEnvironment.getClosestCollision(trajectory) == null) {
            this.center = this.getVelocity().applyToPoint(this.center);

            // In case a collision is going to happen according to the trajectory.
        } else {
            this.center = new Point(this.center.getX() - 0.5 * this.getVelocity().getDx(),
                    this.center.getY() - 0.5 * this.getVelocity().getDy());
            Velocity newVelocity = this.gameEnvironment.getClosestCollision(trajectory).collisionObject().
                    hit(this, this.gameEnvironment.getClosestCollision(trajectory).collisionPoint(),
                            this.getVelocity());
            this.setVelocity(newVelocity);
        }

        // In case the ball is going to get into the paddle, change it's velocity.
        Rectangle paddle = gameEnvironment.getPaddle().getCollisionRectangle();
        if (this.center.getX() > paddle.getUpperLeft().getX() && this.center.getX() < paddle.getUpperLeft().getX()
                + paddle.getWidth() && this.center.getY() > paddle.getUpperLeft().getY() && this.center.getY()
                < paddle.getUpperLeft().getY() + paddle.getHeight()) {
            this.setVelocity(gameEnvironment.getPaddle().hit(this, this.center, this.velocity));
            this.center = this.getVelocity().applyToPoint(this.center);
        }
    }

    /**
     * The timePassed method notifies the ball that time has passed by calling to the method moveOneStep.
     */
    public void timePassed() {
        moveOneStep();
    }

    /**
     * The addToGame method adds the ball to the game.
     *
     * @param g This is a game.
     */
    public void addToGame(GameLevel g) {
        this.gameEnvironment = g.getGameEnvironment();
        g.addSprite(this);
    }
}
