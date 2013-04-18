package vooga.fighter.controller;
import java.awt.Dimension;
import java.util.List;
import java.util.ArrayList;
import java.util.Observable;
import util.Location;
import vooga.fighter.model.LevelMode;
import vooga.fighter.model.Mode;
import vooga.fighter.model.utils.Health;
import vooga.fighter.model.utils.ImageDataObject;
import vooga.fighter.util.HUDVariable;
import vooga.fighter.util.Paintable;
import util.*;


/**
 * Contains all information required by the view about game objects in a game loop.
 * List indices line up between lists (i.e. index 0 of all lists is player 1 information,
 * index 1 is player 2 info)
 * @author matthewparides
 *
 */

public class GameLoopInfo extends DisplayLoopInfo implements ViewDataSource{

    private LevelMode myMode;
    private List<String> myCharacterNames;
    private List<Health> myHealthStats;
    private List<Dimension> myImageSizes;
    private List<Double> myScores;
    private List<PlayerStatus> myPlayerStats;

    @HUDVariable(
                 name = "Player1",
                 HUDElementClass = "PlayerScoreAndHealth"
            )
    private PlayerStatus Player1Status;

    @HUDVariable(
                 name = "Player2",
                 HUDElementClass = "PlayerScoreAndHealth"
            )
    private PlayerStatus Player2Status;

    @HUDVariable(
                 name = "Player3",
                 HUDElementClass = "PlayerScoreAndHealth"
            )
    private PlayerStatus Player3Status;

    @HUDVariable(
                 name = "Player4",
                 HUDElementClass = "PlayerScoreAndHealth"
            )
    private PlayerStatus Player4Status;

    public GameLoopInfo(Mode mode) {
    	super(mode);
    	myMode = (LevelMode) mode;
        myHealthStats = new ArrayList<Health>();
        myScores = new ArrayList<Double>();
        myCharacterNames = new ArrayList<String>();
        myPlayerStats = new ArrayList<PlayerStatus>();
        myPlayerStats.add(Player1Status);
        myPlayerStats.add(Player2Status);
        myPlayerStats.add(Player3Status);
        myPlayerStats.add(Player4Status);
    }
    
    @Override
    public void update() {
        super.update();
        //updatePlayerStats();
    }
    
    /**
     * Updates the information in the PlayerStatus objects to reflect the 
     * current data in this GameLoopInfo class.
     */
    public void updatePlayerStats() {
        for(int i = 0; i < 4; i++) {
            myPlayerStats.get(i).setName(myCharacterNames.get(i));
            myPlayerStats.get(i).setScore(myScores.get(i));
            myPlayerStats.get(i).setHealth(myHealthStats.get(i));
        }
    }



    /**
     * @return Health at list index
     */
    public Health getHealth(int index) {
        return myMode.getMyCharacterObjects().get(index).getHealth();
    }


    public Double getScore(int index) {
        return myScores.get(index);
    }

   

    /**
     * @return the myHealthStats
     */
    public List<Health> getHealthStats() {
        return myHealthStats;
    }

    /**
     * @param myHealthStats the myHealthStats to set
     */
    public void setHealthStats(List<Health> healthStats) {
        myHealthStats = healthStats;
    }

    public void setHealthStat(int index, Health heal) {
        myHealthStats.set(index, heal);
    }

    /**
     * @return the myImageSizes
     */

    /**
     * 
     */
    public void setScores(List<Double> scores) {
        myScores = scores;
    }


    /**
     * 
     */
    public void setScore(int index, double score) {
        myScores.set(index, score);
    }

    /**
     * 
     * @return
     */
    public List<Double> getScores() {
        return myScores;
    }


}
