package arcade.games;
import java.io.Serializable;

/**
 * This is the class a game uses for persistence of USER information.
 * at the very least your game should define a users score in a game.
 * Any other data, such as what level a user is on should be stored 
 * here in subclassed UserGameDatas.
 * @author Will Nance
 */
public abstract class UserGameData implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private double myStatistic;
    
    /**
     * Represents something like a score or a win/loss ratio or any number
     * that is relevant to how a user is performing.
     */
    protected double getStatistic () {
        return myStatistic;
    }

    /**
     * Lets the game update the user's statistic.
     */
    protected void setStatistic (double statistic) {
        myStatistic = statistic;
    }

  
}