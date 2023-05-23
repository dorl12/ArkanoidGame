// ID:313547085

import biuoop.GUI;
import java.util.List;

/**
 * The main class for GameFlow.
 * This is a program that defines a class which is in charge of creating the different levels of the game,
 * and moving from one level to the next.
 *
 * @author Dor Levy
 */
public class GameFlow {

    private GUI gui;
    private AnimationRunner animationRunner;
    private Counter score;

    /**
     * This method is a constructor of the GameFlow class.
     * The method Defines the class members.
     */
    public GameFlow() {
        this.gui = new GUI("Arkanoid", 800, 600);
        this.animationRunner = new AnimationRunner(this.gui);
        this.score = new Counter(0);
    }

    /**
     * The runLevels method gets a list of the levels of the game and runs the levels on the screen.
     * In case all of the balls fell off the screen, the end screen of "game over" will appear on the screen.
     * In case the player cleared all of the levels of the game, the end screen of "you win" will appear on the screen.
     *
     * @param levels this is a list of the levels of the game
     */
    public void runLevels(List<LevelInformation> levels) {

        ScoreIndicator scoreIndicator = new ScoreIndicator(this.score);

        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.gui.getKeyboardSensor(), this.animationRunner, this.score);

            level.initialize();

            LevelNameIndicator levelNameIndicator = new LevelNameIndicator(levelInfo.levelName());

            level.addSprite(levelNameIndicator);

            level.addSprite(scoreIndicator);

            while (level.isRunning()) {
                level.run();
            }

            // If all of the balls fell off the screen, the end screen of "game over" will appear on the screen.
            if (level.getNumOfBalls() == 0) {
                this.animationRunner.run(new KeyPressStoppableAnimation(this.gui.getKeyboardSensor(),
                        this.gui.getKeyboardSensor().SPACE_KEY,
                        new EndScreenGameOver(this.gui.getKeyboardSensor(), this.score)));
                this.gui.close();
                return;
            }
        }

        // If the player cleared all of the levels, the end screen of "game over" will appear on the screen.
        this.animationRunner.run(new KeyPressStoppableAnimation(this.gui.getKeyboardSensor(),
                this.gui.getKeyboardSensor().SPACE_KEY,
                new EndScreenWin(this.gui.getKeyboardSensor(), this.score)));
        this.gui.close();
    }
}
