package vooga.fighter.controller;

import java.util.List;
import vooga.fighter.util.HUDVariable;

public class ScoreInfo extends DisplayInfo {
    
    @HUDVariable(
                 name = "Winner",
                 HUDElementClass = "EndMatchLayout"
            )
    private ScoreStatus myScoreStatus;
    
    public ScoreInfo() {
        super();
    }
    
    public void setWinners(List<Integer> winners) {
        myScoreStatus = new ScoreStatus(winners);
    }
    
    
}
