// ID:313547085

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * The main class for Background.
 * This is a program that defines the background of each one of the four levels of the game.
 *
 * @author Dor Levy
 */
public class Background implements Sprite {

    private String level;

    /**
     * This method is a constructor of the Background class.
     * The method Defines the class members.
     *
     * @param level this is a name of a level of the game
     */
    public Background(String level) {
        this.level = level;
    }

    /**
     * The backgroundDirectHit method sets the background of the first level of the game.
     *
     * @param d This is a DrawSurface
     */
    public void backgroundDirectHit(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 20, d.getWidth(), d.getHeight());
        d.setColor(Color.BLUE);
        d.drawCircle(400, 160, 60);
        d.drawCircle(400, 160, 90);
        d.drawCircle(400, 160, 120);
        d.drawLine(400, 180, 400, 300);
        d.drawLine(420, 160, 540, 160);
        d.drawLine(380, 160, 260, 160);
        d.drawLine(400, 140, 400, 20);
    }

    /**
     * The backgroundWideEasy method sets the background of the second level of the game.
     *
     * @param d This is a DrawSurface
     */
    public void backgroundWideEasy(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 20, d.getWidth(), d.getHeight());
        d.setColor(new Color(239, 231, 176));
        d.fillCircle(150, 150, 65);
        int startX = 30;
        int endX = 780;
        int numOfRays = 120;
        for (int i = 1; i <= numOfRays; ++i) {
            d.drawLine(150, 150, (endX - startX) / numOfRays * i, 250);
        }
        d.setColor(new Color(236, 215, 73));
        d.fillCircle(150, 150, 55);
        d.setColor(new Color(255, 225, 24));
        d.fillCircle(150, 150, 45);
    }

    /**
     * The backgroundGreenThree method sets the background of the third level of the game.
     *
     * @param d This is a DrawSurface
     */
    public void backgroundGreenThree(DrawSurface d) {
        d.setColor(new Color(42, 130, 21));
        d.fillRectangle(0, 20, d.getWidth(), d.getHeight());
        d.setColor(new Color(46, 42, 41));
        d.fillRectangle(65, 450, 100, 200);
        d.setColor(new Color(62, 58, 57));
        d.fillRectangle(100, 400, 30, 50);
        d.setColor(new Color(78, 74, 73));
        d.fillRectangle(110, 200, 10, 200);
        d.setColor(new Color(216, 172, 102));
        d.fillCircle(115, 200, 12);
        d.setColor(new Color(246, 77, 54));
        d.fillCircle(115, 200, 8);
        d.setColor(Color.WHITE);
        d.fillCircle(115, 200, 4);
        int startingX = 75;
        int startingY = 460;
        d.setColor(Color.WHITE);
        for (int numOfRows = 0; numOfRows < 5; numOfRows++) {
            for (int numOfColumns = 0; numOfColumns < 5; numOfColumns++) {
                d.fillRectangle(startingX + numOfColumns * 18, startingY + numOfRows * 32, 10, 25);
            }
        }
    }

    /**
     * The backgroundFinalFour method sets the background of the fourth level of the game.
     *
     * @param d This is a DrawSurface
     */
    public void backgroundFinalFour(DrawSurface d) {
        d.setColor(new Color(23, 136, 208));
        d.fillRectangle(0, 20, d.getWidth(), d.getHeight());
        d.setColor(Color.WHITE);
        for (int i = 0; i < 10; i++) {
            d.drawLine(105 + i * 10, 400, 80 + i * 10, 600);
        }
        d.setColor(new Color(204, 204, 204));
        d.fillCircle(100, 390, 25);
        d.fillCircle(120, 420, 30);
        d.setColor(new Color(187, 187, 187));
        d.fillCircle(140, 390, 30);
        d.setColor(new Color(170, 170, 170));
        d.fillCircle(160, 430, 25);
        d.fillCircle(180, 400, 30);
        d.setColor(Color.WHITE);
        for (int i = 0; i < 10; i++) {
            d.drawLine(605 + i * 10, 520, 580 + i * 10, 600);
        }
        d.setColor(new Color(204, 204, 204));
        d.fillCircle(605, 510, 23);
        d.fillCircle(620, 540, 27);
        d.setColor(new Color(187, 187, 187));
        d.fillCircle(640, 510, 29);
        d.setColor(new Color(170, 170, 170));
        d.fillCircle(660, 550, 22);
        d.fillCircle(680, 520, 32);
    }


    /**
     * The drawOn method gets a surface and draws the background of the suitable level
     * according to the name of the level.
     *
     * @param d This is the DrawSurface on which we draw the background.
     */
    public void drawOn(DrawSurface d) {
        if (this.level.equals("Direct Hit")) {
            this.backgroundDirectHit(d);
        }
        if (this.level.equals("Wide Easy")) {
            this.backgroundWideEasy(d);
        }
        if (this.level.equals("Green 3")) {
            this.backgroundGreenThree(d);
        }
        if (this.level.equals("Final Four")) {
            this.backgroundFinalFour(d);
        }
    }

    /**
     * The timePassed method notifies the background that time has passed and makes it move.
     * currently, the method does nothing.
     */
    public void timePassed() {
    }
}
