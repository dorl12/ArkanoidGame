// ID:313547085

import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;

/**
 * The main class for SpriteCollection.
 * This is a program that defines a collection of sprites,
 * adds sprites objects to the collection, notifies all the sprites
 * in the collection that time has passed and draws them on the screen.
 *
 * @author Dor Levy
 */
public class SpriteCollection {

    private List<Sprite> spriteArrayList;

    /**
     * This method is a constructor of the SpriteCollection class.
     * The method Defines the class members.
     */
    public SpriteCollection() {
        this.spriteArrayList = new ArrayList<>();
    }

    /**
     * The addSprite method adds a sprite to the spriteArrayList.
     *
     * @param s This is a sprite object
     */
    public void addSprite(Sprite s) {
        this.spriteArrayList.add(s);
    }

    /**
     * The notifyAllTimePassed method calls timePassed method on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spriteArrayListCopy = new ArrayList<>(this.spriteArrayList);
        for (Sprite s : spriteArrayListCopy) {
            s.timePassed();
        }
    }

    /**
     * The drawAllOn method calls drawOn method on all sprites.
     *
     * @param d This is a DrawSurface
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : spriteArrayList) {
            s.drawOn(d);
        }
    }

    /**
     * The removeSpriteFromList method removes a sprite from the spriteArrayList.
     *
     * @param s This is a sprite object that we remove from the spriteArrayList.
     */
    public void removeSpriteFromList(Sprite s) {
        this.spriteArrayList.remove(s);
    }
}
