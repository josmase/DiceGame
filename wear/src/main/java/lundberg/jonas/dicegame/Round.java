package lundberg.jonas.dicegame;
import java.util.Random;

/**
 * Created by knugen on 11/10/15.
 * Round controls the actions that can be made
 * to change the current score of the round
 */
public class Round {

    /**
     * Saves the current score of this game
     */
    private int currentScore;

    /**
     * Random number generator
     */
    private final Random dice = new Random();

    /**
     * throws the dice and plays one round                           (1)
     * @return return the value of the dice throw
     */
    public int play(){
        return throwDice();
    }
    /**
     * returns the current score of the game                           (1)
     * @return the current score of the game
     */
    public int getScore(){
        return currentScore;
    }
    /**
     * adds the value of score to the current score                           (1)
     * <p>
     * Longer description. If there were any, it would be    [2]
     * @param  score the result from throwing the dice once          (3)
     */
    public void addScore(int score){
        currentScore += score;
    }
    /**
     * random number between 1 and 7                           (1)
     * <p>
     * generates a random number between 0 and 6 and then adding      [2]
     * one to get 1 to 7 as range simulating a dice throw.
     * @return return a random number between 1 and 7                  (3)
     */
    private int throwDice(){
        return dice.nextInt(6) + 1;
    }

}

