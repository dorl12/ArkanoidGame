// ID:313547085

import java.util.ArrayList;
import java.util.List;

/**
 * The main class for Ass6Game.
 * This is a program that Creates a game object, initializes and runs it.
 *
 * @author Dor Levy
 */
public class Ass6Game {

    /**
     * The main method.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        DirectHit firstLevel = new DirectHit();
        WideEasy secondLevel = new WideEasy();
        GreenThree thirdLevel = new GreenThree();
        FinalFour fourthLevel = new FinalFour();
        List<LevelInformation> levels = new ArrayList<>();
        GameFlow gameFlow = new GameFlow();

        // Iterating through the args and adding the suitable levels according to the args values.
        for (String arg : args) {
            if (arg.equals("1")) {
                levels.add(firstLevel);
            }
            if (arg.equals("2")) {
                levels.add(secondLevel);
            }
            if (arg.equals("3")) {
                levels.add(thirdLevel);
            }
            if (arg.equals("4")) {
                levels.add(fourthLevel);
            }
        }

        // In case there are no args or the args are not numbers of levels, run the four levels one by one
        if (levels.isEmpty()) {
            levels.add(firstLevel);
            levels.add(secondLevel);
            levels.add(thirdLevel);
            levels.add(fourthLevel);
        }
        gameFlow.runLevels(levels);
    }
}
