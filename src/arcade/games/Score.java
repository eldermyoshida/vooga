package arcade.games;

import java.util.HashMap;
import java.util.Map;


/**
 * Data structure for representing a score in the view. Instantiated by the Database and
 * is read only.
 * 
 */
public class Score {
    String myGame;
    String myUser;
    double myScore;

    public Score (String gameName, String userName, double score) {
        myGame = gameName;
        myUser = userName;
        myScore = score;
    }

    protected String getGame () {
        return myGame;
    }

    protected String getUser () {
        return myUser;
    }

    protected double getScore () {
        return myScore;
    }

}
